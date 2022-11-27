package Controller;

import java.util.SortedSet;
import java.util.TreeSet;
import View.*;
import ModelDAO.*;
import ModelEntidade.Requisito;
import ModelEntidade.Software;
import ModelNegocio.AchaCompativel;
import ModelNegocio.ValidacaoSoftware;

public class AppGHYMInicializador 
{
	public static void main(String[] args) 
	{
		boolean AplicacaoAtiva = true;
		boolean lerSoftware = true;
		String nomeSoftware;
		Exibicao exibir = new Exibicao(true);
		SoftwareView mostra = new SoftwareView();
		ValidacaoSoftware valida = new ValidacaoSoftware();
		SoftwareBD.inicializar();
		CPUBD.inicializar();
		GPUBD.inicializar();
		RAMBD.inicializar();

		while (AplicacaoAtiva) 
		{
			SortedSet<Software> listaSoftwareEscolhido = new TreeSet<>();

			while (lerSoftware) 
			{
				nomeSoftware = mostra.leSoftware();

				if (valida.procuraSoftwareNome(nomeSoftware))
				{
					if(mostra.confirmaAdicaoListaSoftware(valida.getSoftwareAchado()))
					{
						listaSoftwareEscolhido.add(valida.getSoftwareAchado());
					}
				}
				else
				{
					mostra.softwareInexistente();
				}

				lerSoftware = mostra.continuaLendoSoftware(listaSoftwareEscolhido);
			}

			if (listaSoftwareEscolhido.size() < 0) 
			{
				System.exit(0);
			}

			AchaCompativel achaRequisito = new AchaCompativel();
			Requisito requisitoLista = new Requisito(listaSoftwareEscolhido);

			
			exibir.exibirConfiguraçãoMinima(listaSoftwareEscolhido, achaRequisito.achaCPUMinCompativeis(requisitoLista.getCpu()),
			achaRequisito.achaGPUMinCompativeis(requisitoLista.getGpu()), achaRequisito.achaRAMMinCompativel(requisitoLista.getRam()));

			exibir.exibirConfiguraçãoRecomendada(listaSoftwareEscolhido, achaRequisito.achaCPUMaxCompativeis(requisitoLista.getCpu()),
			achaRequisito.achaGPUMaxCompativeis(requisitoLista.getGpu()), achaRequisito.achaRAMMaxCompativel(requisitoLista.getRam()));
			
			AplicacaoAtiva = exibir.continuar();
			if (AplicacaoAtiva)
			{
				lerSoftware = true;
			}

		}
	}
}