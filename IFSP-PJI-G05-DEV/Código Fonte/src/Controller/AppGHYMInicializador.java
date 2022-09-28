package Controller;

import java.util.ArrayList;
import ModelNegocio.Requisitos;
import View.Exibicao;

public class AppGHYMInicializador {
	public static void main(String[] args) {
		boolean loopOn = true, rply = true;
		String nomesoft;
		Exibicao objexibir = new Exibicao();
		Requisitos objrequisito = new Requisitos();

		objexibir.HiSystem();

		while (loopOn) {
			ArrayList<String> escsoft = new ArrayList<String>();
			while(rply){
				nomesoft = objexibir.veSoftware();
				if (objexibir.confirmaSoftRec(nomesoft) == 0) {
					if(objexibir.Error(nomesoft) == 1){
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
			if(escsoft.size() >= 1){
				for (byte i = 0; i < escsoft.size(); ++i){
					for (byte j = 0; j < 2; j++) {
						String recomenda = objrequisito.verifSoftware(escsoft.set(i, objexibir.Ajuste(escsoft.get(i))), j);
						objexibir.exiberecomendacao(escsoft.get(i), recomenda, j);
					}
				}
			}
			loopOn = objexibir.continuar();
			if(loopOn){
				rply = true;
			}
		}

	}
}