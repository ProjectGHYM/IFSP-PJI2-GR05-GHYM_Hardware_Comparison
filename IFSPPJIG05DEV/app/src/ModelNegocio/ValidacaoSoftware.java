package ModelNegocio;

import javax.swing.JOptionPane;
import ModelDAO.SoftwareBD;
import ModelEntidade.Software;
import View.Exibicao;

public class ValidacaoSoftware 
{
    public int indice;

    public byte procuraSoftwareNome(String nomeSoftware)
	{
        Exibicao exibe = new Exibicao();
        if(exibe.confirmaSoftware(nomeSoftware) == JOptionPane.YES_OPTION)
        {
            
            boolean opcao = false;
            for (byte i = 0; i < SoftwareBD.listaSoftware.length; ++i) 
            {
                if (nomeSoftware.equalsIgnoreCase(SoftwareBD.listaSoftware[i].getNome())) 
                {
                    nomeSoftware = SoftwareBD.listaSoftware[i].getNome();
                    opcao = true;
                    indice = i;  
                }
            }

            if (opcao)
            {
                return 1;
            }

            else
            {
                exibe.softwareInexistente();
                return 0;
            }
        }
        else
        {
            return 0;
        }

	}
}
