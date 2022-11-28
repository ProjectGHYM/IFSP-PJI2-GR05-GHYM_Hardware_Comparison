package ModelNegocio;

import ModelDAO.CPUBD;
import ModelDAO.GPUBD;
import ModelDAO.RAMBD;
import ModelEntidade.CPU;
import ModelEntidade.GPU;
import ModelEntidade.RAM;
import ModelEntidade.RecomendacaoCPU;
import ModelEntidade.RecomendacaoGPU;
import ModelEntidade.RecomendacaoRAM;

public class AchaCompativel 
{
    public CPU[] achaCPUMaxCompativeis(RecomendacaoCPU cpuRequisito) 
    {
        CPU[] cpusCompativeis;
        // Aqui fica os indices das CPUS compativeis, isso foi feito para não se percorrer toda a lista duas vezes, já que não sabemos como manipular coleção dinâmicas.
        String indiceCPUsCompativeis = ""; 
        
        for (int i = 0; i < CPUBD.listaProcessador.length; i++) 
        {
            if ((CPUBD.listaProcessador[i].getCore() >= cpuRequisito.getCoreMax() && CPUBD.listaProcessador[i].getClock() >= cpuRequisito.getClockMax()))
            {
                indiceCPUsCompativeis += String.format((CPUBD.listaProcessador[i].getId() - 1) + "-");
            }
        }
    
        String[] arrayIndicesComapativeis = indiceCPUsCompativeis.split("-");
        cpusCompativeis = new CPU[arrayIndicesComapativeis.length];
        
        for(int i = 0; i < cpusCompativeis.length; i++)
        {
            cpusCompativeis[i] = CPUBD.listaProcessador[Integer.parseInt(arrayIndicesComapativeis[i])];    
        }

        return cpusCompativeis;
    }

    public CPU[] achaCPUMinCompativeis(RecomendacaoCPU cpuRequisito) 
    {
        CPU[] cpusCompativeis;
        // Aqui fica os indices das CPUS compativeis, isso foi feito para não se percorrer toda a lista duas vezes, já que não sabemos como manipular coleção dinâmicas.
        String indiceCPUsCompativeis = ""; 
        
        for (int i = 0; i < CPUBD.listaProcessador.length; i++) 
        {
            System.out.println(CPUBD.listaProcessador[i].getNome() + "  "+CPUBD.listaProcessador[i].getCore() + " " + cpuRequisito.getCoreMin() + " " + cpuRequisito.getCoreMax() + " " + cpuRequisito.getClockMin() + " " + CPUBD.listaProcessador[i].getClock() + " " + cpuRequisito.getClockMax());
            if ((CPUBD.listaProcessador[i].getCore() >= cpuRequisito.getCoreMin() && CPUBD.listaProcessador[i].getCore() <= cpuRequisito.getCoreMax()) && (CPUBD.listaProcessador[i].getClock() >= cpuRequisito.getClockMin() && CPUBD.listaProcessador[i].getClock() <= cpuRequisito.getClockMax()))
            {
                indiceCPUsCompativeis += String.format((CPUBD.listaProcessador[i].getId() - 1) + "-");
            }
        }
    
        String[] arrayIndicesComapativeis = indiceCPUsCompativeis.split("-");
        cpusCompativeis = new CPU[arrayIndicesComapativeis.length];
        
        for(int i = 0; i < cpusCompativeis.length; i++)
        {
            cpusCompativeis[i] = CPUBD.listaProcessador[Integer.parseInt(arrayIndicesComapativeis[i])];    
        }

        return cpusCompativeis;
    }

    public GPU[] achaGPUMaxCompativeis(RecomendacaoGPU cpuRequisito) 
    {
        GPU[] gpusCompativeis;
        // Aqui fica os indices das GPUS compativeis, isso foi feito para não se percorrer toda a lista duas vezes, já que não sabemos como manipular coleção dinâmicas.
        String indiceGPUsCompativeis = ""; 
        
        for (int i = 0; i < GPUBD.listaGPU.length; i++) 
        {
            if (GPUBD.listaGPU[i].getVRAM() >= cpuRequisito.getVramMax() && GPUBD.listaGPU[i].getClock() >= cpuRequisito.getClockMax())
            {
                indiceGPUsCompativeis += String.format((GPUBD.listaGPU[i].getId() - 1) + "-");
            }
        }
    
        String[] arrayIndicesComapativeis = indiceGPUsCompativeis.split("-");
        gpusCompativeis = new GPU[arrayIndicesComapativeis.length];
        
        for(int i = 0; i < gpusCompativeis.length; i++)
        {
            gpusCompativeis[i] = GPUBD.listaGPU[Integer.parseInt(arrayIndicesComapativeis[i])];    
        }

        return gpusCompativeis;
    }

    public GPU[] achaGPUMinCompativeis(RecomendacaoGPU cpuRequisito) 
    {
        GPU[] gpusCompativeis;
        // Aqui fica os indices das GPUS compativeis, isso foi feito para não se percorrer toda a lista duas vezes, já que não sabemos como manipular coleção dinâmicas.
        String indiceGPUsCompativeis = ""; 
        
        for (int i = 0; i < GPUBD.listaGPU.length; i++) 
        {
            if ((GPUBD.listaGPU[i].getVRAM() >= cpuRequisito.getVramMin() && GPUBD.listaGPU[i].getVRAM() <= cpuRequisito.getVramMax()) && (GPUBD.listaGPU[i].getClock() >= cpuRequisito.getClockMin() && GPUBD.listaGPU[i].getClock() <= cpuRequisito.getClockMax()))
            {
                indiceGPUsCompativeis += String.format((GPUBD.listaGPU[i].getId() - 1) + "-");
            }
        }
    
        String[] arrayIndicesComapativeis = indiceGPUsCompativeis.split("-");
        gpusCompativeis = new GPU[arrayIndicesComapativeis.length];
        
        for(int i = 0; i < gpusCompativeis.length; i++)
        {
            gpusCompativeis[i] = GPUBD.listaGPU[Integer.parseInt(arrayIndicesComapativeis[i])];    
        }

        return gpusCompativeis;
    }

    public RAM[] achaRAMMaxCompativel(RecomendacaoRAM ramRequisito)
    {
        RAM[] ramsCompativeis;
        // Aqui fica os indices das CPUS compativeis, isso foi feito para não se percorrer toda a lista duas vezes, já que não sabemos como manipular coleção dinâmicas.
        String indiceRAMsCompativeis = ""; 
        
        for (int i = 0; i < RAMBD.listaRAM.length; i++) 
        {
            if (RAMBD.listaRAM[i].getCapacidade() >= ramRequisito.getCapacidadeMax())
            {
                indiceRAMsCompativeis += String.format((RAMBD.listaRAM[i].getId() - 1) + "-");
            }
        }
    
        String[] arrayIndicesComapativeis = indiceRAMsCompativeis.split("-");
        ramsCompativeis = new RAM[arrayIndicesComapativeis.length];
        
        for(int i = 0; i < ramsCompativeis.length; i++)
        {
            ramsCompativeis[i] = RAMBD.listaRAM[Integer.parseInt(arrayIndicesComapativeis[i])];    
        }

        return ramsCompativeis;
    }

    public RAM[] achaRAMMinCompativel(RecomendacaoRAM ramRequisito)
    {
        RAM[] ramsCompativeis;
        // Aqui fica os indices das CPUS compativeis, isso foi feito para não se percorrer toda a lista duas vezes.
        String indiceRAMsCompativeis = ""; 
        
        for (int i = 0; i < RAMBD.listaRAM.length; i++) 
        {
            if (RAMBD.listaRAM[i].getCapacidade() >= ramRequisito.getCapacidadeMin() && RAMBD.listaRAM[i].getCapacidade() <= ramRequisito.getCapacidadeMax())
            {
                indiceRAMsCompativeis += String.format((RAMBD.listaRAM[i].getId() - 1) + "-");
            }
        }
    
        String[] arrayIndicesComapativeis = indiceRAMsCompativeis.split("-");
        ramsCompativeis = new RAM[arrayIndicesComapativeis.length];
        
        for(int i = 0; i < ramsCompativeis.length; i++)
        {
            ramsCompativeis[i] = RAMBD.listaRAM[Integer.parseInt(arrayIndicesComapativeis[i])];    
        }

        return ramsCompativeis;
    }
}
