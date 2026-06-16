package view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner = new Scanner(System.in);

    public String mostrarMenu() {
        System.out.println("==========================");
        System.out.println("       MENU PRINCIPAL     ");
        System.out.println("==========================");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Consultar");
        System.out.println("3 - Alterar");
        System.out.println("4 - Excluir");
        System.out.println("5 - Atendimentos");
        System.out.println("6 - Relatório");
        System.out.println("0 - Sair");
        System.out.println("==========================");
        System.out.print("Escolha uma opção: ");
        return scanner.nextLine();
    }

    public String cadastrarUsuario() {
        System.out.println("=== CADASTRAR ===");
        System.out.println("1 - Paciente");
        System.out.println("2 - Médico");
        System.out.print("Escolha: ");
        return scanner.nextLine();
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }

    public String pedirDado(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
        
    }
}
