package ModelDAO;

import java.util.ArrayList;

public class OrganizaBD {
    static float requisitoSoft[][];

    public static float[][] getrequisitoSoft() {
        return requisitoSoft;
    }

    public static void setrequisitoSoft(float requisitoSoft[][]) {
        OrganizaBD.requisitoSoft = requisitoSoft;
    }

    public OrganizaBD(ArrayList<String> softwareEscolhido) {
        requisitoSoft = new float[softwareEscolhido.size()][6];
        OrganizaBD.setrequisitoSoft(requisitoSoft);
    }

    public void juntaRequisitos(String requisitoCPU[], String requisitoGPU[], String requisitoRAM[],
            byte numeroDeSoftware) {
        requisitoSoft[numeroDeSoftware][0] = Float.parseFloat(requisitoCPU[0]) * Float.parseFloat(requisitoCPU[1]);
        requisitoSoft[numeroDeSoftware][1] = Float.parseFloat(requisitoCPU[2]) * Float.parseFloat(requisitoCPU[3]);
        requisitoSoft[numeroDeSoftware][2] = Float.parseFloat(requisitoGPU[0]) * Float.parseFloat(requisitoGPU[1]);
        requisitoSoft[numeroDeSoftware][3] = Float.parseFloat(requisitoGPU[2]) * Float.parseFloat(requisitoGPU[3]);
        requisitoSoft[numeroDeSoftware][4] = Float.parseFloat(requisitoRAM[0]);
        requisitoSoft[numeroDeSoftware][5] = Float.parseFloat(requisitoRAM[1]);
        OrganizaBD.setrequisitoSoft(requisitoSoft);
    }

    public float[] cpuRequisito() {
        return RecomendacaoMultiplosSoftwares(0, 1); // Equivalente no array
    }

    public float[] gpuRequisito() {
        return RecomendacaoMultiplosSoftwares(2, 3); // Equivalente no array
    }

    public float[] ramRequisito() {
        return RecomendacaoMultiplosSoftwares(4, 5); // Equivalente no array
    }

    public float[] RecomendacaoMultiplosSoftwares(int posicaoPrimeiroVetor, int posicaoSegundoVetor) {
        float maiorRequisito[] = new float[2];

        for (byte i = 0; i < requisitoSoft.length; ++i) {
            if (requisitoSoft[i][posicaoPrimeiroVetor] > maiorRequisito[0])
                maiorRequisito[0] = requisitoSoft[i][posicaoPrimeiroVetor];

            if (requisitoSoft[i][posicaoSegundoVetor] > maiorRequisito[1])
                maiorRequisito[1] = requisitoSoft[i][posicaoSegundoVetor];
        }
        return maiorRequisito;
    }
}
