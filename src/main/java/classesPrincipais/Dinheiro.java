package classesPrincipais;

class Dinheiro extends Pagamento {

    public Dinheiro(String nomeCliente, String servico, double valor, String metodoPagamento) {
        super(nomeCliente, servico, valor, metodoPagamento);
    }
    
    public boolean realizarPagamento(float valor) {
        return false;
    }
}
