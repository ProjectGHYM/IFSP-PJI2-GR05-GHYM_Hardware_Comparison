package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JFrame {
    private int resposta = -1;

    private void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public int telaMenu() {
        setTitle("Menu GHYM");
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(Color.BLACK);
        setForeground(Color.BLACK);

        JButton botaoSoftware = new JButton("Configuração Para Softwares");
        botaoSoftware.setBounds(1, 1, 300, 50);
        botaoSoftware.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoSoftware.setForeground(Color.WHITE);
        botaoSoftware.setBackground(Color.GRAY);

        JButton botaoHardware = new JButton("Comparação De Hardware");
        botaoHardware.setBounds(1, 1, 300, 50);
        botaoHardware.setFont(new Font("Arial", Font.PLAIN, 20));
        botaoHardware.setForeground(Color.WHITE);
        botaoHardware.setBackground(Color.GRAY);

        JLabel texto = new JLabel("Escolha Uma Das Nossas Funcionalidades:");
        texto.setBounds(300, 100, 400, 50);
        texto.setFont(new Font("Arial", Font.PLAIN, 20));
        texto.setForeground(Color.WHITE);

        JPanel painel = new JPanel();
        painel.setBounds(0, 0, JFrame.WIDTH, JFrame.HEIGHT);
        painel.setBackground(Color.DARK_GRAY);

        add(botaoSoftware);
        add(botaoHardware);
        add(texto);
        add(painel);

        botaoSoftware.addActionListener(this::configuracaoSoftware);
        botaoHardware.addActionListener(this::comparacaoHardware);

        return resposta;
    }

    private void configuracaoSoftware(ActionEvent e) {
        setResposta(0);
    }

    private void comparacaoHardware(ActionEvent e) {
        setResposta(1);
    }
}
