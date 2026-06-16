package view;

import java.util.Scanner;
import java.util.ArrayList;
import model.Paciente;
import model.Medico;

public class AtendimentoView {
    private Scanner entrada = new Scanner(System.in);

    public void mostrarPacientes(ArrayList<Paciente> pacientes) {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void mostrarMedicos(ArrayList<Medico> medicos) {
        for (Medico medico : medicos) {
            System.out.println(medico);
        }
    }

    public void mostrarTotal(double total) {
        System.out.println(total);
    }

    public void mostrarFatura(String texto) {
        System.out.println(texto);
    }

    public int escolherPaciente(){
        System.out.print("Digite o n° do paciente desejado: ");
        return entrada.nextInt();
    }

    public int escolherMedico(){
        System.out.print("Digite o n° do médico desejado: ");
        return entrada.nextInt();
    }

    public int pedirTipoAtendimento(){
        System.out.print("Digite o n° do atendimento desejado: ");
        return entrada.nextInt();
    }

    public String pedirDataAtendimento(){
        System.out.print("Digite a data de atendimento no formarto DD/MM/YYYY: ");
        return entrada.nextLine();
    }

    public double pedirValorBase(){
        System.out.print("Digite o valor base: ");
        return entrada.nextDouble();
    }

    public String pedirTipoEspecificoExame(){
        System.out.print("Digite o exame ('Raio-x', 'apendicectomia'...): ");
        return entrada.nextLine();
    }

    public String pedirTipoEspecificoCirurgia(){
        System.out.print("Digite a cirurgia ('Remoção de pedra no rim', 'Cesária'...): ");
        return entrada.nextLine();
    }

    public String pedirTipoEspecialidade(){
        System.out.print("Digite a especialidade da consulta: ");
        return entrada.nextLine();
    }

}
