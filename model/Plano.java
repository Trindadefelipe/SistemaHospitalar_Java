package model;

public class Plano {
    private String nomePlano;
    private boolean temObstetricia;
    private int percentualCobertura;

    public Plano(String nomePlano, boolean temObstetricia, int percentualCobertura){
        this.nomePlano = nomePlano;
        this.temObstetricia = temObstetricia;
        this.percentualCobertura = percentualCobertura;
    }

    public String getNomePlano(){
        return nomePlano;
    }
    public boolean getTemObstetricia(){
        return temObstetricia;
    }
    public int getPercentualCobertura(){
        return percentualCobertura;
    }

    public void setNomePlano(String nomePlano){
        this.nomePlano = nomePlano;
    }
    public void setTemObstetricia(boolean temObstetricia){
        this.temObstetricia = temObstetricia;
    }
    public void setPercentualCobertura(int percentualCobertura){
        this.percentualCobertura = percentualCobertura;
    }

    @Override
    public String toString(){
        String obstetricia = temObstetricia ? "Sim" : "Não";
        return "Plano: " + getNomePlano() + " - Com Obstetricia? " + obstetricia + " - Percentual de Cobertura - " + getPercentualCobertura() + "%";
    }
}
