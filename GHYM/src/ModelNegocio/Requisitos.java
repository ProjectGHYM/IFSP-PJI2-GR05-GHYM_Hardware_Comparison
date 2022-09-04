package ModelNegocio;

import ModelDAO.SoftwareDAO;

public class Requisitos 
{
	public String verifSoftware(String nome, byte tipo)
	{
		SoftwareDAO soft = new SoftwareDAO();
		return soft.achaRec(nome, tipo);
	}
}
