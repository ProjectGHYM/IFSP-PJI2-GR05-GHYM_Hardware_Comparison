package ModelDAO;

public class SoftwareDAO 
{
	public String achaRec(String nome, byte tipo) 
	{
		if(tipo == 0)
		{
			if(nome.equalsIgnoreCase("God Of War"))
			{
				float requisitos[][] = new float[3][3];
				requisitos[0][0] = 12.4f;
				requisitos[0][1] = 14f;
				requisitos[0][2] = 32f;
				requisitos[1][0] = 4400f;
				requisitos[1][1] = 11100f;
				requisitos[1][2] = 19500f;
				requisitos[2][0] = 4f;
				requisitos[2][1] = 8f;
				requisitos[2][2] = 16f;
				return " a ; a ; a ";
			}

			else if(nome.equalsIgnoreCase("Counter Strike"))
			{
				return " E6600 ; GT 710 ; 2 GB";
			}

			else if(nome.equalsIgnoreCase("Google Chrome"))
			{
				return " Pentium_4 ; Não há necessidade ; 2 GB";
			}

			else
			{
				return " Não existe ";
			}
		}
		else if(tipo == 1)
		{
			if(nome.equalsIgnoreCase("God Of War"))
			{
				return " i9-9900k ; RTX 3080 ; 20 GB";
			}

			else if(nome.equalsIgnoreCase("Counter Strike"))
			{
				return " i7-3770k ; GTX 1080ti ; 16 GB";
			}

			else if(nome.equalsIgnoreCase("Google Chrome"))
			{
				return " i5-4690 ; Não há necessidade ; 16 GB";
			}

			else
			{
				return " Não existe ";
			}
		}

		else if(tipo == 2)
		{
			if(nome.equalsIgnoreCase("God Of War"))
			{
				return " i7-10700k ; RX5600xt ; 16 GB";
			}

			else if(nome.equalsIgnoreCase("Counter Strike"))
			{
				return " i5-2400 ; GT 1030 ; 10 GB";
			}

			else if(nome.equalsIgnoreCase("Google Chrome"))
			{
				return " i3-4170 ; Não há necessidade ; 6 GB";
			}
			else
			{
				return " Não existe ";
			}
		}
		
		else
		{
			return " Erro de Processamento";
		}
	}

	public Object[] AchaProcessador(Object processador[], int clock, int core)
	{
		float clock_real;
		clock_real = clock*core;
		return processador;
	}
}
