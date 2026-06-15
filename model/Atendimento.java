package model;

public abstract class Atendimento{
  protected Paciente paciente;
  protected Medico medico;
  protected String dataAtendimento;
  protected double valor;

  public Atendimento(Paciente paciente, Medico medico, String dataAtendimento, double valor){
    this.paciente = paciente;
    this.medico = medico;
    this.dataAtendimento = dataAtendimento;
    this.valor = valor;
  }

  public Paciente getPaciente(){
    return paciente;
  }
  
  public Medico getMedico(){
    return medico;
  }
  
  public String getDataAtendimento(){
    return dataAtendimento;
  }
  
  public double getValor(){
    return valor;
  }

  @Override
  public String toString(){
    return "Atendimento de " + paciente.getNomePaciente() + " com médico Dr(a) " + medico.getNomeMedico() + " em " + getDataAtendimento() + " - Valor: R$" + getValor();
  }

  public abstract double calcularCusto();

  protected double aplicarDesconto(double bruto){
    if (getPaciente().getPlano() == null) { //particular
      return bruto;
    } else {
      return bruto - (bruto * getPaciente().getPlano().getPercentualCobertura() / 100);
    }
  }

}