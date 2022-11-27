package View;

import java.util.SortedSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ModelEntidade.Software;

public class SoftwareView extends ViewMae
{
    
    public String leSoftware() 
	{
        Icon icone = new ImageIcon(getFornecedor().getURL("icone-leitura.png"));
		String nomeSoftware = (String) JOptionPane.showInputDialog(null, "Insira o nome do software:",
				getTITLE() + "/configuracao-para-softwares", JOptionPane.PLAIN_MESSAGE, icone, null, null);
		
		if (nomeSoftware.equals("")) 
		{
			nomeSoftware = null;
		}

		janelaFechada(nomeSoftware, null);
		
		return nomeSoftware;
	}

    public boolean confirmaAdicaoListaSoftware(Software soft)
	{
		Icon icone = new ImageIcon(getFornecedor().getURL(soft));

		int opcao = JOptionPane.showConfirmDialog(null, "Software encontrado:\n" + soft.getNome() + "\nDeseja o adicionar em sua lista?", 
			getTITLE() + "confirmacao-de-software-a-ser-adicionado", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icone);
		
		return opcao == JOptionPane.YES_OPTION ? true : false;
	}

    public void softwareInexistente()
	{
		JOptionPane.showMessageDialog(null, "Software Inexistente!", getTITLE() + "/not-found", JOptionPane.ERROR_MESSAGE);
	}

    public boolean continuaLendoSoftware(SortedSet<Software> softwareEscolhido) 
	{
		String softwareAtual = "Softwares Digitados até Agora:";
		
		for (Software softwareJaEscolhido : softwareEscolhido)
		{
			softwareAtual += String.format("\n-" + softwareJaEscolhido.getNome());
		}

		int opcao = JOptionPane.showConfirmDialog(null, softwareAtual + "\nDeseja Escolher Outro Softare Além Do(s) Já Escolhido(s):",
		getTITLE() + "/escolhas-de-software", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		janelaFechada(opcao, JOptionPane.CLOSED_OPTION);
		
		if (opcao == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
