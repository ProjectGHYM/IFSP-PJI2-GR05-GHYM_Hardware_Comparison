package ModelNegocio;

import ModelDAO.SoftwareBD;
import ModelEntidade.Software;

public class ValidacaoSoftware 
{
    private Software softwareAchado;

    public boolean procuraSoftwareNome(String nomeSoftware)
	{
         for (byte i = 0; i < SoftwareBD.listaSoftware.length; ++i) 
        {
            if (nomeSoftware.equalsIgnoreCase(SoftwareBD.listaSoftware[i].getNome())) 
            {
                softwareAchado = SoftwareBD.listaSoftware[i];
                return true;
            }
        }

        return false;
	}

    public Software getSoftwareAchado()
    {
        return softwareAchado;
    }
}
