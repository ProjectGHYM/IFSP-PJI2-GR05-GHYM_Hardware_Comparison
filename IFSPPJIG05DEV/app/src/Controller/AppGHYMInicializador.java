package Controller;

import java.util.ArrayList;
import View.Exibicao;
import ModelDAO.*;

public class AppGHYMInicializador 
{
	public static void main(String[] args) 
	{
		boolean loopOn = true;
		boolean rply = true;
		String nomesoft;
		Exibicao objexibir = new Exibicao();
		//SoftwareDAO objDAO = new SoftwareDAO();
		SoftwareBD softBD = new SoftwareBD();
		softBD.readSoftwareBD();

		while (loopOn) 
		{
			ArrayList<String> escsoft = new ArrayList<String>();

			while(rply)
			{
				nomesoft = objexibir.leSoftware();

				if (objexibir.confirmaSoftware(nomesoft) == 0) 
				{
					if(objexibir.Error(nomesoft, softBD.getNome_softs()) == 1)
					{
						if(escsoft.size() > 0)
						{
							escsoft.add(objexibir.testeSoftwareRepetido(escsoft, nomesoft));

							if(escsoft.get(escsoft.size() - 1) == "")
								escsoft.remove(escsoft.size()-1);
						}
						else if(escsoft.size() == 0)
							escsoft.add(nomesoft);
					}
					rply = objexibir.leOutroSoftware();
				}
			}

			CPUBD cpubd = new CPUBD();
			RecCPUBD reccpu = new RecCPUBD();
			GPUBD gpubd = new GPUBD();
			RecGPUBD recgpu = new RecGPUBD();
			RAMBD rambd = new RAMBD();
			RecRamBD recram = new RecRamBD();
			OrganizaBD org = new OrganizaBD(escsoft);

			if(escsoft.size() == 1)
			{
				escsoft.set(0, objexibir.ajuste(escsoft.get(0), softBD.getNome_softs()));
				objexibir.exibirMin(escsoft.get(0), cpubd.getRecomendacaoMinimaCPU(reccpu.getRecCPUBD(escsoft.get(0))), gpubd.getMinGPUBD(recgpu.getRecGPUBD(escsoft.get(0))), rambd.getMinRAMBD(recram.getRecRAMBD(escsoft.get(0))));
				objexibir.exibirRec(escsoft.get(0), cpubd.getRecomendacaoMinimaCPU(reccpu.getRecCPUBD(escsoft.get(0))), gpubd.getRecGPUBD(recgpu.getRecGPUBD(escsoft.get(0))), rambd.getRecRAMBD(recram.getRecRAMBD(escsoft.get(0))));
			}
			
			else if(escsoft.size() > 1)
			{
				for (byte i = 0; i < escsoft.size(); ++i){
					escsoft.set(i, objexibir.ajuste(escsoft.get(i), softBD.getNome_softs()));
					org.juntaMin(reccpu.getRecCPUBD(escsoft.get(i)), recgpu.getRecGPUBD(escsoft.get(i)), recram.getRecRAMBD(escsoft.get(i)), i);
				}
				objexibir.exibirMin("null", cpubd.getGeralMinCPUBD(org.CPUMin(), org.CPURec()), gpubd.getGeralMinGPUBD(org.GPUMin(), org.GPURec()), rambd.getGeralMinRAMBD(org.RAMMin(), org.RAMRec()));
				objexibir.exibirRec("null", cpubd.getGeralRecCPUBD(org.CPURec()), gpubd.getGeralRecGPUBD(org.GPURec()), rambd.getGeralRecRAMBD(org.RAMRec()));
			}

			loopOn = objexibir.continuar();
			if(loopOn)
				rply = true;
		}
	}
}