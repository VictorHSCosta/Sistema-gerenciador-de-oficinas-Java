package controller;

import classesPrincipais.Cliente;
import classesPrincipais.Veiculo;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    private static Controller instance; // Instância única
    private final HashMap<String, Cliente> clientes = new HashMap<>();
    private int id = 0;

    // Nome do arquivo onde os dados serão salvos
    private final String ARQUIVO_DADOS = "dados.json";

    // Construtor privado para evitar instâncias externas
    private Controller() {}

    // Método para obter a única instância da classe
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // ========= Métodos de Serialização/Desserialização =========

    /**
     * Classe interna que "envolve" o estado do Controller para facilitar a serialização.
     */
    private static class DataWrapper {
        private HashMap<String, Cliente> clientes;
        private int id;
    }

    /**
     * Salva os dados atuais do Controller em um arquivo JSON.
     */
    public void salvarDados() {
        DataWrapper data = new DataWrapper();
        data.clientes = this.clientes;
        data.id = this.id;

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(ARQUIVO_DADOS)) {
            gson.toJson(data, writer);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega os dados do arquivo JSON e restaura o estado do Controller.
     */
    public void carregarDados() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(ARQUIVO_DADOS)) {
            DataWrapper data = gson.fromJson(reader, DataWrapper.class);
            if (data != null) {
                this.clientes.clear();
                this.clientes.putAll(data.clientes);
                this.id = data.id;
                System.out.println("Dados carregados com sucesso!");
            }
        } catch (FileNotFoundException e) {
            // Arquivo não existe – provavelmente é a primeira execução
            System.out.println("Arquivo de dados não encontrado. Iniciando com dados vazios.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // =================== Métodos já implementados ===================

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
