package persistencia;

import java.util.ArrayList;
import model.Usuario;
import model.Medico;
import model.Paciente;
import model.Plano;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class GerenciadorArquivos {

    public void salvarUsuarios(ArrayList<Usuario> usuarios) {
        try {
            new File("arquivos").mkdirs();
            BufferedWriter bw = new BufferedWriter(new FileWriter("arquivos/usuarios.txt"));
            for (Usuario u : usuarios) {
                bw.write(u.gerarLinhasCsv());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public ArrayList<Usuario> carregarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("arquivos/usuarios.txt"));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                String tipo = campos[0];
                String login = campos[1];
                String senha = campos[2];
                String[] historico = campos[3].split(",");

                Usuario u = null;
                if (tipo.equals("M")) {
                    u = new Medico(login, senha, campos[4], campos[5], campos[6]);
                } else if (tipo.equals("P")) {
                    Plano plano;
                    if (campos[6].equals("Particular")) {
                        plano = null;
                    } else {
                        plano = new Plano(campos[6], Boolean.parseBoolean(campos[7]), Integer.parseInt(campos[8]));
                    }
                    u = new Paciente(login, senha, campos[4], campos[5], plano);
                }

                if (u != null) {
                    ArrayList<String> hist = new ArrayList<>();
                    for (String s : historico)
                        hist.add(s);
                    u.setHistoricoSenhas(hist);
                    lista.add(u);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado, iniciando vazio.");
        }
        return lista;
    }

    public void salvarRelatorio(ArrayList<Usuario> usuarios, String caminho) {
        try {
            new File("relatorios").mkdirs();
            BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
            for (Usuario u : usuarios) {
                bw.write(u.gerarLinhasCsv());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar relatório: " + e.getMessage());
        }
    }
}