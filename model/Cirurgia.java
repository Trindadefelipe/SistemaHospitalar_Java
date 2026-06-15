package model;

public class Cirurgia extends Atendimento{
  private String tipoCirurgia;

  public Cirurgia(Paciente paciente, Medico medico, String dataAtendimento, double valor, String tipoCirurgia){
    super(paciente, medico, dataAtendimento, valor);
    this.tipoCirurgia = tipoCirurgia;
  }

  public String getTipoCirurgia(){
    return tipoCirurgia;
  }

  public void setTipoCirurgia(String tipoCirurgia){
    this.tipoCirurgia = tipoCirurgia;
  }

  @Override
  public double calcularCusto(){
    return aplicarDesconto(getValor() + 1500);
  }

  @Override
  public String toString(){
    return super.toString() + " - Tipo Cirurgia: " + getTipoCirurgia();
  }
}
