package com.mycompany.trabalho;

import classesPrincipais.Pagamento;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author menezes
 */
public class TelaPayment extends javax.swing.JFrame {

    private JTextField valorField;
    private JLabel tituloLabel, nomeLabel, servicoLabel, valorLabel, valorComDescontoLabel;
    private JButton btnDinheiro, btnCartao, btnPix, btnConfirmar;
    private String metodoSelecionado;
    private String nomeCliente;
    private String servico;

    /**
     * Creates new form TelaPayment
     */
    public TelaPayment(String nomeCliente, String servico) {
        this.nomeCliente = (nomeCliente == null || nomeCliente.isEmpty()) ? "Cliente" : nomeCliente;
        this.servico = (servico == null || servico.isEmpty()) ? "Serviço Qualquer" : servico;

        initComponents(); // Mantém a inicialização do NetBeans
        configurarComponentesExtras(); // Método para adicionar os novos componentes personalizados
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Pagamento");
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configurarComponentesExtras() {
        setTitle("Tela de Pagamento");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#D3D3D3"));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout());
        infoPanel.setBackground(Color.decode("#D3D3D3"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        tituloLabel = new JLabel("Informações de Pagamento");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        infoPanel.add(tituloLabel, gbc);

        nomeLabel = new JLabel("Nome: " + this.nomeCliente);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 17));
        gbc.gridy = 1;
        infoPanel.add(nomeLabel, gbc);

        servicoLabel = new JLabel("Serviço: " + this.servico);
        servicoLabel.setFont(new Font("Arial", Font.BOLD, 17));
        gbc.gridy = 2;
        infoPanel.add(servicoLabel, gbc);

        valorLabel = new JLabel("Preço base do serviço prestado: ");
        valorLabel.setFont(new Font("Arial", Font.BOLD, 17));
        gbc.gridy = 3;
        infoPanel.add(valorLabel, gbc);

        valorField = new JTextField(10);
        gbc.gridx = 1;
        infoPanel.add(valorField, gbc);

        valorComDescontoLabel = new JLabel(" ");
        valorComDescontoLabel.setFont(new Font("Arial", Font.BOLD, 17));
        gbc.gridy = 4;
        gbc.gridx = 0;
        infoPanel.add(valorComDescontoLabel, gbc);

        add(infoPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 5, 5));
        buttonPanel.setBackground(Color.decode("#D3D3D3"));

        JPanel paymentMethodsPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        btnDinheiro = new JButton("DINHEIRO");
        btnCartao = new JButton("CARTÃO");
        btnPix = new JButton("PIX");

        configurarBotao(btnDinheiro, "Dinheiro");
        configurarBotao(btnCartao, "Cartão");
        configurarBotao(btnPix, "Pix");

        paymentMethodsPanel.add(btnDinheiro);
        paymentMethodsPanel.add(btnCartao);
        paymentMethodsPanel.add(btnPix);

        btnConfirmar = new JButton("PAGAMENTO CONCLUÍDO");
        btnConfirmar.setBackground(Color.decode("#89CFF0"));
        btnConfirmar.setFont(new Font("Arial", Font.BOLD, 18));
        btnConfirmar.addActionListener(e -> confirmarPagamento());

        buttonPanel.add(paymentMethodsPanel);
        buttonPanel.add(btnConfirmar);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void configurarBotao(JButton botao, String metodo) {
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.addActionListener(e -> {
            metodoSelecionado = metodo;
            btnDinheiro.setBackground(null);
            btnCartao.setBackground(null);
            btnPix.setBackground(null);
            botao.setBackground(Color.LIGHT_GRAY);
            atualizarValorComDesconto();
        });
    }

    private void atualizarValorComDesconto() {
        try {
            double valor = Double.parseDouble(valorField.getText());
            if (metodoSelecionado != null && (metodoSelecionado.equalsIgnoreCase("Dinheiro") || metodoSelecionado.equalsIgnoreCase("Pix"))) {
                valor *= 0.95; // Aplicar 5% de desconto
            }
            valorComDescontoLabel.setText("Valor final: R$" + String.format("%.2f", valor));
        } catch (NumberFormatException ex) {
            valorComDescontoLabel.setText("Valor final: ");
        }
    }

    private void confirmarPagamento() {
        try {
            double valor = Double.parseDouble(valorField.getText());
            if (metodoSelecionado != null) {
                if (metodoSelecionado.equalsIgnoreCase("Dinheiro") || metodoSelecionado.equalsIgnoreCase("Pix")) {
                    valor *= 0.95;
                }
                Pagamento pagamento = new Pagamento(nomeCliente, servico, valor, metodoSelecionado);
                pagamento.salvarHistorico();

                int opcao = JOptionPane.showOptionDialog(null,
                        "Pagamento registrado!\n\n" +
                                "Nome: " + nomeCliente + "\n" +
                                "Serviço: " + servico + "\n" +
                                "Valor: R$" + String.format("%.2f", valor) + "\n" +
                                "Método: " + metodoSelecionado,
                        "Confirmação", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null,
                        new String[]{"Exibir Histórico", "OK"}, "OK");

                if (opcao == 0) {
                    exibirHistorico();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Escolha um método de pagamento.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirHistorico() {
        String historico = Pagamento.obterHistorico();
        JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(historico)), "Histórico de Pagamentos", JOptionPane.INFORMATION_MESSAGE);
    }
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        new TelaPayment("Cliente Exemplo", "Serviço Exemplo").setVisible(true);
    });
}

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

