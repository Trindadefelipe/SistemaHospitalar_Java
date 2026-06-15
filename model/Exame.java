package model;

public class Exame extends Atendimento{
  private String tipoExame;

  public Exame(Paciente paciente, Medico medico, String dataAtendimento, double valor, String tipoExame){
    super(paciente, medico, dataAtendimento, valor);
    this.tipoExame = tipoExame;
  }

  public String getTipoExame(){
    return tipoExame;
  }

  public void setTipoExame(String tipoExame){
    this.tipoExame = tipoExame;
  }

  @Override
  public double calcularCusto(){
    return aplicarDesconto(getValor() * 1.2);
  }

  @Override
  public String toString(){
    return super.toString() + " - Tipo Exame: " + getTipoExame();
  }
}
