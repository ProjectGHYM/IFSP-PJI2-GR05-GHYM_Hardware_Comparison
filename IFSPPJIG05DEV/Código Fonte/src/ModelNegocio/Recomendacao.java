package ModelNegocio;

import ModelDAO.SoftwareDAO;

public class Recomendacao 
{
	public String verifSoftware(String nome, byte tipo)
	{
		SoftwareDAO soft = new SoftwareDAO();
		return soft.achaRec(nome, tipo);
	}
}
