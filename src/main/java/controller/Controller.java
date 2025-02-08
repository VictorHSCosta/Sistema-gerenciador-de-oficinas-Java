package controller;
import classesPrincipais.Cliente;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author victor-costa
 */
public class Controller {

    private final HashMap<String, Cliente> clientes = new HashMap<>();
    private int id = 0;

    public HashMap<String, String> getClientePorCpf(String cpf) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            HashMap<String, String> clienteData = new HashMap<>();
            clienteData.put("id", String.valueOf(cliente.getId()));
            clienteData.put("nome", cliente.getNome());
            clienteData.put("cpf", cliente.getCpf());
            clienteData.put("telefone", cliente.getTelefone());
            return clienteData;
        }
        return null;
    }

    public void criarCliente(String nome, String cpf, String telefone) {
        if (nome == null || cpf == null || telefone == null) {
            throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");
        }
        if (!clientes.containsKey(cpf)) {
            clientes.put(cpf, new Cliente(id++, nome, cpf, telefone));
        } else {
            System.out.println("Cliente já existe no banco de dados");
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
            clientesMap.put(cliente.getCpf(), clienteData);
        }
        return clientesMap;
    }

    public void deletarCliente(String cpf) {
        if (clientes.containsKey(cpf)) {
            clientes.remove(cpf);
            System.out.printf("Cliente %s deletado com sucesso", cpf);
        }
    }

}
