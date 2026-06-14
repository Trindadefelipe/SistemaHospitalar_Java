package model;

public class Paciente extends Usuario{
    private String nomePaciente;
    private String cpf;
    private Plano plano;
    

    public Paciente(String login, String senha, String nomePaciente, String cpf, Plano plano){
        super(login, senha);
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.plano = plano;
    }

    public String getNomePaciente(){
        return nomePaciente;
    }

    public String getCpf(){
        return cpf;
    }

    public Plano getPlano(){
        return plano;
    }

    public void setNomePaciente(String nomePaciente){
        this.nomePaciente = nomePaciente;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setPlano(Plano plano){
        this.plano = plano;
    }

    @Override
    public String toString(){
        return "Paciente: " + getNomePaciente() + " - CPF: " + getCpf() + " - Plano: " + getPlano();
    }


}
