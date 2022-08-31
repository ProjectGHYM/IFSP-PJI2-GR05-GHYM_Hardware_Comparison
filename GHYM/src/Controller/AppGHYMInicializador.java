package Controller;

import ModelNegocio.Recomendacao;
import View.Exibicao;

public class AppGHYMInicializador
{
	public static void main(String[] args) 
	{
		Exibicao exibir = new Exibicao();
		Recomendacao recomendacao = new Recomendacao();
		
		exibir.HiSystem();
		String nomesoft = exibir.veSoftware();
		
		for(byte i = 0; i < 3; i++)
		{
			String recomenda = recomendacao.verifSoftware(nomesoft, i);
			exibir.exiberecomendacao(recomenda, i);
		}
	}
}