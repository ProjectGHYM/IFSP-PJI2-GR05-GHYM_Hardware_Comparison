package View;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import ModelDAO.SoftwareBD;

public class Exibicao {
	public void HiSystem() {
		int hisystem = JOptionPane.showConfirmDialog(null, "Bem-vindo ao Software da GHYM!", "GHYM", JOptionPane.DEFAULT_OPTION);
		if(hisystem == -1){
			JOptionPane.showMessageDialog(null, "Fechando Software...", "Janela Fechada Ou Cancelada", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	public String veSoftware() {
		String nomesoft = JOptionPane.showInputDialog(null, "Insira o nome do software:");
		if(nomesoft == null){
			JOptionPane.showMessageDialog(null, "Fechando Software...", "Janela Fechada Ou Cancelada", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		if(nomesoft.equals("")){
			return "null";
		}
		return nomesoft;
	}

	public boolean continuaSoft() {
		int esc = JOptionPane.showConfirmDialog(null, "Deseja Escolher Outro Softare Além Do(s) Já Escolhido(s):","Escolhas de Software", JOptionPane.YES_NO_OPTION);
		if(esc == -1){
			JOptionPane.showMessageDialog(null, "Fechando Software...", "Janela Fechada Ou Cancelada", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		if(esc == 0){
			return true;
		}
		return false;
	}

	public String repetiSoft(ArrayList<String> escsoft, String nomesoft){
		byte confirm = 0;
		for(int i = 0; i < escsoft.size(); ++i){
			if(escsoft.get(i).equalsIgnoreCase(nomesoft)){
				JOptionPane.showMessageDialog(null, "Digite Outro Software", "Software Repetido!", JOptionPane.ERROR_MESSAGE);
				++confirm;
			}
		}
		if(confirm == 0){
			return nomesoft;
		}
		return "";
	}

	public int confirmaSoftRec(String nomesoft) {
		int escsoft = JOptionPane.showConfirmDialog(null, "Confirme o software a ser buscado:\n" + nomesoft);
		if(escsoft == -1){
			JOptionPane.showMessageDialog(null, "Fechando Software...", "Janela Fechada Ou Cancelada", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return escsoft;
	}
	public byte Error(String nomesoft){
		if(nomesoft == "null"){
			JOptionPane.showMessageDialog(null, "Valor Nulo", "NULL", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		byte confirm = 0;
		String nome_softs[] = new String[20];
		SoftwareBD softbd = new SoftwareBD();
		nome_softs = softbd.readSoft(nome_softs);
		for(byte i = 0 ; i < 19; ++i){
			if(nomesoft.equalsIgnoreCase(nome_softs[i])){
				nomesoft = nome_softs[i];
				++confirm;
			}
		}
		if(confirm == 0){
			JOptionPane.showMessageDialog(null, "Software Inexistente!", "Não Encontrado", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		return 1;
	}
	
	public String Ajuste(String nomesoft){
		String nome_softs[] = new String[20];
		SoftwareBD softbd = new SoftwareBD();
		nome_softs = softbd.readSoft(nome_softs);
		for(byte i = 0 ; i < 19; ++i){
			if(nomesoft.equalsIgnoreCase(nome_softs[i])){
				nomesoft = nome_softs[i];
			}
		}
		return nomesoft;
	}

	public boolean continuar() {
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar na aplicação? ");
		return opcao == -1 || opcao == 1 || opcao == 2 ? false : true;
	}

	public void exiberecomendacao(String escsoft, String recomendado, byte rec) {
		String recomenda[] = recomendado.split(";");
		String tipoRec[] = { "Requisito Minimo", "Requisito Recomendado" };
		JOptionPane.showMessageDialog(null, escsoft + "\n" + tipoRec[rec] + "\nProcessador: " + recomenda[0] + "\nPlaca de video: "
				+ recomenda[1] + "\nRAM: " + recomenda[2]);
	}
}