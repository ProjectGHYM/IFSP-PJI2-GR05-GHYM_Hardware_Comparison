package View;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import ModelDAO.SoftwareBD;

public class Exibicao {
	public void HiSystem() {
		JOptionPane.showMessageDialog(null, "Bem-vindo ao Software da GHYM!");
	}

	public String veSoftware() {
		return JOptionPane.showInputDialog(null, "Insira o nome do software:");
	}

	public boolean continuaSoft() {
		boolean esc = JOptionPane.showConfirmDialog(null, "Deseja Escolher Outro Softare Além Do(s) Já Escolhido(s):","Escolhas de Software", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION;
		return esc;
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

	public int confirmaSoftRec(String mensagem) {
		return JOptionPane.showConfirmDialog(null, "Confirme o software a ser buscado:\n" + mensagem);
	}
	public byte Error(String nomesoft){
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