package View;

import java.util.SortedSet;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ModelEntidade.CPU;
import ModelEntidade.GPU;
import ModelEntidade.RAM;
import ModelEntidade.Software;

public class Exibicao extends ViewMae
{
	public Exibicao()
	{}
	
	public Exibicao(boolean ApresentarMensagemBoasVindas) 
	{
		if(ApresentarMensagemBoasVindas)
		{
			Icon icone = new ImageIcon(getFornecedor().getURL("boas-vindas.png"));
			int opcao = JOptionPane.showConfirmDialog(null, "Bem-vindo ao Software da GHYM!", getTITLE(),
			JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_OPTION, icone);
			janelaFechada(opcao, JOptionPane.CLOSED_OPTION);
		}
	}

	public boolean continuar() 
	{
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar na aplicação? ", getTITLE() + "/continuar",
			JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		janelaFechada(opcao, JOptionPane.CLOSED_OPTION); 
		return opcao == 1 || opcao == 2 ? false : true;
	}

	public void exibirConfiguraçãoMinima(SortedSet<Software> softwareEscolhido, CPU listaNomeCPU[], GPU listaNomeGPU[], RAM listaNomeRAM[]) 
	{
		String telaFinal, titulo = "/configuracoes-minimas-possiveis";
		int cortaLinha = 0;

		if (softwareEscolhido.size() > 1) 
		{
			telaFinal = "Requisitos Mínimos" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		} 
		else 
		{
			telaFinal = softwareEscolhido.last().getNome() + "\nRequisitos Mínimos" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		}
	}

	public void exibirConfiguraçãoRecomendada(SortedSet<Software> softwareEscolhido, CPU listaNomeCPU[], GPU listaNomeGPU[], RAM listaNomeRAM[]) 
	{
		String telaFinal, titulo = "/configuracoes-recomendadas-possiveis";
		int cortaLinha = 0;
		if (softwareEscolhido.size() > 1) 
		{
			telaFinal = "Requisitos Recomendados" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		} 
		else 
		{
			telaFinal = softwareEscolhido.last().getNome() + "\nRequisitos Recomendados" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		}
	}

	public void exibirConfiguração(int cortaLinha, String telaFinal, String titulo, CPU listaNomeCPU[], GPU listaNomeGPU[], RAM listaNomeRAM[]) 
	{
		for (int i = 0; i < 15; ++i) 
		{
			if (cortaLinha % 5 == 0 && i > 0) 
			{
				telaFinal += "\n";
			}
			if (i < (listaNomeCPU.length - 1)) 
			{
				telaFinal += listaNomeCPU[i].getNome() + ", 		";
			}
			if (i == 14 && listaNomeCPU.length >= 14) 
			{
				telaFinal += listaNomeCPU[i].getNome() + ".";
			}
			++cortaLinha;
		}

		cortaLinha = 0;
		telaFinal += "\n\nPlaca de Vídeo: ";
		for (int i = 0; i < 10 ; ++i) 
		{
			if (cortaLinha % 3 == 0 && i > 0) 
			{
				telaFinal += "\n";
			}
			if (i < (listaNomeGPU.length - 1)) 
			{
				telaFinal += listaNomeGPU[i].getNome() + ", 		";
			}
			if (i == 9 && listaNomeGPU.length >= 9) 
			{
				telaFinal += listaNomeGPU[i].getNome() + ".";
			}
			++cortaLinha;
		}

		cortaLinha = 0;
		telaFinal += "\n\nRAM: ";
		for (int i = 0; i < 15; ++i) 
		{
			if (cortaLinha % 3 == 0 && i > 0) 
			{
				telaFinal += "\n";
			}
			if (i < (listaNomeRAM.length - 1)) 
			{
				telaFinal += listaNomeRAM[i].getNome() + ", 		";
			}
			if (i == 14 && listaNomeRAM.length >= 14) 
			{
				telaFinal += listaNomeRAM[i].getNome() + ".";
			}
			++cortaLinha;
		}

		Icon icone = new ImageIcon(getFornecedor().getURL("recomendacao.png"));
		JOptionPane.showMessageDialog(null, telaFinal, getTITLE() + titulo, JOptionPane.OK_OPTION, icone);
	}
}