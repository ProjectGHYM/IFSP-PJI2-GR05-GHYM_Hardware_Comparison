package View;

import javax.swing.JOptionPane;

import View.Icones.ForneceURL;

public abstract class ViewMae 
{
	private ForneceURL fornecedor = new ForneceURL();
    private final String TITLE = "https://ghym.com";

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
	
    public String getTITLE() 
    {
        return TITLE;
    }

	public ForneceURL getFornecedor() 
	{
		return fornecedor;
	}

	public void setFornecedor(ForneceURL fornecedor) 
	{
		this.fornecedor = fornecedor;
	}    
}
