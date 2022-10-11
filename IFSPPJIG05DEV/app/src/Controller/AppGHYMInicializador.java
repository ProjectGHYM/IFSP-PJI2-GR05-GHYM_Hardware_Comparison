package Controller;

import java.util.ArrayList;
import View.*;
import ModelDAO.*;
import ModelNegocio.Formatacao;

public class AppGHYMInicializador {
	public static void main(String[] args) {
		boolean loopOn = true;
		boolean rply = true;
		String nomeSoftware;
		Exibicao objexibir = new Exibicao();
		SoftwareBD softBD = new SoftwareBD();
		softBD.readSoftwareBD();
		while (loopOn) {
			ArrayList<String> softwareEscolhido = new ArrayList<String>();

			while (rply) {
				nomeSoftware = objexibir.leSoftware();
				System.out.println(nomeSoftware);
				if (objexibir.confirmaSoftware(nomeSoftware) == 0) {
					if (objexibir.error(nomeSoftware, softBD.getlistaSoftware()) == 1) {
						if (softwareEscolhido.size() > 0) {
							softwareEscolhido.add(objexibir.testeSoftwareRepetido(softwareEscolhido, nomeSoftware));
							if (softwareEscolhido.get(softwareEscolhido.size() - 1) == "")
								softwareEscolhido.remove(softwareEscolhido.size() - 1);
						} else if (softwareEscolhido.size() == 0)
							softwareEscolhido.add(nomeSoftware);
					}
					rply = objexibir.continuaLendoSoftware(softwareEscolhido);
				}
			}

			Formatacao format = new Formatacao();
			CPUBD cpubd = new CPUBD();
			RecCPUBD reccpu = new RecCPUBD();
			GPUBD gpubd = new GPUBD();
			RecGPUBD recgpu = new RecGPUBD();
			RAMBD rambd = new RAMBD();
			RecRamBD recram = new RecRamBD();
			OrganizaBD org = new OrganizaBD(softwareEscolhido);

			if (softwareEscolhido.size() > 0) {
				for (byte i = 0; i < softwareEscolhido.size(); ++i) {
					softwareEscolhido.set(i, format.ajuste(softwareEscolhido.get(i), softBD.getlistaSoftware()));
					org.juntaRequisitos(reccpu.getRecCPUBD(softwareEscolhido.get(i)),
							recgpu.getRecGPUBD(softwareEscolhido.get(i)),
							recram.getRecRAMBD(softwareEscolhido.get(i)),
							i);
				}
				objexibir.exibirConfiguraçãoMinima(softwareEscolhido, cpubd.getMinimaCPUBD(org.cpuRequisito()),
						gpubd.getMinimaGPUBD(org.gpuRequisito()), rambd.getMinimaRAMBD(org.ramRequisito()));
				objexibir.exibirConfiguraçãoRecomendada(softwareEscolhido,
						cpubd.getRecomendadaCPUBD(org.cpuRequisito()),
						gpubd.getRecomendadaGPUBD(org.gpuRequisito()),
						rambd.getRecomendadaRAMBD(org.ramRequisito()));
			}
			loopOn = objexibir.continuar();
			if (loopOn)
				rply = true;
		}
	}
}