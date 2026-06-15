package model;

import java.util.ArrayList;

public abstract class Usuario {
  protected String login;
  protected String senha;
  protected ArrayList<String> historicoSenhas;

  public Usuario(String login, String senha) {
    this.login = login;
    this.senha = senha;
    this.historicoSenhas = new ArrayList<>();
    this.historicoSenhas.add(senha);
  }

  public boolean verificarSenha(String tentativa) {
    return this.senha.equals(tentativa);
  }

  public boolean podeUsarSenha(String NovaSenha) {
    int inicio = Math.max(0, historicoSenhas.size() - 3);
    for (int i = inicio; i < historicoSenhas.size(); i++) {
      if (historicoSenhas.get(i).equals(NovaSenha)) {
        return false;
      }
    }
    return true;
  }

  public void trocarSenha(String novaSenha) {
    historicoSenhas.add(novaSenha);
    this.senha = novaSenha;
  }

  public String getLogin() {
    return login;
  }

  public String getSenha() {
    return senha;
  }

  public ArrayList<String> getHistoricoSenhas() {
    return historicoSenhas;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public void setHistoricoSenhas(ArrayList<String> historico) {
    this.historicoSenhas = historico;
  }

  @Override
  public String toString() {
    return "Usuario - login: " + getLogin() + " | senha: " + getSenha();
  }

  public abstract String gerarLinhasCsv();

}
