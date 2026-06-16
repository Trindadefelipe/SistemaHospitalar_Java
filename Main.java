import java.util.ArrayList;
import model.Usuario;
import model.Medico;
import controller.Login;
import controller.MenuController;
import persistencia.GerenciadorArquivos;

public class Main {
    public static void main(String[] args) {
        GerenciadorArquivos ga = new GerenciadorArquivos();
        
        ArrayList<Usuario> usuarios = ga.carregarUsuarios();
        
        if (usuarios.isEmpty()) {
            usuarios.add(new Medico("ana", "abcd", "Dra. Ana Souza", "CRM-PR 12345", "Cardiologia"));
        }
        
        Login login = new Login(usuarios);
        Usuario usuarioLogado = login.autenticar();
        
        if (usuarioLogado != null) {
            System.out.println("Bem vindo, " + usuarioLogado.getLogin());
            MenuController menu = new MenuController(usuarios, ga);
            menu.abrirMenu();
        } else {
            System.out.println("Usuário não encontrado!");
        }
        
        ga.salvarUsuarios(usuarios);
        System.out.println("Dados salvos!");
    }
}