package View;

import javax.swing.JOptionPane;

public class EntradaSistema 
{
	public void hiSystem()
	{
		JOptionPane.showMessageDialog(null, "Hi System!");
	}
	
	public void IDIncorreto()
	{
		JOptionPane.showMessageDialog(null, "ID incorreto!");
	}

	public long leID()
	{
		long id = Long.parseLong(JOptionPane.showInputDialog("Insira o ID: "));
		return id;
	}
}
