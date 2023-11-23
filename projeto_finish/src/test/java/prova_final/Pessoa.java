package prova_final;

public class Pessoa {
    protected String nome;
    protected int idade;
    protected String sexo;
    protected String condutor;
    protected String embriagado;

    public Pessoa() {
        this(null,0,null, null, null);
    }
    public Pessoa(String nome, int idade, String sexo, String condutor, String embriagado) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.condutor = condutor;
        this.embriagado = embriagado;
    }
    public boolean verificarMotorista(String motorista) {
        if (motorista.equalsIgnoreCase("sim")) {
            condutor = "Motorista";
            return true;
        } else {
            condutor = "Passageiro";
            return false;
        }
    }

    public boolean verificarEmbriagueis(String embriaguies) {
        if (embriaguies.equalsIgnoreCase("sim")) {
            embriagado = "Sim";
            return true;
        } else {
            embriagado = "Nao";
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " -idade- " + idade + " -sexo- " + sexo + " - " + condutor + " -Embriagado- " + embriagado;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getCondutor() {
        return condutor;
    }
    public void setCondutor(String condutor) {
        this.condutor = condutor;
    }
    public String getEmbriagado() {
        return embriagado;
    }
    public void setEmbriagado(String embriagado) {
        this.embriagado = embriagado;
    }

}
