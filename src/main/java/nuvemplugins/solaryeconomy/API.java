package nuvemplugins.solaryeconomy;

import java.util.List;

import com.redeskyller.bukkit.solaryeconomy.SolaryEconomy;
import com.redeskyller.bukkit.solaryeconomy.plugin.objetos.Account;

/**
 * Esta classe � para auxiliar na cria��o de novos plugins usando a api do
 * Solary-Economy
 *
 */

/*
 * Esta classe ser� removida nas proximas vers�es.
 */

@Deprecated
public class API {

	// Pega o magnata atual do servidor.
	public Account getMagnata()
	{
		return SolaryEconomy.getMagnata();
	}

	// Retorna true se a conta estiver com o coins desabilitado, ou false caso
	// contr�rio
	public boolean isToggle(String account)
	{
		return SolaryEconomy.isToggle(account);
	}

	// Retorna o money top atual do servidor.
	public List<Account> getMoneyTop()
	{
		return SolaryEconomy.getMoneyTop();
	}

	/*
	 * Voc� pode usar a classe 'Economia' para integrar qualquer plugin ao
	 * Solary-Economy *
	 */
}
