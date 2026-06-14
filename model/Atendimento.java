package model;

abstract class Atendimento{
  protected String paciente;
  protected String medico;
  protected String data;
  protected double valor;

  public Atendimento(String paciente, String medico, String data, double valor){
    this.paciente = paciente;
    this.medico = medico;
    this.data = data;
    this.valor = valor;
  }

}
