package classesPrincipais;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonDatabase {

    private static final ObjectMapper mapper = new ObjectMapper();

    // Método para armazenar Cliente (usa o CPF como chave primária)
    public static void armazenarCliente(Cliente cliente) {
        File file = new File("cliente.json");
        List<Cliente> clientes = new ArrayList<>();

        // Lê os clientes já armazenados, se o arquivo existir
        if(file.exists()){
            try {
                clientes = mapper.readValue(file, new TypeReference<List<Cliente>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Verifica se já existe um cliente com o mesmo CPF
        boolean existe = false;
        for (Cliente c : clientes) {
            // Supondo que a classe Cliente (ou sua classe pai Pessoa) possua o método getCpf()
            if (c.getCpf().equals(cliente.getCpf())) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            clientes.add(cliente);
            try {
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, clientes);
                System.out.println("Cliente armazenado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Cliente com CPF " + cliente.getCpf() + " já existe.");
        }
    }

    // Método para armazenar Funcionario (usa o CPF como chave primária)
    public static void armazenarFuncionario(Funcionario funcionario) {
        File file = new File("funcionario.json");
        List<Funcionario> funcionarios = new ArrayList<>();

        if (file.exists()) {
            try {
                funcionarios = mapper.readValue(file, new TypeReference<List<Funcionario>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean existe = false;
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(funcionario.getCpf())) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            funcionarios.add(funcionario);
            try {
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, funcionarios);
                System.out.println("Funcionário armazenado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Funcionário com CPF " + funcionario.getCpf() + " já existe.");
        }
    }

    // Método para armazenar Servico (usa o id como chave primária)
    public static void armazenarServico(Servico servico) {
        File file = new File("servico.json");
        List<Servico> servicos = new ArrayList<>();

        if (file.exists()) {
            try {
                servicos = mapper.readValue(file, new TypeReference<List<Servico>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean existe = false;
        for (Servico s : servicos) {
            if (s.getId() == servico.getId()) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            servicos.add(servico);
            try {
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, servicos);
                System.out.println("Serviço armazenado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Serviço com ID " + servico.getId() + " já existe.");
        }
    }

    // Método para armazenar Veiculo (usa a placa como chave primária)
    public static void armazenarVeiculo(Veiculo veiculo) {
        File file = new File("veiculo.json");
        List<Veiculo> veiculos = new ArrayList<>();

        if (file.exists()) {
            try {
                veiculos = mapper.readValue(file, new TypeReference<List<Veiculo>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean existe = false;
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            veiculos.add(veiculo);
            try {
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, veiculos);
                System.out.println("Veículo armazenado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Veículo com placa " + veiculo.getPlaca() + " já existe.");
        }
    }

    // Método para armazenar ServicoOferecido (usa o id como chave primária)
    public static void armazenarServicoOferecido(ServicoOferecido servicoOferecido) {
        File file = new File("servicoOferecido.json");
        List<ServicoOferecido> servicosOferecidos = new ArrayList<>();

        if (file.exists()) {
            try {
                servicosOferecidos = mapper.readValue(file, new TypeReference<List<ServicoOferecido>>() {});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean existe = false;
        for (ServicoOferecido s : servicosOferecidos) {
            if (s.getId() == servicoOferecido.getId()) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            servicosOferecidos.add(servicoOferecido);
            try {
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, servicosOferecidos);
                System.out.println("Serviço Oferecido armazenado com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Serviço Oferecido com ID " + servicoOferecido.getId() + " já existe.");
        }
    }
}

