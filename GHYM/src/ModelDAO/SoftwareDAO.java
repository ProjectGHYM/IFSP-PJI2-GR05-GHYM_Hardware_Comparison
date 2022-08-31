package ModelDAO;

public class SoftwareDAO 
{
	public String achaRec(String nome, byte tipo) 
	{
		switch(tipo)
		{
			case 0:
				switch(nome)
				{
					case "God Of War":
						return "i5-2500k GTX_1070 6GB";
					case "Counter Strike":
						return "E6600 GT_710 2GB";
					case "Google Chrome":
						return "Pentium_4 Não há necessidade 2GB";
					default:
						return "Não existe";
				}
				
			case 1:
				switch(nome)
				{
					case "God Of War":
						return "i9-9900k RTX_3080 20GB";
					case "Counter Strike":
						return "i7-3770k GTX_1080ti 16GB";
					case "Google Chrome":
						return "i5-4690 Não há necessidade 16GB";
					default:
						return "Não existe";
				}
				
			case 2:
				switch(nome)
				{
					case "God Of War":
						return "i7-10700k RX5600xt 16GB";
					case "Counter Strike":
						return "i5-2400 GT_1030 10GB";
					case "Google Chrome":
						return "i3-4170 Não há necessidade 6GB";
					default:
						return "Não existe";
				}
				
			default:
				return "Erro de Processamento";
				
		}
	}
}
