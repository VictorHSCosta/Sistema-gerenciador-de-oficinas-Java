package classesPrincipais;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoPagamento {
    public static void salvarPagamento(Pagamento pagamento) {
        try (FileWriter writer = new FileWriter("historico_pagamentos.txt", true)) {
            String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            writer.write(data + " - " + pagamento.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

