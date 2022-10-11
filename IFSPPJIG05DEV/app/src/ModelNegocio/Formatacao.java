package ModelNegocio;

public class Formatacao {
    public String ajuste(String softwareEscolhido, String listaSoftware[]) {
        for (byte i = 0; i < 19; ++i) {
            if (softwareEscolhido.equalsIgnoreCase(listaSoftware[i]))
                softwareEscolhido = listaSoftware[i];
        }
        return softwareEscolhido;
    }
}