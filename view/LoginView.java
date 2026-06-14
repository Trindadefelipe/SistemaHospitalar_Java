package view;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner = new Scanner(System.in);

    public String pedirLogin() {
        System.out.println("Digite seu Login: ");
        return scanner.nextLine();
    }

    public String pedirSenha() {
        System.out.println("Digite sua Senha: ");
        return scanner.nextLine();
    }

    public void mostrarSenhaErrada() {
        System.err.println("Senha errada!");
    }

    public void mostrarTentativasEsgotadas() {
        System.out.println("Tentativas esgotadas");
    }

    public String pedirNovaSenha() {
        System.out.println("Digite uma nova senha");
        return scanner.nextLine();
    }

    public void mostrarSenhaJaUsada() {
        System.out.println("Senha já usada!");
    }
}