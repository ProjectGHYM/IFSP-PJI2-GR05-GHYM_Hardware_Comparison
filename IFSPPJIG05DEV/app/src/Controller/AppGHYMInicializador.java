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
			SortedSet<Software> listaSoftwareEscolhido = new TreeSet<>();

			while (lerSoftware) 
			{
				nomeSoftware = objexibir.leSoftware();

				if (valida.procuraSoftwareNome(nomeSoftware) == 1) // 1 significa que foi encontrado
				{
					listaSoftwareEscolhido.add(valida.getSoftwareAchado());
				}

				lerSoftware = objexibir.continuaLendoSoftware(listaSoftwareEscolhido);
			}

			if (listaSoftwareEscolhido.size() < 0) 
			{
				System.exit(0);
			}

			CPUBD cpubd = new CPUBD();
			GPUBD gpubd = new GPUBD();
			RAMBD rambd = new RAMBD();
			OrganizaBD org = new OrganizaBD(listaSoftwareEscolhido);
			AchaCompativel achaRequisito = new AchaCompativel();
			Requisito requisitoLista = org.definirRequisitoGeral();
			
			objexibir.exibirConfiguraçãoMinima(listaSoftwareEscolhido, achaRequisito.achaCPUMinCompativeis(requisitoLista.getCpu()),
			achaRequisito.achaGPUMinCompativeis(requisitoLista.getGpu()), achaRequisito.achaRAMMinCompativel(requisitoLista.getRam()));

			objexibir.exibirConfiguraçãoRecomendada(listaSoftwareEscolhido, achaRequisito.achaCPUMaxCompativeis(requisitoLista.getCpu()),
			achaRequisito.achaGPUMaxCompativeis(requisitoLista.getGpu()), achaRequisito.achaRAMMaxCompativel(requisitoLista.getRam()));
			
			AplicacaoAtiva = objexibir.continuar();
			if (AplicacaoAtiva)
				lerSoftware = true;
		}
	}
}