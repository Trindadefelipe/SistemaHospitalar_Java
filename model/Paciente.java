package model;

public class Paciente extends Usuario implements Exportavel {
    private String nomePaciente;
    private String cpf;
    private Plano plano;

    public Paciente(String login, String senha, String nomePaciente, String cpf, Plano plano) {
        super(login, senha);
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.plano = plano;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        if (getPlano() == null) {
            String particular = "Particular";

            return "Paciente: " + getNomePaciente() + " - CPF: " + getCpf() + " - " + particular;
        }

        return "Paciente: " + getNomePaciente() + " - CPF: " + getCpf() + " - " + getPlano();
    }

    @Override
    public String gerarLinhasCsv() {
        if (getPlano() == null) {
            String particular = "Particular";

            return "P" + ";" + getLogin() + ";" + getSenha() + ";" + String.join(",", historicoSenhas) + ";"
                    + getNomePaciente() + ";" + getCpf() + ";" + particular;
        } else {
            return "P" + ";" + getLogin() + ";" + getSenha() + ";" + String.join(",", historicoSenhas) + ";"
                    + getNomePaciente() + ";" + getCpf() + ";" + plano.getNomePlano();
        }
    }
}
