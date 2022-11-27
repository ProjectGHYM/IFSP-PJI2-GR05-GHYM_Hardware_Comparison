package View;

import java.util.SortedSet;
import javax.swing.JOptionPane;
import ModelEntidade.CPU;
import ModelEntidade.GPU;
import ModelEntidade.RAM;
import ModelEntidade.Software;

public class Exibicao 
{
	public Exibicao() 
	{
		int opcao = JOptionPane.showConfirmDialog(null, "Bem-vindo ao Software da GHYM!", "GHYM",
				JOptionPane.PLAIN_MESSAGE);
		janelaFechada(opcao, JOptionPane.CLOSED_OPTION);
	}

	public String leSoftware() 
	{
		String nomeSoftware = JOptionPane.showInputDialog(null, "Insira o nome do software:",
				"Configuração Para Softwares", JOptionPane.QUESTION_MESSAGE);
		
		if (nomeSoftware.equals("")) 
		{
			nomeSoftware = null;
		}

		janelaFechada(nomeSoftware, null);
		
		return nomeSoftware;
	}

	public boolean continuaLendoSoftware(SortedSet<Software> softwareEscolhido) 
	{
		String softwareAtual = "Softwares Digitados até Agora:";
		
		for (Software softwareJaEscolhido : softwareEscolhido)
		{
			softwareAtual += String.format("\n-" + softwareJaEscolhido.getNome());
		}

		int opcao = JOptionPane.showConfirmDialog(null, softwareAtual + "\nDeseja Escolher Outro Softare Além Do(s) Já Escolhido(s):",
		"Escolhas de Software", JOptionPane.YES_NO_OPTION);
		
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

	// public String testeSoftwareRepetido(ArrayList<String> softwareEscolhido, String nomeSoftware) {
	// 	boolean softwareRepetido = false;
	// 	for (int i = 0; i < softwareEscolhido.size(); ++i) {
	// 		if (softwareEscolhido.get(i).equalsIgnoreCase(nomeSoftware)) {
	// 			JOptionPane.showMessageDialog(null, "Digite Outro Software", "Software Repetido!",
	// 					JOptionPane.ERROR_MESSAGE);
	// 			softwareRepetido = true;
	// 		}
	// 	}

	// 	if (softwareRepetido)
	// 		return "";
	// 	return nomeSoftware;
	// }

	public int confirmaSoftware(String nomeSoftware) {
		int opcao = JOptionPane.showConfirmDialog(null, "Confirme o software a ser buscado:\n" + nomeSoftware);
		janelaFechada(opcao, JOptionPane.CLOSED_OPTION);
		return opcao;
	}

	public void softwareInexistente()
	{
		JOptionPane.showMessageDialog(null, "Software Inexistente!", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
	}

	public boolean continuar() 
	{
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar na aplicação? ");
		janelaFechada(opcao, JOptionPane.CLOSED_OPTION); 
		return opcao == 1 || opcao == 2 ? false : true;
	}

	public void exibirConfiguraçãoMinima(SortedSet<Software> softwareEscolhido, CPU listaNomeCPU[], GPU listaNomeGPU[], RAM listaNomeRAM[]) 
	{
		String telaFinal, titulo = "Configurações Minimas Possíveis";
		int cortaLinha = 0;

		if (softwareEscolhido.size() > 1) 
		{
			telaFinal = "Requisitos Mínimos" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		} else {
			telaFinal = softwareEscolhido.last().getNome() + "\nRequisitos Mínimos" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		}
	}

	public void exibirConfiguraçãoRecomendada(SortedSet<Software> softwareEscolhido, CPU listaNomeCPU[], GPU listaNomeGPU[], RAM listaNomeRAM[]) 
	{
		String telaFinal, titulo = "Configurações Recomendadas Possíveis";
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
			if (i == (listaNomeCPU.length - 1)) 
			{
				telaFinal += listaNomeCPU[i] + ".";
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
			if (i == (listaNomeGPU.length - 1)) 
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
			if (i == (listaNomeRAM.length - 1)) 
			{
				telaFinal += listaNomeRAM[i].getNome() + ".";
			}
			++cortaLinha;
		}
		JOptionPane.showMessageDialog(null, telaFinal, titulo, JOptionPane.OK_OPTION);
	}

	public void janelaFechada(int opcao, int parametro) 
	{
		if (opcao == parametro) 
		{
			JOptionPane.showMessageDialog(null, "Fechando Software...", "Janela Fechada Ou Cancelada", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}

	public void janelaFechada(String opcao, String parametro) 
	{
		if (opcao.equals(parametro)) 
		{
			JOptionPane.showMessageDialog(null, "Fechando Software...", "Janela Interrompida", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}
}