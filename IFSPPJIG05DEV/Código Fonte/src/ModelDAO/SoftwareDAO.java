package ModelDAO;

public class SoftwareDAO {
	public String achaRec(String nome, byte tipo) {
		if (tipo == 0) {
			if (nome.equalsIgnoreCase("God Of War")){
				float requisitos[][] = new float[3][3];
				// primeiro [0] é recomendação mínima: 
				// segundo é a quantidade de núcleos X clock
				requisitos[0][0] = 12.4f;
				// segundo [1] é o clock X vram
				requisitos[0][1] = 4400f;
				// segun [2] é a ram
				requisitos[0][2] = 4f;
				
				// primeiro [1] é recomendação recomendada 
				requisitos[1][0] = 14f;
				requisitos[1][1] = 11100f;
				requisitos[1][2] = 8f;
				
				// primeiro [2] é a recomendação máxima
				requisitos[2][0] = 32f;
				requisitos[2][1] = 19500f;
				requisitos[2][2] = 16f;
				return " a ; a ; a ";
			}

			else if (nome.equalsIgnoreCase("Counter Strike")) {
				return " E6600 ; GT 710 ; 2 GB";
			}

			else if (nome.equalsIgnoreCase("Google Chrome")) {
				return " Pentium_4 ; Não há necessidade ; 2 GB";
			}

			else {
				return " Não existe ";
			}
		}
		else if (tipo == 1) {
			if (nome.equalsIgnoreCase("God Of War")) {
				return " i7-10700k ; RX5600xt ; 16 GB";
			}

			else if (nome.equalsIgnoreCase("Counter Strike")) {
				return " i5-2400 ; GT 1030 ; 10 GB";
			}

			else if (nome.equalsIgnoreCase("Google Chrome")) {
				return " i3-4170 ; Não há necessidade ; 6 GB";
			} else {
				return " Não existe ";
			}
		}
		else {
			return " Erro de Processamento";
		}
	}
	public String AchaEquipamentos(float[][] requisitos)
	{
		String Processadores = "";
		String CatalogoCPU[][] = new String[5][2];
		// 5 processadores serão cadastrados com nome e "clock real"
		String GPU = "";
		String CatalogoGPU[][] = new String[5][2];
		// 5 GPUs serão cadastrados com nome e clock X vram
		String RAM = "";
		String CatalogoRAM[][] = new String[5][2];
		// 5 RAMs serão cadastrados com nome e capacidade
		
		for(byte i = 0; i <= 4; i++)
		for(byte j = 0; j < CatalogoCPU.length; j++)
		{
			if(Float.parseFloat(CatalogoCPU[j][2]) > requisitos[i][0] || Float.parseFloat(CatalogoCPU[j][2]) == requisitos[i][0])
			Processadores += CatalogoCPU[j][0] + "`" +CatalogoCPU[j][0] + "^";
		}

		for(byte i = 0; i <= 4; i++)
		for(byte j = 0; j < CatalogoGPU.length; j++)
		{
			if(Float.parseFloat(CatalogoGPU[j][2]) > requisitos[i][1] || Float.parseFloat(CatalogoGPU[j][2]) == requisitos[i][0])
			GPU += CatalogoGPU[j][0] + "`" +CatalogoGPU[j][0] + "^";
		}

		for(byte i = 0; i <= 4; i++)
		for(byte j = 0; j < CatalogoRAM.length; j++)
		{
			if(Float.parseFloat(CatalogoRAM[j][2]) > requisitos[i][2] || Float.parseFloat(CatalogoRAM[j][2]) == requisitos[i][0])
			RAM += CatalogoRAM[j][0] + "`" +CatalogoRAM[j][0] + "^";
		}

		String equipamentos_encontrados = Processadores + "|" + GPU + "|" + RAM;
		return equipamentos_encontrados;
	}

	public float[][] achaRecsMultiSoftwares(float recAntiga[][], float recAtual[][])
	{
		float recNova[][] = new float[3][3];

		for(byte i = 0; i < 4; i++)
		for(byte j = 0; i < 4; j++)
		{
			if(recAntiga[i][j] > recAtual[i][j])
			recNova[i][j] = recAntiga[i][j];
			else if(recAntiga[i][j] < recAtual[i][j])
			recNova[i][j] = recAntiga[i][j];
			else
			recNova[i][j] = recAntiga[i][j];
		}
		return recNova;
	}
}