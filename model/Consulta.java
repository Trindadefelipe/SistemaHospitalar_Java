package model;

public class Consulta extends Atendimento{
  private String especialidadeConsulta;

    public Consulta(Paciente paciente, Medico medico, String dataAtendimento, double valor, String especialidadeConsulta){
      super(paciente, medico, dataAtendimento, valor);
      this.especialidadeConsulta = especialidadeConsulta;
    }

    public String getEspecialidadeConsulta(){
      return especialidadeConsulta;
    }

    public void setEspecialidadeConsulta(String especialidadeConsulta){
      this.especialidadeConsulta = especialidadeConsulta;
    }

    @Override
    public double calcularCusto(){
      return aplicarDesconto(getValor());
    }

    @Override
    public String toString(){
      return super.toString() + " - Especialidade: " + getEspecialidadeConsulta();
    }


}
