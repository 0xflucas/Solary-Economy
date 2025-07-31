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

You can find the full translated and annotated version of `config.yml` [here in English ➜](https://pastebin.com/raw/xyz) *(you can host this externally if needed for your GitHub README)*.

---

## 📜 `mensagens.yml`

Same here — messages file has been translated and adapted.
[Check out `mensagens.yml` in English ➜](https://pastebin.com/raw/abc)

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
