import java.util.ArrayList;
import model.Usuario;
import model.Medico;
import model.Paciente;
import model.Plano;
import controller.Login;
import controller.MenuController;
import persistencia.GerenciadorArquivos;

public class Main {
    public static void main(String[] args) {
        //Persistência
        GerenciadorArquivos ga = new GerenciadorArquivos();

        // Carrega os usuários salvos. Se o arquivo não existir, vem uma lista vazia.
        ArrayList<Usuario> usuarios = ga.carregarUsuarios();

        // primeira execução (sem arquivo): popula dados de DEMONSTRAÇÃO.
        // Mostra os 3 cenários de plano pra demonstrar o polimorfismo do desconto:
        //   Unimed 50% (com obstetrícia) · Hospitalar 25% · Particular (sem plano = sem desconto)
        if (usuarios.isEmpty()) {
            Plano unimed = new Plano("Unimed", true, 50);
            Plano hospitalar = new Plano("Hospitalar", false, 25);

            usuarios.add(new Medico("ana", "1234", "Dra. Ana Souza", "CRM-PR 12345", "Cardiologia"));
            usuarios.add(new Medico("carlos", "1234", "Dr. Carlos Lima", "CRM-PR 67890", "Ortopedia"));
            usuarios.add(new Paciente("joao", "1234", "João Silva", "111.222.333-44", unimed));
            usuarios.add(new Paciente("maria", "1234", "Maria Souza", "555.666.777-88", hospitalar));
            usuarios.add(new Paciente("jose", "1234", "José Pereira", "999.000.111-22", null));
        }

        // Mostra os logins disponíveis - Senha padrão: 1234
        System.out.println("=== Logins disponíveis (senha: 1234) ===");
        for (Usuario u : usuarios) {
            System.out.println(" - " + u.getLogin());
        }
        System.out.println("========================================");

        // Tela de login (controller coordena as 3 tentativas + troca de senha)
        Login login = new Login(usuarios);
        Usuario usuarioLogado = login.autenticar();

        if (usuarioLogado != null) {
            System.out.println("Bem vindo, " + usuarioLogado.getLogin());
            // Menu principal
            MenuController menu = new MenuController(usuarios, ga);
            menu.abrirMenu();
        } else {
            System.out.println("Usuário não encontrado!");
        }

        //salva tudo de volta no arquivo (persistência)
        ga.salvarUsuarios(usuarios);
        System.out.println("Dados salvos!");
    }
}
