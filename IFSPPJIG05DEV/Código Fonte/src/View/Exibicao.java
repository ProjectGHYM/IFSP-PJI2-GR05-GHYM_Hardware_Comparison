package View;
import javax.swing.JOptionPane;

public class Exibicao
{
	public void HiSystem()
	{
		JOptionPane.showMessageDialog(null, "Bem-vindo ao Software da GHYM!");
	}
	
	public String veSoftware()
	{
		return JOptionPane.showInputDialog(null, "Insira o nome do software:");
	}
	
	public int confirmaSoftRec(String mensagem)
	{
		return JOptionPane.showConfirmDialog(null,"Confirme o software a ser buscado:\n" + mensagem);
	}
	
	public boolean continuar()
	{
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja continuar na aplicação? ");
		return opcao == 1 || opcao == -1 || opcao == 2 ? false : true;
	}
	public void exiberecomendacao(String recomendado, byte rec)
	{
		String recomenda [] = recomendado.split(";");
		String tipoRec[] = {"Recomendação Minima", "Recomendação Máxima", "Nossa Recomendação"};
		JOptionPane.showMessageDialog(null, tipoRec[rec] + "\nProcessador: " + recomenda[0] + "\nPlaca de video: " + recomenda[1] + "\nRAM: " + recomenda[2]);
	}
}