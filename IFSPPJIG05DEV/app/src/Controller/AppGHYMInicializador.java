package Controller;

import java.util.SortedSet;
import java.util.TreeSet;


import View.*;
import ModelDAO.*;
import ModelEntidade.Requisito;
import ModelEntidade.Software;
import ModelNegocio.AchaCompativel;
import ModelNegocio.ValidacaoSoftware;

public class AppGHYMInicializador {
	public static void main(String[] args) 
	{
		boolean AplicacaoAtiva = true;
		boolean lerSoftware = true;
		String nomeSoftware;
		Exibicao objexibir = new Exibicao();
		SoftwareBD softBD = new SoftwareBD();
		ValidacaoSoftware valida = new ValidacaoSoftware();
		while (AplicacaoAtiva) 
		{
			SortedSet<Software> softwareEscolhido = new TreeSet<>();

			while (lerSoftware) 
			{
				nomeSoftware = objexibir.leSoftware();

				if (valida.procuraSoftwareNome(nomeSoftware) == 1) // 1 significa que foi encontrado
				{
					softwareEscolhido.add(SoftwareBD.listaSoftware[valida.indice]);
				}

				lerSoftware = objexibir.continuaLendoSoftware(softwareEscolhido);
			}

			if (softwareEscolhido.size() < 0) 
			{
				System.exit(0);
			}

			CPUBD cpubd = new CPUBD();
			GPUBD gpubd = new GPUBD();
			RAMBD rambd = new RAMBD();
			OrganizaBD org = new OrganizaBD(softwareEscolhido);
			AchaCompativel achaRequisito = new AchaCompativel();
			Requisito requisitos = org.definirRequisitoGeral();
			
			objexibir.exibirConfiguraçãoMinima(softwareEscolhido, achaRequisito.achaCPUMinCompativeis(requisitos.getCpu()),
			achaRequisito.achaGPUMinCompativeis(requisitos.getGpu()), achaRequisito.achaRAMMinCompativel(requisitos.getRam()));

			objexibir.exibirConfiguraçãoRecomendada(softwareEscolhido, achaRequisito.achaCPUMaxCompativeis(requisitos.getCpu()),
			achaRequisito.achaGPUMaxCompativeis(requisitos.getGpu()), achaRequisito.achaRAMMaxCompativel(requisitos.getRam()));
			
			AplicacaoAtiva = objexibir.continuar();
			if (AplicacaoAtiva)
				lerSoftware = true;
		}
	}
}