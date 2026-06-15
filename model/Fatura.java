package model;

import java.util.ArrayList;

public class Fatura {
  protected Paciente paciente;
  private ArrayList<Atendimento> atendimentos = new ArrayList<>();

  public Fatura(Paciente paciente){
    this.paciente = paciente;
  }

  public double calcularTotalFatura() {
    double totalFatura = 0;
    for (Atendimento at : atendimentos) {
      totalFatura += at.calcularCusto();
    }
    return totalFatura;
  }

  public void adicionarAtendimento(Atendimento at){
    atendimentos.add(at);
  }

  @Override
  public String toString() {
    String texto = "";

    for (Atendimento at : atendimentos) {
      texto += at.getPaciente() + " | " + at.getMedico() + " | Data de Atend.: "
          + at.getDataAtendimento() + " | Valor: R$" + at.calcularCusto() + "\n";
    }

    return texto + "\n" + calcularTotalFatura();
  }
}
