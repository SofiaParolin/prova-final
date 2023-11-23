package prova_final;

import java.util.List;

public class Acidente {
    protected Rodovia rodovia;
    protected int vitimasFatais;
    protected int vitimasferidas;
    protected String mes;
    protected List<Veiculo> veiculosDoAcidente;



    public Acidente() {
        this(null, 0, 0, null, null);
    }
    public Acidente(Rodovia rodovia, int vitimasFatais, int vitimasferidas, String mes,
                    List<Veiculo> veiculosDoAcidente) {
        super();
        this.rodovia = rodovia;
        this.vitimasFatais = vitimasFatais;
        this.vitimasferidas = vitimasferidas;
        this.mes = mes;
        this.veiculosDoAcidente = veiculosDoAcidente;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Acidente na Rodovia: ").append(rodovia.getSiglas()).append(" -grau periculosidade- ").append(rodovia.getGrauPericulosidade())
                .append("\n-vitimas Fatais( ").append(vitimasFatais).append(" ) -vitimas feridos (").append(vitimasferidas).append(") -mes (").append(mes).append(")\n");

        result.append("Veiculos do acidente:\n");

        for (Veiculo veiculo : veiculosDoAcidente) {
            result.append(veiculo.toString());
        }

        result.append("\n");

        return result.toString();
    }

    public Rodovia getRodovia() {
        return rodovia;
    }
    public void setRodovia(Rodovia rodovia) {
        this.rodovia = rodovia;
    }
    public int getVitimasFatais() {
        return vitimasFatais;
    }
    public void setVitimasFatais(int vitimasFatais) {
        this.vitimasFatais = vitimasFatais;
    }
    public int getVitimasferidas() {
        return vitimasferidas;
    }
    public void setVitimasferidas(int vitimasferidas) {
        this.vitimasferidas = vitimasferidas;
    }
    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }
    public List<Veiculo> getVeiculosDoAcidente() {
        return veiculosDoAcidente;
    }
    public void setVeiculosDoAcidente(List<Veiculo> veiculosDoAcidente) {
        this.veiculosDoAcidente = veiculosDoAcidente;
    }
}
