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
						return "i5-2500k ; GTX 1070 ; 6 GB";
					case "Counter Strike":
						return "E6600 ; GT 710 ; 2 GB";
					case "Google Chrome":
						return "Pentium_4 ; Não há necessidade ; 2 GB";
					default:
						return " Não existe ";
				}
				
			case 1:
				switch(nome)
				{
					case "God Of War":
						return " i9-9900k ; RTX 3080 ; 20 GB";
					case "Counter Strike":
						return "i7-3770k ; GTX 1080ti ; 16 GB";
					case "Google Chrome":
						return " i5-4690 ; Não há necessidade ; 16 GB";
					default:
						return " Não existe ";
				}
				
			case 2:
				switch(nome)
				{
					case "God Of War":
						return " i7-10700k ; RX5600xt ; 16 GB";
					case "Counter Strike":
						return " i5-2400 ; GT 1030 ; 10 GB";
					case "Google Chrome":
						return " i3-4170 ; Não há necessidade ; 6 GB";
					default:
						return " Não existe ";
				}
				
			default:
				return " Erro de Processamento ";
				
		}
	}
}
