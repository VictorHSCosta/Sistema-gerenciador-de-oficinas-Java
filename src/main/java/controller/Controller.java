package controller;

import classesPrincipais.Cliente;
import classesPrincipais.Veiculo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private static Controller instance; // Instância única
    private final HashMap<String, Cliente> clientes = new HashMap<>();
    private int id = 0;

    // Construtor privado para evitar instâncias externas
    private Controller() {}

    // Método para obter a única instância da classe
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // Métodos da classe (como já implementados)

    public HashMap<String, String> getClientePorCpf(String cpf) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            HashMap<String, String> clienteData = new HashMap<>();
            clienteData.put("id", String.valueOf(cliente.getId()));
            clienteData.put("nome", cliente.getNome());
            clienteData.put("cpf", cliente.getCpf());
            clienteData.put("telefone", cliente.getTelefone());

            ArrayList<Veiculo> veiculos = cliente.getVeiculos();
            if (veiculos != null && !veiculos.isEmpty()) {
                StringBuilder veiculosStr = new StringBuilder();
                for (Veiculo veiculo : veiculos) {
                    veiculosStr.append(String.format(
                            "[Placa: %s, Marca: %s, Modelo: %s, Cor: %s, Ano de Fabricação: %d, Ano Modelo: %d, Quilometragem: %d] ",
                            veiculo.getPlaca(),
                            veiculo.getMarca(),
                            veiculo.getModelo(),
                            veiculo.getCor(),
                            veiculo.getAnoFabricacao(),
                            veiculo.getAnoModelo(),
                            veiculo.getQuilometragem()
                    ));
                }
                clienteData.put("veiculos", veiculosStr.toString());
            } else {
                clienteData.put("veiculos", "Nenhum veículo associado");
            }
            return clienteData;
        }
        return null;
    }

    public boolean criarCliente(String nome, String cpf, String telefone) {
        if (nome == null || cpf == null || telefone == null) {
            throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");
        }
        if (!clientes.containsKey(cpf)) {
            clientes.put(cpf, new Cliente(id++, nome, cpf, telefone));
            return true;
        } else {
            System.out.println("Cliente já existe no banco de dados");
            return false;
        }
    }

    public boolean editarCliente(String cpf, String novoNome, String novoTelefone) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            if (novoNome != null) cliente.setNome(novoNome);
            if (novoTelefone != null) cliente.setTelefone(novoTelefone);
            return true;
        }
        return false;
    }

    public Map<String, Map<String, String>> getClientes() {
        Map<String, Map<String, String>> clientesMap = new HashMap<>();
        for (Cliente cliente : clientes.values()) {
            Map<String, String> clienteData = new HashMap<>();
            clienteData.put("id", String.valueOf(cliente.getId()));
            clienteData.put("nome", cliente.getNome());
            clienteData.put("cpf", cliente.getCpf());
            clienteData.put("telefone", cliente.getTelefone());

            ArrayList<Veiculo> veiculos = cliente.getVeiculos();
            if (veiculos != null && !veiculos.isEmpty()) {
                StringBuilder veiculosStr = new StringBuilder();
                for (Veiculo veiculo : veiculos) {
                    veiculosStr.append(String.format(
                            "[Placa: %s, Marca: %s, Modelo: %s, Cor: %s, Ano de Fabricação: %d, Ano Modelo: %d, Quilometragem: %d] ",
                            veiculo.getPlaca(),
                            veiculo.getMarca(),
                            veiculo.getModelo(),
                            veiculo.getCor(),
                            veiculo.getAnoFabricacao(),
                            veiculo.getAnoModelo(),
                            veiculo.getQuilometragem()
                    ));
                }
                clienteData.put("veiculos", veiculosStr.toString());
            } else {
                clienteData.put("veiculos", "Nenhum veículo associado");
            }
            clientesMap.put(cliente.getCpf(), clienteData);
        }
        return clientesMap;
    }

    public void deletarCliente(String cpf) {
        if (clientes.containsKey(cpf)) {
            clientes.remove(cpf);
            System.out.printf("Cliente %s deletado com sucesso%n", cpf);
        }
    }

    public void adicionarVeiculoAoCliente(String cpf, String placa, String marca, String modelo,
                                          String cor, int anoFabricacao, int anoModelo, int quilometragem) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            Veiculo novoVeiculo = new Veiculo(placa, marca, modelo, cor, anoFabricacao, anoModelo, quilometragem);
            cliente.getVeiculos().add(novoVeiculo);
            System.out.println("Veículo adicionado com sucesso ao cliente " + cpf);
        } else {
            System.out.println("Cliente não encontrado para adicionar veículo.");
        }
    }

    /**
     * Edita os dados de um veículo associado a um cliente.
     *
     * @param cpf               CPF do cliente
     * @param placa             Placa do veículo que será editado
     * @param novaMarca         Nova marca (se null, não atualiza)
     * @param novoModelo        Novo modelo (se null, não atualiza)
     * @param novaCor           Nova cor (se null, não atualiza)
     * @param novoAnoFabricacao Novo ano de fabricação (se negativo, não atualiza)
     * @param novoAnoModelo     Novo ano modelo (se negativo, não atualiza)
     * @param novaQuilometragem Nova quilometragem (se negativa, não atualiza)
     * @return true se o veículo foi editado com sucesso; false caso contrário.
     */
    public boolean editarVeiculoDoCliente(String cpf, String placa, String novaMarca, String novoModelo,
                                          String novaCor, int novoAnoFabricacao, int novoAnoModelo, int novaQuilometragem) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            for (Veiculo veiculo : cliente.getVeiculos()) {
                if (veiculo.getPlaca().equals(placa)) {
                    if (novaMarca != null) {
                        veiculo.setMarca(novaMarca);
                    }
                    if (novoModelo != null) {
                        veiculo.setModelo(novoModelo);
                    }
                    if (novaCor != null) {
                        veiculo.setCor(novaCor);
                    }
                    // Atualiza os valores numéricos somente se os novos valores forem válidos (maiores ou iguais a zero)
                    if (novoAnoFabricacao >= 0) {
                        veiculo.setAnoFabricacao(novoAnoFabricacao);
                    }
                    if (novoAnoModelo >= 0) {
                        veiculo.setAnoModelo(novoAnoModelo);
                    }
                    if (novaQuilometragem >= 0) {
                        veiculo.setQuilometragem(novaQuilometragem);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Deleta um veículo associado a um cliente.
     *
     * @param cpf   CPF do cliente
     * @param placa Placa do veículo que será removido
     * @return true se o veículo foi removido com sucesso; false caso contrário.
     */
    public boolean deletarVeiculoDoCliente(String cpf, String placa) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            ArrayList<Veiculo> veiculos = cliente.getVeiculos();
            for (int i = 0; i < veiculos.size(); i++) {
                if (veiculos.get(i).getPlaca().equals(placa)) {
                    veiculos.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retorna uma lista com a placa e o modelo de cada veículo associado ao cliente.
     * Exemplo de retorno: ["had3423 corrola", "ad324ea civic"]
     *
     * @param cpf CPF do cliente
     * @return Lista de strings contendo a placa e o modelo de cada veículo. Se o cliente não existir
     *         ou não possuir veículos, retorna uma lista vazia.
     */
    public ArrayList<String> listarVeiculosDoCliente(String cpf) {
        ArrayList<String> lista = new ArrayList<>();
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            for (Veiculo veiculo : cliente.getVeiculos()) {
                lista.add(veiculo.getPlaca() + " " + veiculo.getModelo());
            }
        }
        return lista;
    }
    
    
    public ArrayList<HashMap<String, String>> getTodosOsVeiculos() {
    ArrayList<HashMap<String, String>> veiculosLista = new ArrayList<>();

    for (Cliente cliente : clientes.values()) {
        for (Veiculo veiculo : cliente.getVeiculos()) {
            HashMap<String, String> veiculoData = new HashMap<>();
            veiculoData.put("dono", cliente.getNome());
            veiculoData.put("cpf", cliente.getCpf());
            veiculoData.put("placa", veiculo.getPlaca());
            veiculoData.put("marca", veiculo.getMarca());
            veiculoData.put("modelo", veiculo.getModelo());
            veiculoData.put("cor", veiculo.getCor());
            veiculoData.put("anoFabricacao", String.valueOf(veiculo.getAnoFabricacao()));
            veiculoData.put("anoModelo", String.valueOf(veiculo.getAnoModelo()));
            veiculoData.put("quilometragem", String.valueOf(veiculo.getQuilometragem()));

            veiculosLista.add(veiculoData);
        }
    }
    return veiculosLista;
}

}