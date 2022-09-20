package Controller;

import ModelNegocio.Requisitos;
import View.Exibicao;

public class AppGHYMInicializador
{
	public static void main(String[] args) 
	{
		boolean loopOn = true;
		String nomesoft;
		Exibicao objexibir = new Exibicao();
		Requisitos objrequisito = new Requisitos();
		
		objexibir.HiSystem();
		
		while(loopOn)
		{
			nomesoft = objexibir.veSoftware();

			if(objexibir.confirmaSoftRec(nomesoft) == 0)
			{
				for(byte i = 0; i < 3; i++)
				{
					String recomenda = objrequisito.verifSoftware(nomesoft, i);
					objexibir.exiberecomendacao(recomenda, i);
				}
			}
			
			loopOn = objexibir.continuar();
			
		}
		
	}
}