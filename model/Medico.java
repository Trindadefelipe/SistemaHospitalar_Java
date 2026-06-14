package model;

public class Medico extends Usuario implements Exportavel{
    private String nomeMedico;
    private String crm;
    private String especialidade;

    public Medico(String login, String senha, String nomeMedico, String crm, String especialidade) {
        super(login, senha);
        this.nomeMedico = nomeMedico;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public void setNomeMedico(String nomeMedico){
        this.nomeMedico = nomeMedico;
    }

    public void setCrm(String crm){
        this.crm = crm;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    @Override
    public String toString(){
        return "Médico: " + getNomeMedico() + " - CRM: " + getCrm() + " - Especialidade: " + getEspecialidade();
    }

    @Override
    public String gerarLinhasCsv(){
        return "M" + ";" + getLogin() + ";" + getSenha() + ";" + String.join(",", historicoSenhas) + ";" + getNomeMedico() + ";" + getCrm() + ";" + getEspecialidade();
    }
}
