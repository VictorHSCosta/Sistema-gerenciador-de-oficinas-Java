package classesPrincipais;

class CartaoCredito extends Pagamento {

    public CartaoCredito(String nomeCliente, String servico, double valor, String metodoPagamento) {
        super(nomeCliente, servico, valor, metodoPagamento);
    }
    
    public boolean realizarPagamento(float valor) {
        return false; // Implementação futura
    }
}
