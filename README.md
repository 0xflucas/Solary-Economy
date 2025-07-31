<img src="https://avatars.githubusercontent.com/u/30272840?s=96&v=4" alt="Sr_Edition" title="Sr_Edition" align="right" height="96" width="96"/>

# 🎮 Solary-Economy 💸

## The Ultimate Economy System for Your Minecraft Server

[![GitHub All Releases](https://img.shields.io/github/downloads/sredition/Solary-Economy/total.svg?logoColor=fff)](https://github.com/sredition/Solary-Economy/releases/latest)

---

**Solary-Economy** is a robust, lightweight, and highly customizable economy plugin designed specifically for Minecraft servers running version **1.8**. It offers a complete economy management experience — from basic operations like balance checking and transfers to advanced features such as leaderboards, plugin integrations, and support for multiple databases. If you're looking for a reliable, efficient, and easy-to-use economy system, **Solary-Economy** is the perfect choice.

### 🌟 Main Features

**1. Full Economy Management**

* Create, delete, and manage player accounts via console or in-game commands.
* Easily set, add, or remove player balances with intuitive commands.
* Transfer money securely and quickly between players.

**2. Richest Player Leaderboard**

* Display the top richest players using `/money top`.
* Customize how many players are shown and how often the leaderboard updates.
* Highlight the server’s **wealthiest player** with a custom tag in chat.

**3. Vault Integration**

* Compatible with the **Vault** API for seamless interaction with other plugins.
* Supports placeholders to display balances and other info in chat or scoreboards.

**4. Value Abbreviations**

* Shorten large amounts (thousands, millions, billions) with customizable suffixes (e.g., 1k, 1M, 1B).
* Configure decimal places and divisors for each abbreviation.

**5. Multi-Database Support**

* Choose between **SQLite** (default) or **MySQL** to store economy data.
* Easily configure database settings via the `config.yml` file.

**6. Full Customization**

* Edit all plugin messages in `mensagens.yml` to match your server’s style.
* Define singular and plural currency names to create a unique economy.

**7. Commands & Permissions**

* Easy-to-use commands like `/money`, `/money pay`, `/money top`, `/money magnata`, and more.
* Detailed permission system to control access to each feature.

**8. Developer API**

* Integrate **Solary-Economy** into your own plugins with a simple and powerful API.
* Access data like the current magnate, top player rankings, and player balances.

**9. Lightweight & Efficient**

* Built for performance, designed to minimize server load.
* Ideal for small, medium, and large servers alike.

### 🎯 Why Use Solary-Economy?

* **User-Friendly**: Simple commands and intuitive configuration make it easy for admins of all skill levels.
* **Customizable**: Adapt everything to your server’s theme — from messages to currency names.
* **Compatible**: Works flawlessly with popular plugins like **Vault**, **PlaceholderAPI**, and **LegendChat**.
* **Reliable**: Stable and well-tested system that ensures player data is safe.
* **Dev-Friendly**: A clean and easy-to-use API for custom integrations.

---

## ⚙️ Commands

```text
/money                        - View your current balance.
/money <player>              - View another player's balance.
/money create <name> <amount> - Create a new account.
/money delete <name>         - Delete an account.
/money pay <player> <amount> - Send money to another player.
/money set <player> <amount> - Set a player's balance.
/money add <player> <amount> - Add money to a player's account.
/money remove <player> <amount> - Remove money from a player's account.
/money toggle                - Enable/disable receiving money.
/money top                  - View the richest players.
/money magnata              - View the current server magnate.
/money reload               - Reload config and message files.
/money help                 - View the list of available commands.
```

---

## 🔒 Permissions

```text
solaryeconomy.commands.money.other   - Use /money <player>
solaryeconomy.commands.top           - Use /money top
solaryeconomy.commands.criar         - Use /money create
solaryeconomy.commands.deletar       - Use /money delete
solaryeconomy.commands.add           - Use /money add
solaryeconomy.commands.remove        - Use /money remove
solaryeconomy.commands.set           - Use /money set
solaryeconomy.commands.pay           - Use /money pay
solaryeconomy.commands.toggle        - Use /money toggle
solaryeconomy.commands.reload        - Use /money reload
solaryeconomy.commands.magnata       - Use /money magnata
```

---

## 📜 `config.yml`

```yaml
#########################[ Solary-Economy ]#########################
##                                                                ##
##       Found a bug? Please report it!                           ##
##                                                                ##
##       Email: theprog.matheus@gmail.com                         ##
##       Discord: sr_edition                                      ##
##                                                                ##
####################################################################

#/------------------------------------------------------------------/
#     Author: ${project.author}
#     Version: ${project.version}
#/------------------------------------------------------------------/

# Database Configuration

mysql:
  # Set to true to use MySQL. If false, SQLite (file "storage.db") will be used
  enable: false
  # Set your database host, e.g., "localhost"
  # If your MySQL runs on a different port, specify it (e.g., "localhost:2789")
  hostname: "localhost"
  # Your database name, e.g., "minecraft"
  database: "minecraft"
  # Your database username
  username: "root"
  # Your database password
  password: ""
  # Table name used by the plugin
  table: "solaryeconomy"

# General plugin configuration

# Main world name
world: "world"

# Enable Vault API integration (recommended for compatibility with other plugins)
use_vault: true

# Starting money for new players
start_value: 0

# Money Top (leaderboard) configuration
economy_top:

  # Number of players shown in /money top
  size: 10

  # Time interval (in seconds) to refresh the leaderboard (e.g., 300 = 5 minutes)
  refresh_time: 300

  # Enable prefixes in the money top (requires Vault)
  prefix: true

  # Max account name length to show on leaderboard (useful to hide faction names)
  # If the account name is longer than this, it will not appear in /money top or receive the magnate tag
  name_size: 16

# Server currency configuration
currency_name:

  # Currency name in plural (e.g., coins)
  plural: coins

  # Currency name in singular (e.g., coin)
  singular: coin

# Enable magnate tag in leaderboard/chat (requires LegendChat plugin)
# Use the tag {solary_economy_magnata} in LegendChat
magnata_tag: true

# Broadcast a message to all players when a new magnate is crowned
magnata_broadcast: true

# Value abbreviations configuration (useful for OP economies)
abbreviations:

  # Enable or disable abbreviation features
  enable:
    # Abbreviate values in messages
    messages: true
    # Abbreviate values in commands
    commands: true

  # Number of decimal places shown in abbreviations (e.g., 1.5k instead of 1k)
  decimal_places: 1

  # Abbreviation dictionary (you can add as many as you like)
  dictionary:

    # Thousand
    k:
      # How it appears in messages (e.g., 32k)
      display: "k"
      # Divider used (e.g., 1k = 1000)
      divider: 1000

    # Million
    m:
      display: "m"
      divider: 1000000

    # Billion
    b:
      display: "b"
      divider: 1000000000

    # Trillion
    t:
      display: "t"
      divider: 1000000000000

# Permissions:
#
###################[Commands]#######################
#
# /money - no permission required
# /money help - no permission required
# /money [player] - solaryeconomy.commands.money.other
# /money top - solaryeconomy.commands.top
# /money create - solaryeconomy.commands.criar
# /money delete - solaryeconomy.commands.deletar
# /money add - solaryeconomy.commands.add
# /money remove - solaryeconomy.commands.remove
# /money set - solaryeconomy.commands.set
# /money pay - solaryeconomy.commands.pay
# /money toggle - solaryeconomy.commands.toggle
# /money reload - solaryeconomy.commands.reload
# /money magnata - solaryeconomy.commands.magnata
#
###################[Commands]#######################

###################[Placeholders]#######################
#
# %solaryeconomy_balance% - Player's raw balance
# %solaryeconomy_balance_formatted% - Player's formatted balance
#
###################[Placeholders]#######################
```

---

## 📜 `mensagens.yml`

```yaml
#/------------------------------------------------------------------/
#     Autor: ${project.author}
#     Versão: ${project.version}
#/------------------------------------------------------------------/




#configurações de todas as mensagens do Solary-Economy

NO_PERMISSION: "&cVocê não tem permissão para isso."
PLAYER_NOTFOUND: "&cJogador não encontrado em nosso banco de dados."
MONEY: "&aMoney: {valor}"
NO_MONEY: "&cVocê não tem money suficiente para isso."
MONEY_TOGGLE: "&aRecebimento de coins: {toggle}"
MONEY_TOGGLED: "&cEste jogador está com o recebimento de coins desativado."
MONEY_OTHER: "&aMoney de {player}: {valor}"
MONEY_TOP_NULL: "&cNão existe jogadores cadastrados ainda."
MONEY_TOP_TITLE: "&2Top 10 Mais Ricos &7(Atualizado de 5 em 5 minutos)"
MONEY_TOP_FORMAT: "&a{i}. &2{player}: &7({valor})"
NUMBER_NULL: "&cValor incorreto, por favor insira um valor válido."
ACCOUNT_EXISTS: "&cJá existe uma conta com o nome '{nome}'!"
ACCOUNT_CREATE: "&aConta '{nome}' criada com sucesso!"
ACCOUNT_DELETE: "&aConta '{nome}' deletada com sucesso!"
ACCOUNT_NOFOUND: "&cConta '{nome}' não encontrada em nosso banco de dados."
MONEY_SET: "&aFoi setado a quantia de {valor} na conta de {player} "
MONEY_ADD: "&aFoi adicionado a conta de {player} a quantia de {valor}"
MONEY_REMOVE: "&aFoi removido a quantia de {valor} da conta de {player} "
MONEY_PAY_SENDER: "&aVocê enviou {valor} para {player}"
MONEY_PAY_RECEIVER: "&aVocê acaba de receber {valor} de {player}"
MONEY_PAY_ERRO: "&cVocê não pode enviar coins a si mesmo."
MAGNATA_TAG: "&2[$] "
MAGNATA_VIEW: "&2[$] &aAtual magnata do servidor: &7{player} &7com a quantia de {valor}"
MAGNATA_NEW: "&2[$] &aNovo magnata: &7{player} &7com a quantia de {valor}"
MAGNATA_NOT_FOUND: "&2[$] &cNenhum magnata ainda."
```

---

## 💻 How to Add Solary-Economy to Your Maven Project

### 1. Add the Maven Repository

In your `pom.xml` inside `<repositories>`:

```xml
<repositories>
    <repository>
        <id>github-theprogmatheus-maven-repository</id>
        <url>https://raw.githubusercontent.com/theprogmatheus/maven-repository/master/</url>
    </repository>
</repositories>
```

### 2. Add the Dependency

Inside `<dependencies>`:

```xml
<dependency>
    <groupId>com.redeskyller.bukkit.solaryeconomy</groupId>
    <artifactId>Solary-Economy</artifactId>
    <version>1.5.3</version>
    <scope>provided</scope>
</dependency>
```

---

### 3. Using the API

```java
import com.redeskyller.bukkit.solaryeconomy.SolaryEconomy;
import com.redeskyller.bukkit.solaryeconomy.manager.Economia;
import com.redeskyller.bukkit.solaryeconomy.objects.RankAccount;

import java.util.List;

public class YourPlugin {

    public void yourMethod() {
        // Get the current magnate
        RankAccount magnate = SolaryEconomy.getMagnata();
        System.out.println("Current magnate: " + magnate.getName() + " with " + magnate.getBalance());

        // Get the leaderboard
        List<RankAccount> leaderboard = SolaryEconomy.getMoneyTop();
        for (RankAccount account : leaderboard) {
            System.out.println(account.getName() + ": " + account.getBalance());
        }

        // Access the economy manager
        Economia economy = SolaryEconomy.economia;
        BigDecimal balance = economy.getBalance("PlayerName");
        System.out.println("Player balance: " + balance);
    }
}
```

---

## 💙 About the Project

**Solary-Economy** is an **open source** project built with passion and dedication for the Minecraft community. With over **8 years of development**, it has improved over time thanks to server feedback and contributions.

### 🤝 Contributions Welcome!

This is a community-driven project. You can:

* Send **pull requests** with improvements or bug fixes.
* Report **issues** and suggest new features.
* Share your feedback to make **Solary-Economy** even better.

Every contribution counts and helps keep the project alive and evolving!

### 🙏 Special Thanks

Thanks to all users and supporters of **Solary-Economy** over the years. You are the reason this project keeps growing stronger. Let’s continue building an amazing economy system for Minecraft servers together! 💰
