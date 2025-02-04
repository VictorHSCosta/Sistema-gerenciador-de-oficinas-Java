package classesPrincipais;

class Funcionario extends Pessoa {
    private String login;
    private String senha;

    public Funcionario(int id, String nome, String cpf, String telefone, String login, String senha) {
        super(id, nome, cpf, telefone);
        this.login = login;
        this.senha = senha;
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