package controller;

import java.util.ArrayList;
import model.Usuario;
import model.Paciente;
import model.Medico;
import model.Plano;
import view.MenuView;
import persistencia.GerenciadorArquivos;

public class MenuController {
    private MenuView view;
    private ArrayList<Usuario> usuarios;
    private GerenciadorArquivos ga;

    public MenuController(ArrayList<Usuario> usuarios, GerenciadorArquivos ga) {
        this.view = new MenuView();
        this.usuarios = usuarios;
        this.ga = ga;
    }

    public void abrirMenu() {
        String opcao = "";
        while (!opcao.equals("0")) {
            opcao = view.mostrarMenu();
            switch (opcao) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    consultar();
                    break;
                case "3":
                    alterar();
                    break;
                case "4":
                    excluir();
                    break;
                case "5":
                    view.mostrarMensagem("Atendimentos - em breve!");
                    break;
                case "6":
                    gerarRelatorio();
                    break;
                case "0":
                    view.mostrarMensagem("Saindo...");
                    break;
                default:
                    view.mostrarMensagem("Opção inválida!");
                    break;
            }
        }
    }

    private void cadastrar() {

        String tipo = view.cadastrarUsuario();
        if (tipo.equals("1")) {
            String login = view.pedirDado("Login: ");
            String senha = view.pedirDado("Senha: ");
            String nome = view.pedirDado("Nome: ");
            String cpf = view.pedirDado("CPF: ");
            String nomePlano = view.pedirDado("Plano (Particular/Ouro/Prata): ");
            Plano plano = null;
            if (!nomePlano.equals("Particular")) {
                String obs = view.pedirDado("Tem obstetrícia? (true/false): ");
                String cob = view.pedirDado("Percentual de cobertura: ");
                plano = new Plano(nomePlano, Boolean.parseBoolean(obs), Integer.parseInt(cob));
            }
            usuarios.add(new Paciente(login, senha, nome, cpf, plano));
            view.mostrarMensagem("Paciente cadastrado!");
        } else if (tipo.equals("2")) {
            String login = view.pedirDado("Login: ");
            String senha = view.pedirDado("Senha: ");
            String nome = view.pedirDado("Nome: ");
            String crm = view.pedirDado("CRM: ");
            String especialidade = view.pedirDado("Especialidade: ");
            usuarios.add(new Medico(login, senha, nome, crm, especialidade));
            view.mostrarMensagem("Médico cadastrado!");
        } else {
            view.mostrarMensagem("Opção inválida!");
        }
    }

    private void consultar() {
        if (usuarios.isEmpty()) {
            view.mostrarMensagem("Nenhum usuário cadastrado!");
            return;
        }
        for (Usuario u : usuarios) {
            view.mostrarMensagem(u.toString());
        }
    }

    private void alterar() {
        String login = view.pedirDado("Login do usuário a alterar: ");
        Usuario encontrado = null;
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                encontrado = u;
            }
        }
        if (encontrado != null) {
            String novoLogin = view.pedirDado("Novo login: ");
            String novaSenha = view.pedirDado("Nova senha: ");
            encontrado.setLogin(novoLogin);
            encontrado.trocarSenha(novaSenha);
            view.mostrarMensagem("Usuário alterado!");
        } else {
            view.mostrarMensagem("Usuário não encontrado!");
        }
    }

    private void excluir() {
        String login = view.pedirDado("Login do usuário a excluir: ");
        Usuario encontrado = null;
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login)) {
                encontrado = u;
            }
        }
        if (encontrado != null) {
            usuarios.remove(encontrado);
            view.mostrarMensagem("Usuário removido!");
        } else {
            view.mostrarMensagem("Usuário não encontrado!");
        }
    }

    private void gerarRelatorio() {
        ga.salvarRelatorio(usuarios, "relatorios/usuarios.csv");
        view.mostrarMensagem("Relatório gerado em relatorios/usuarios.csv!");
    }
}
