package View;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Exibicao 
{
	public Exibicao()
	{
		int opcao = JOptionPane.showConfirmDialog(null, "Bem-vindo ao Software da GHYM!", "GHYM", JOptionPane.DEFAULT_OPTION);
		testeJanelaFechada(Integer.toString(opcao), "-1");
	}

	public String leSoftware() 
	{
		String nomesoft = JOptionPane.showInputDialog(null, "Insira o nome do software:");
		testeJanelaFechada(nomesoft, null);

		if(nomesoft.equals(""))
		{
			return "null";
		}
		return nomesoft;
	}

	public boolean leOutroSoftware() 
	{
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja Escolher Outro Softare Além Do(s) Já Escolhido(s):","Escolhas de Software", JOptionPane.YES_NO_OPTION);
		testeJanelaFechada(Integer.toString(opcao), "-1");
		
		if(opcao == 0)
			return true;
		return false;
	}

	public String testeSoftwareRepetido(ArrayList<String> escsoft, String nomesoft)
	{
		boolean softwareRepetido = false;
		for(int i = 0; i < escsoft.size(); ++i)
		{
			if(escsoft.get(i).equalsIgnoreCase(nomesoft))
			{
				JOptionPane.showMessageDialog(null, "Digite Outro Software", "Software Repetido!", JOptionPane.ERROR_MESSAGE);
				softwareRepetido = true;
			}
		}

		if(softwareRepetido)
			return "";
		return nomesoft;
	}

	public int confirmaSoftware(String nomesoft) 
	{
		int opcao = JOptionPane.showConfirmDialog(null, "Confirme o software a ser buscado:\n" + nomesoft);
		testeJanelaFechada(Integer.toString(opcao), "-1");
		return opcao;
	}

	public byte Error(String nomesoft, String nome_softs[])
	{
		if(nomesoft == "null")
		{
			JOptionPane.showMessageDialog(null, "Valor Nulo", "NULL", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

		boolean opcao = false;
		for(byte i = 0 ; i < 19; ++i)
		{
			if(nomesoft.equalsIgnoreCase(nome_softs[i]))
			{
				nomesoft = nome_softs[i];
				opcao = true;
			}
		}

		if(opcao)
			return 1;

		JOptionPane.showMessageDialog(null, "Software Inexistente!", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
		return 0;
	}
	
	public String ajuste(String nomesoft, String nome_softs[])
	{
		for(byte i = 0 ; i < 19; ++i)
		{
			if(nomesoft.equalsIgnoreCase(nome_softs[i]))
				nomesoft = nome_softs[i];
		}
		return nomesoft;
	}

	public boolean continuar() 
	{
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar na aplicação? ");
		testeJanelaFechada(Integer.toString(opcao), "-1");
		return opcao == 1 || opcao == 2 ? false : true;
	}

	public void exiberecomendacao(String escsoft, String recomendado, byte rec) 
	{
		String recomenda[] = recomendado.split(";");
		String tipoRec[] = { "Requisito Minimo", "Requisito Recomendado" };
		JOptionPane.showMessageDialog(null, escsoft + "\n" + tipoRec[rec] + "\nProcessador: " + recomenda[0] + "\nPlaca de vídeo: "
				+ recomenda[1] + "\nRAM: " + recomenda[2]);
	}

	public void exibirMin(String escsoft, String resultNomeCPU[], String resultNomeGPU[], String resultNomeRAM[])
	{
		if(escsoft.equals("null")){
			System.out.print("\nProgramas Escolhidos\n\nRequisitos Minimos" + "\nProcessador: ");
			for(int i = 0; i<resultNomeCPU.length; ++i){
				if( i < (resultNomeCPU.length - 1)){
					System.out.print(resultNomeCPU[i] + ", ");
				}
				else{
					System.out.print(resultNomeCPU[i] + ".");
				}
			}
			System.out.print("\n\nPlaca de Vídeo: ");
			for(int i = 0; i<resultNomeGPU.length; ++i){
				if( i < (resultNomeGPU.length - 1)){
					System.out.print(resultNomeGPU[i] + ", ");
				}
				else{
					System.out.print(resultNomeGPU[i] + ".");
				}
			}
			System.out.print("\n\nRAM: ");
			for(int i = 0; i<resultNomeRAM.length; ++i){
				if( i < (resultNomeRAM.length - 1)){
					System.out.print(resultNomeRAM[i] + ", ");
				}
				else{
					System.out.print(resultNomeRAM[i] + ".");
				}
			}
		}
		else{
			System.out.print("\n" + escsoft + "\nRequisitos Minimos" + "\nProcessador: ");
			for(int i = 0; i<resultNomeCPU.length; ++i){
				if( i < (resultNomeCPU.length - 1)){
					System.out.print(resultNomeCPU[i] + ", ");
				}
				else{
					System.out.print(resultNomeCPU[i] + ".");
				}
			}
			System.out.print("\n\nPlaca de Vídeo: ");
			for(int i = 0; i<resultNomeGPU.length; ++i){
				if( i < (resultNomeGPU.length - 1)){
					System.out.print(resultNomeGPU[i] + ", ");
				}
				else{
					System.out.print(resultNomeGPU[i] + ".");
				}
			}
			System.out.print("\n\nRAM: ");
			for(int i = 0; i<resultNomeRAM.length; ++i){
				if( i < (resultNomeRAM.length - 1)){
					System.out.print(resultNomeRAM[i] + ", ");
				}
				else{
					System.out.print(resultNomeRAM[i] + ".");
				}
			}
		}
	}
	
	public void exibirRec(String escsoft, String resultNomeCPU[], String resultNomeGPU[], String resultNomeRAM[]){
		if(escsoft.equals("null")){
			System.out.print("\n\n\nRequisitos Recomendados" + "\nProcessador: ");
			for(int i = 0; i<resultNomeCPU.length; ++i){
				if( i < (resultNomeCPU.length - 1)){
					System.out.print(resultNomeCPU[i] + ", ");
				}
				else{
					System.out.print(resultNomeCPU[i] + ".");
				}
			}
			System.out.print("\n\nPlaca de Vídeo: ");
			for(int i = 0; i<resultNomeGPU.length; ++i){
				if( i < (resultNomeGPU.length - 1)){
					System.out.print(resultNomeGPU[i] + ", ");
				}
				else{
					System.out.print(resultNomeGPU[i] + ".");
				}
			}
			System.out.print("\n\nRAM: ");
			for(int i = 0; i<resultNomeRAM.length; ++i){
				if( i < (resultNomeRAM.length - 1)){
					System.out.print(resultNomeRAM[i] + ", ");
				}
				else{
					System.out.print(resultNomeRAM[i] + ".");
				}
			}
		}
		else{
			System.out.print("\n\n\n" + escsoft + "\nRequisitos Recomendados" + "\nProcessador: ");
			for(int i = 0; i<resultNomeCPU.length; ++i){
				if( i < (resultNomeCPU.length - 1)){
					System.out.print(resultNomeCPU[i] + ", ");
				}
				else{
					System.out.print(resultNomeCPU[i] + ".");
				}
			}
			System.out.print("\n\nPlaca de Vídeo: ");
			for(int i = 0; i<resultNomeGPU.length; ++i){
				if( i < (resultNomeGPU.length - 1)){
					System.out.print(resultNomeGPU[i] + ", ");
				}
				else{
					System.out.print(resultNomeGPU[i] + ".");
				}
			}
			System.out.print("\n\nRAM: ");
			for(int i = 0; i<resultNomeRAM.length; ++i){
				if( i < (resultNomeRAM.length - 1)){
					System.out.print(resultNomeRAM[i] + ", ");
				}
				else{
					System.out.print(resultNomeRAM[i] + ".");
				}
			}
		}
	}

	public void testeJanelaFechada(String opcao, String parametro)
	{
		if(opcao.equals(parametro))
		{
			JOptionPane.showMessageDialog(null, "Fechando Software...", "Janela Fechada Ou Cancelada", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}
}