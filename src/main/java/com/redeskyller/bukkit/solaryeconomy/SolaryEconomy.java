package com.redeskyller.bukkit.solaryeconomy;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.redeskyller.bukkit.solaryeconomy.commands.SolaryCommand;
import com.redeskyller.bukkit.solaryeconomy.database.Database;
import com.redeskyller.bukkit.solaryeconomy.database.MySQL;
import com.redeskyller.bukkit.solaryeconomy.database.SQLite;
import com.redeskyller.bukkit.solaryeconomy.hook.PlaceholdersHook;
import com.redeskyller.bukkit.solaryeconomy.hook.VaultEconomy;
import com.redeskyller.bukkit.solaryeconomy.listeners.EconomyPlayerListener;
import com.redeskyller.bukkit.solaryeconomy.runnables.RefreshMoneyTop;
import com.redeskyller.bukkit.solaryeconomy.util.Configuration;
import com.redeskyller.bukkit.solaryeconomy.util.CurrencyFormatter;
import com.redeskyller.bukkit.solaryeconomy.util.Messages;

public class SolaryEconomy extends JavaPlugin {

	private static SolaryEconomy instance;

	public static Configuration config;
	public static Messages messages;

	public static Database database;
	public static String tableName;

	public static Economia economia;
	public static RefreshMoneyTop refreshMoneyTop;

	public static VaultEconomy vaultEconomy;

	public static CurrencyFormatter currencyFormatter;

	@Override
	public void onEnable() {
		instance = this;

		config = new Configuration(this, new File(getDataFolder(), "config.yml")).load();

		setupDatabase();

		messages = new Messages(this).load();
		economia = new Economia().load();
		refreshMoneyTop = new RefreshMoneyTop().load();

		loadCurrencyFormatter();

		if (config.getBoolean("use_vault"))
			setupVault();

		getServer().getPluginManager().registerEvents(new EconomyPlayerListener(), getInstance());

		getCommand("money").setExecutor(new SolaryCommand("money"));

		if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null)
			PlaceholdersHook.install();

		Bukkit.getConsoleSender().sendMessage("§a[SolaryEconomy] Plugin habilitado com sucesso!");
		Bukkit.getConsoleSender().sendMessage("");
		Bukkit.getConsoleSender().sendMessage("§a[SolaryEconomy] §f§lForked §fby 0xflucas, version: §a" + this.getDescription().getVersion() + "!");
		Bukkit.getConsoleSender().sendMessage("");

	}

	@Override
	public void onDisable() {
		economia.saveAll();
		SolaryEconomy.getInstance().getLogger().info("");
		SolaryEconomy.getInstance().getLogger().info("[Solary-Economy] Salvando dados de economia....");
		SolaryEconomy.getInstance().getLogger().info("[Solary-Economy] Dados salvos com sucesso.");
		SolaryEconomy.getInstance().getLogger().info("");
		database.endConnection();
		if (vaultEconomy != null)
			vaultEconomy.unregister();
	}

	private void setupDatabase() {
		try {

			FileConfiguration config = getConfig();

			if (config.getBoolean("mysql.enable")) {
				tableName = config.getString("mysql.table");
				database = new MySQL(this);
			} else {
				tableName = ("solaryeconomy");
				database = new SQLite(this);
			}

			database.execute(
					"CREATE TABLE IF NOT EXISTS " + tableName + " (name varchar(40), valor text, toggle int);");

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void setupVault() {
		try {
			Plugin vault = Bukkit.getPluginManager().getPlugin("Vault");

			if (vault != null)
				vaultEconomy = new VaultEconomy().register();

			Plugin legendchat = Bukkit.getPluginManager().getPlugin("Legendchat");
			if (legendchat != null) {
				Class<?> listener_clazz = Class
						.forName("com.redeskyller.bukkit.solaryeconomy.hook.LegendChatListeners");
				Object listener = listener_clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
				Bukkit.getServer().getPluginManager().registerEvents((Listener) listener, this);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public CurrencyFormatter loadCurrencyFormatter() {

		if (config.contains("abbreviations") &&
				(config.getBoolean("abbreviations.enable.messages") || config.getBoolean("abbreviations.enable.commands"))) {

			ConfigurationSection dictionarySection = config.getConfigurationSection("abbreviations.dictionary");
			if (dictionarySection != null) {
				getLogger().info("Carregando dicionário de abreviações:");

				TreeMap<BigDecimal, String> dictionary = new TreeMap<>();
				Map<String, String> displays = new HashMap<>();

				for (String key : dictionarySection.getKeys(false)) {
					ConfigurationSection value = dictionarySection.getConfigurationSection(key);
					dictionary.put(new BigDecimal(value.getDouble("divider")), key);

					String display = value.getString("display");
					if (display != null && !display.trim().isEmpty()) {
						displays.put(key, display);
					}

					getLogger().info("Carregando abreviação: " + key + ", " + display + ", "
							+ value.getDouble("divider"));
				}

				currencyFormatter = new CurrencyFormatter(dictionary, displays);
				getLogger().info("Sistema de abreviações carregado com sucesso.");
			}
		}

		return currencyFormatter;
	}

	public static String numberFormat(BigDecimal bigDecimal) {

		if (currencyFormatter != null && config.getBoolean("abbreviations.enable.messages")) {
			return currencyFormatter.abbreviate(bigDecimal);
		} else {
			String formated = "";
			double doubleValue = bigDecimal.doubleValue();
			DecimalFormat decimalFormat = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.GERMAN));
			formated += decimalFormat.format(bigDecimal);

			if ((doubleValue >= -1) && (doubleValue <= 1))
				formated += " " + config.getString("currency_name.singular");
			else
				formated += " " + config.getString("currency_name.plural");

			return formated;
		}
	}

	public static SolaryEconomy getInstance() {
		return instance;
	}

	public static RankAccount getMagnata() {
		return economia.getMagnata();
	}

	public static boolean isToggle(String account) {
		return economia.isToggle(account);
	}

	public static List<RankAccount> getMoneyTop() {
		return economia.getMoneyTop();
	}

}
