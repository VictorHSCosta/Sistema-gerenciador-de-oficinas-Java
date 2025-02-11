package classesPrincipais;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Cliente(int id, String nome, String cpf, String telefone) {
        super(id, nome, telefone, cpf);
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
