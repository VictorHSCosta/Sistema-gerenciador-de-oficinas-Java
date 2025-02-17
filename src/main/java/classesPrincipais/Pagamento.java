package classesPrincipais;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pagamento {
    private String nomeCliente;
    private String servico;
    private double valor;
    private String metodoPagamento;

    public Pagamento(String nomeCliente, String servico, double valor, String metodoPagamento) {
        this.nomeCliente = (nomeCliente == null || nomeCliente.isEmpty()) ? "Cliente" : nomeCliente;
        this.servico = (servico == null || servico.isEmpty()) ? "Serviço Qualquer" : servico;
        this.valor = calcularDesconto(valor, metodoPagamento);
        this.metodoPagamento = metodoPagamento;
    }

    private double calcularDesconto(double valor, String metodo) {
        if (metodo.equalsIgnoreCase("Dinheiro") || metodo.equalsIgnoreCase("Pix")) {
            return valor * 0.95; // 5% de desconto
        }
        return valor;
    }

    public void salvarHistorico() {
        try (FileWriter writer = new FileWriter("historico_pagamentos.txt", true)) {
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String registro = String.format("%s - Cliente: %s | Serviço: %s | Valor: R$%.2f | Método: %s\n", 
                                            dataHora, nomeCliente, servico, valor, metodoPagamento);
            writer.write(registro);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String obterHistorico() {
        StringBuilder historico = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("historico_pagamentos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                historico.append(linha).append("\n");
            }
        } catch (IOException e) {
            return "Erro ao carregar histórico.";
        }
        return historico.toString().isEmpty() ? "Nenhum pagamento registrado ainda." : historico.toString();
    }
}
