package controller;

import java.util.ArrayList;

import model.Usuario;
import view.LoginView;

public class Login {
    private LoginView view;
    private ArrayList<Usuario> usuarios;

    public Login(ArrayList<Usuario> usuarios) {
        this.view = new LoginView();
        this.usuarios = usuarios;
    }

    public Usuario autenticar() {

        String loginDigitado = view.pedirLogin();

        Usuario usuarioEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(loginDigitado)) {
                usuarioEncontrado = u;
            }
        }

        if (usuarioEncontrado == null) {
            return null;
        }

        int tentativas = 0;
        while (tentativas < 3) {
            String senhaDigitada = view.pedirSenha();
            if (usuarioEncontrado.verificarSenha(senhaDigitada)) {
                return usuarioEncontrado;
            }
            tentativas++;
            if (tentativas < 3) {
                view.mostrarSenhaErrada();
            }
        }

        view.mostrarTentativasEsgotadas();
        String novaSenha;
        do {
            novaSenha = view.pedirNovaSenha();
            if (!usuarioEncontrado.podeUsarSenha(novaSenha)) {
                view.mostrarSenhaJaUsada();
            }
        } while (!usuarioEncontrado.podeUsarSenha(novaSenha));

        usuarioEncontrado.trocarSenha(novaSenha);
        return usuarioEncontrado;
    }
}