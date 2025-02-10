package classesPrincipais;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Servico extends ServicoBase {
    private Cliente cliente;
    private Veiculo veiculo;
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<ServicoOferecido> servicosOferecidos = new ArrayList<>();

    public Servico(int id, TipoServico tipo, String descricao, LocalDate dataInicio, Cliente cliente, Veiculo veiculo) {
        super(id, tipo, descricao, dataInicio);
        
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<ServicoOferecido> getServicosOferecidos() {
        return servicosOferecidos;
    }

    public void setServicosOferecidos(List<ServicoOferecido> servicosOferecidos) {
        this.servicosOferecidos = servicosOferecidos;
    }
    
    public void associarFuncionario(Funcionario funcionario) {}
    public List<Funcionario> listarFuncionarios() { return null; }
    public void concluirServico(LocalDate dataFim) {}
}