package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Exibicao {
	public Exibicao() {
		int opcao = JOptionPane.showConfirmDialog(null, "Bem-vindo ao Software da GHYM!", "GHYM",
				JOptionPane.PLAIN_MESSAGE);
		janelaFechada(Integer.toString(opcao), "-1");
	}

	public String leSoftware() {
		String nomeSoftware = JOptionPane.showInputDialog(null, "Insira o nome do software:",
				"Configuração Para Softwares", JOptionPane.QUESTION_MESSAGE);
		janelaFechada(nomeSoftware, null);

		if (nomeSoftware.equals("")) {
			return "null";
		}
		return nomeSoftware;
	}

	public boolean continuaLendoSoftware(ArrayList<String> softwareEscolhido) {
		String softwareAtual = "Softwares Digitados até Agora:";
		for (int i = 0; i < softwareEscolhido.size(); ++i) {
			softwareAtual += "\n" + softwareEscolhido.get(i);
		}
		int opcao = JOptionPane.showConfirmDialog(null,
				softwareAtual + "\nDeseja Escolher Outro Softare Além Do(s) Já Escolhido(s):",
				"Escolhas de Software", JOptionPane.YES_NO_OPTION);
		janelaFechada(Integer.toString(opcao), "-1");
		if (opcao == 0)
			return true;
		return false;
	}

	public String testeSoftwareRepetido(ArrayList<String> softwareEscolhido, String nomeSoftware) {
		boolean softwareRepetido = false;
		for (int i = 0; i < softwareEscolhido.size(); ++i) {
			if (softwareEscolhido.get(i).equalsIgnoreCase(nomeSoftware)) {
				JOptionPane.showMessageDialog(null, "Digite Outro Software", "Software Repetido!",
						JOptionPane.ERROR_MESSAGE);
				softwareRepetido = true;
			}
		}

		if (softwareRepetido)
			return "";
		return nomeSoftware;
	}

	public int confirmaSoftware(String nomeSoftware) {
		int opcao = JOptionPane.showConfirmDialog(null, "Confirme o software a ser buscado:\n" + nomeSoftware);
		janelaFechada(Integer.toString(opcao), "-1");
		return opcao;
	}

	public byte error(String nomeSoftware, String listaSoftware[]) {
		if (nomeSoftware == "null") {
			JOptionPane.showMessageDialog(null, "Valor Nulo", "NULL", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

		boolean opcao = false;
		for (byte i = 0; i < 19; ++i) {
			if (nomeSoftware.equalsIgnoreCase(listaSoftware[i])) {
				nomeSoftware = listaSoftware[i];
				opcao = true;
			}
		}

		if (opcao)
			return 1;

		JOptionPane.showMessageDialog(null, "Software Inexistente!", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
		return 0;
	}

	// metodo ajuste não faz sentido ficar na view, já que não mostra nada, será
	// transferido para ModelNegocio ou ModelDAO;

	/*
	 * public String ajuste(String nomesoft, String nome_softs[]) {
	 * for (byte i = 0; i < 19; ++i) {
	 * if (nomesoft.equalsIgnoreCase(nome_softs[i]))
	 * nomesoft = nome_softs[i];
	 * }
	 * return nomesoft;
	 * }
	 */

	public boolean continuar() {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar na aplicação? ");
		janelaFechada(Integer.toString(opcao), "-1");
		return opcao == 1 || opcao == 2 ? false : true;
	}

	public void exibirConfiguraçãoMinima(ArrayList<String> softwareEscolhido, String listaNomeCPU[],
			String listaNomeGPU[], String listaNomeRAM[]) {
		String telaFinal, titulo = "Configurações Minimas Possíveis";
		int cortaLinha = 0;

		if (softwareEscolhido.size() > 1) {
			telaFinal = "Requisitos Mínimos" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		} else {
			telaFinal = softwareEscolhido.get(0) + "\nRequisitos Mínimos" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		}
	}

	public void exibirConfiguraçãoRecomendada(ArrayList<String> softwareEscolhido, String listaNomeCPU[],
			String listaNomeGPU[],
			String listaNomeRAM[]) {
		String telaFinal, titulo = "Configurações Recomendadas Possíveis";
		int cortaLinha = 0;
		if (softwareEscolhido.size() > 1) {
			telaFinal = "Requisitos Recomendados" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		} else {
			telaFinal = softwareEscolhido.get(0) + "\nRequisitos Recomendados" + "\nProcessador: ";
			exibirConfiguração(cortaLinha, telaFinal, titulo, listaNomeCPU, listaNomeGPU, listaNomeRAM);
		}
	}

	public void exibirConfiguração(int cortaLinha, String telaFinal, String titulo, String listaNomeCPU[],
			String listaNomeGPU[],
			String listaNomeRAM[]) {
		for (int i = 0; i < listaNomeCPU.length; ++i) {
			if (cortaLinha % 5 == 0 && i > 0) {
				telaFinal += "\n";
			}
			if (i < (listaNomeCPU.length - 1)) {
				telaFinal += listaNomeCPU[i] + ", 		";
			}
			if (i == (listaNomeCPU.length - 1)) {
				telaFinal += listaNomeCPU[i] + ".";
			}
			++cortaLinha;
		}
		cortaLinha = 0;
		telaFinal += "\n\nPlaca de Vídeo: ";
		for (int i = 0; i < listaNomeGPU.length; ++i) {
			if (cortaLinha % 3 == 0 && i > 0) {
				telaFinal += "\n";
			}
			if (i < (listaNomeGPU.length - 1)) {
				telaFinal += listaNomeGPU[i] + ", 		";
			}
			if (i == (listaNomeGPU.length - 1)) {
				telaFinal += listaNomeGPU[i] + ".";
			}
			++cortaLinha;
		}
		cortaLinha = 0;
		telaFinal += "\n\nRAM: ";
		for (int i = 0; i < listaNomeRAM.length; ++i) {
			if (cortaLinha % 3 == 0 && i > 0) {
				telaFinal += "\n";
			}
			if (i < (listaNomeRAM.length - 1)) {
				telaFinal += listaNomeRAM[i] + ", 		";
			}
			if (i == (listaNomeRAM.length - 1)) {
				telaFinal += listaNomeRAM[i] + ".";
			}
			++cortaLinha;
		}
		JOptionPane.showMessageDialog(null, telaFinal, titulo, JOptionPane.OK_OPTION);
	}

	public void janelaFechada(String opcao, String parametro) {
		if (opcao == parametro || opcao.equals(parametro)) {
			JOptionPane.showMessageDialog(null, "Fechando Software...", "Janela Fechada Ou Cancelada",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}