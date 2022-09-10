package Controller;

import ModelNegocio.Requisitos;
import View.Exibicao;

public class AppGHYMInicializador
{
	public static void main(String[] args) 
	{
		boolean loopOn = true;
		String nomesoft;
		Exibicao exibir = new Exibicao();
		Requisitos recomendacao = new Requisitos();
		
		exibir.HiSystem();
		
		while(loopOn)
		{
			nomesoft = exibir.veSoftware();

			if(exibir.confirmaSoftRec(nomesoft) == 0)
			{
				for(byte i = 0; i < 3; i++)
				{
					String recomenda = recomendacao.verifSoftware(nomesoft, i);
					exibir.exiberecomendacao(recomenda, i);
				}
			}
			
			loopOn = exibir.continuar();
			
		}
		
	}
}