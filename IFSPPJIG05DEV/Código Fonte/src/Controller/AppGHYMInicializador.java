package Controller;

import java.util.ArrayList;
import View.Exibicao;
import ModelDAO.*;

public class AppGHYMInicializador {
	public static void main(String[] args) {
		boolean loopOn = true, rply = true;
		String nomesoft;
		Exibicao objexibir = new Exibicao();
		//SoftwareDAO objDAO = new SoftwareDAO();
		SoftwareBD softBD = new SoftwareBD();
		softBD.readSoftwareBD();

		while (loopOn) {
			ArrayList<String> escsoft = new ArrayList<String>();
			while(rply){
				nomesoft = objexibir.veSoftware();
				if (objexibir.confirmaSoftRec(nomesoft) == 0) {
					if(objexibir.Error(nomesoft, softBD.getNome_softs()) == 1){
						if(escsoft.size() > 0){
							escsoft.add(objexibir.repetiSoft(escsoft, nomesoft));
							if(escsoft.get(escsoft.size() - 1) == ""){
								escsoft.remove(escsoft.size()-1);
							}
						}
						if(escsoft.size() == 0){
							escsoft.add(nomesoft);
						}
					}
					rply = objexibir.continuaSoft();
				}
			}
			CPUBD cpubd = new CPUBD();
			RecCPUBD reccpu = new RecCPUBD();
			GPUBD gpubd = new GPUBD();
			RecGPUBD recgpu = new RecGPUBD();
			RAMBD rambd = new RAMBD();
			RecRamBD recram = new RecRamBD();

			if(escsoft.size() >= 1){
				for (byte i = 0; i < escsoft.size(); ++i){
					escsoft.set(i, objexibir.Ajuste(escsoft.get(i), softBD.getNome_softs()));
					String resultNomeCPU[] = cpubd.getMinCPUBD(reccpu.getRecCPUBD(escsoft.get(i)));
					String resultNomeGPU[] = gpubd.getMinGPUBD(recgpu.getRecGPUBD(escsoft.get(i)));
					String resultNomeRAM[] = rambd.getMinRAMBD(recram.getRecRAMBD(escsoft.get(i)));
					objexibir.exibirMin(escsoft.get(i), resultNomeCPU, resultNomeGPU, resultNomeRAM);

					resultNomeCPU = cpubd.getRecCPUBD(reccpu.getRecCPUBD(escsoft.get(i)));
					resultNomeGPU = gpubd.getRecGPUBD(recgpu.getRecGPUBD(escsoft.get(i)));
					resultNomeRAM = rambd.getRecRAMBD(recram.getRecRAMBD(escsoft.get(i)));
					objexibir.exibirRec(escsoft.get(i), resultNomeCPU, resultNomeGPU, resultNomeRAM);
				}
			}
			loopOn = objexibir.continuar();
			if(loopOn){
				rply = true;
			}
		}
	}
}