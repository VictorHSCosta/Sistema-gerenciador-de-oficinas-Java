package controller;

import classesPrincipais.Funcionario;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerFuncionario {

    private static ControllerFuncionario instance; // Instância única
    private final HashMap<String, Funcionario> funcionarios = new HashMap<>();
    private int id = 0;

    private final String ARQUIVO_DADOS = "dados_funcionarios.json";

    private ControllerFuncionario() {}

    public static ControllerFuncionario getInstance() {
        if (instance == null) {
            instance = new ControllerFuncionario();
        }
        return instance;
    }

    private static class DataWrapper {
        private HashMap<String, Funcionario> funcionarios;
        private int id;
    }

    public void salvarDados() {
        DataWrapper data = new DataWrapper();
        data.funcionarios = this.funcionarios;
        data.id = this.id;

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(ARQUIVO_DADOS)) {
            gson.toJson(data, writer);
            System.out.println("Dados dos funcionários salvos com sucesso!");
        } catch (IOException e) {
        }
    }

    public void carregarDados() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(ARQUIVO_DADOS)) {
            DataWrapper data = gson.fromJson(reader, DataWrapper.class);
            if (data != null) {
                this.funcionarios.clear();
                this.funcionarios.putAll(data.funcionarios);
                this.id = data.id;
                System.out.println("Dados dos funcionários carregados com sucesso!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados de funcionários não encontrado. Iniciando com dados vazios.");
        } catch (IOException e) {
        }
    }

    public Map<String, String> getFuncionarioPorCpf(String cpf) {
        Funcionario funcionario = funcionarios.get(cpf);
        if (funcionario != null) {
            Map<String, String> funcionarioData = new HashMap<>();
            funcionarioData.put("id", String.valueOf(funcionario.getId()));
            funcionarioData.put("nome", funcionario.getNome());
            funcionarioData.put("cpf", funcionario.getCpf());
            funcionarioData.put("telefone", funcionario.getTelefone());
            funcionarioData.put("login", funcionario.getLogin());
            return funcionarioData;
        }
        return null;
    }

    public boolean criarFuncionario(String nome, String cpf, String telefone) {
        if (nome == null || cpf == null || telefone == null) {
            throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");
        }
        if (!funcionarios.containsKey(cpf)) {
            funcionarios.put(cpf, new Funcionario(id++, nome, cpf, telefone));
            return true;
        } else {
            System.out.println("Funcionário já existe no banco de dados");
            return false;
        }
    }

    public boolean editarFuncionario(String cpf, String novoNome, String novoTelefone, String novoLogin, String novaSenha) {
        Funcionario funcionario = funcionarios.get(cpf);
        if (funcionario != null) {
            if (novoNome != null) funcionario.setNome(novoNome);
            if (novoTelefone != null) funcionario.setTelefone(novoTelefone);
            if (novoLogin != null) funcionario.setLogin(novoLogin);
            if (novaSenha != null) funcionario.setSenha(novaSenha);
            return true;
        }
        return false;
    }

    public Map<String, Map<String, String>> getFuncionarios() {
        Map<String, Map<String, String>> funcionariosMap = new HashMap<>();
        for (Funcionario funcionario : funcionarios.values()) {
            Map<String, String> funcionarioData = new HashMap<>();
            funcionarioData.put("id", String.valueOf(funcionario.getId()));
            funcionarioData.put("nome", funcionario.getNome());
            funcionarioData.put("cpf", funcionario.getCpf());
            funcionarioData.put("telefone", funcionario.getTelefone());
            funcionarioData.put("login", funcionario.getLogin());
            funcionariosMap.put(funcionario.getCpf(), funcionarioData);
        }
        return funcionariosMap;
    }

    public void deletarFuncionario(String cpf) {
        if (funcionarios.containsKey(cpf)) {
            funcionarios.remove(cpf);
            System.out.printf("Funcionário %s deletado com sucesso%n", cpf);
        }
    }
}
