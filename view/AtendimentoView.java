package view;

import java.util.Scanner;
import java.util.ArrayList;
import model.Paciente;
import model.Medico;

public class AtendimentoView {
    private Scanner entrada = Entrada.entrada;

    public void mostrarPacientes(ArrayList<Paciente> pacientes) {
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + " - " + pacientes.get(i));
        }
    }

    public void mostrarMedicos(ArrayList<Medico> medicos) {
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + " - " + medicos.get(i));
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
        return Integer.parseInt(entrada.nextLine());
        
    }

    public int escolherMedico(){
        System.out.print("Digite o n° do médico desejado: ");
        return Integer.parseInt(entrada.nextLine());
    }

    public int pedirTipoAtendimento(){
        System.out.println("Tipos de atendimento disponíveis:");
        System.out.println("1 - Consulta");
        System.out.println("2 - Exame");
        System.out.println("3 - Cirurgia");
        System.out.print("Digite o n° do atendimento desejado: ");
        return Integer.parseInt(entrada.nextLine());
    }

    public String pedirDataAtendimento(){
        System.out.print("Digite a data de atendimento no formarto DD/MM/YYYY: ");
        return entrada.nextLine();
    }

    public double pedirValorBase(){
        System.out.print("Digite o valor base: ");
        return Double.parseDouble(entrada.nextLine());
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
