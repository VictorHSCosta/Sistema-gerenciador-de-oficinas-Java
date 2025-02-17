package classesPrincipais;

class Pix extends Pagamento {

    public Pix(String nomeCliente, String servico, double valor, String metodoPagamento) {
        super(nomeCliente, servico, valor, metodoPagamento);
    }
    
    public boolean realizarPagamento(float valor) {
        return false;
    }
}

