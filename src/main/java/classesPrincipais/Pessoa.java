package classesPrincipais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Pessoa e a suas subclasses
abstract class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private String cpf;

    public Pessoa(int id, String nome, String telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Pessoa() {
        // Inicialização básica
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}