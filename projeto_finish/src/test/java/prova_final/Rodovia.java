package prova_final;

public class Rodovia {
    protected String siglas;
    protected String grauPericulosidade;

    public Rodovia() {
        this(null,null);
    }
    public Rodovia(String siglas, String grauPericulosidade) {
        super();
        this.siglas = siglas;
        this.grauPericulosidade = grauPericulosidade;
    }
    @Override
    public String toString() {
        return siglas + " -grau periculosidade- " + grauPericulosidade + "\n";
    }
    public String getSiglas() {
        return siglas;
    }
    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }
    public String getGrauPericulosidade() {
        return grauPericulosidade;
    }
    public void setGrauPericulosidade(String grauPericulosidade) {
        this.grauPericulosidade = grauPericulosidade;
    }

}
