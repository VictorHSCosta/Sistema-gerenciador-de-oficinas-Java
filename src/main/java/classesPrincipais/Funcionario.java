package classesPrincipais;

public class Funcionario extends Pessoa {
    private String login;
    private String senha;

    public Funcionario(int id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }

    public boolean autenticar(String login, String senha) {
        return false; // Lógica de autenticação
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}