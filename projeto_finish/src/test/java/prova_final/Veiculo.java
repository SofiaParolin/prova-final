package prova_final;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    protected String nomeVeiculo;
    protected int anoFabricacao;
    protected List<Pessoa> ocupantes;


    public Veiculo() {
        this(null, 0, new ArrayList<>());
    }

    public Veiculo(String nomeVeiculo, int anoFabricacao, List<Pessoa> ocupantes) {
        this.nomeVeiculo = nomeVeiculo;
        this.anoFabricacao = anoFabricacao;
        this.ocupantes =ocupantes;
    }

    public boolean adicionarOcupante(String nomeVeiculoParam, Pessoa ocupante) {
        if ( nomeVeiculoParam.equalsIgnoreCase(nomeVeiculo) && ocupante != null) {
            ocupantes.add(ocupante);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(nomeVeiculo).append("- ano fabricacao (").append(anoFabricacao).append(")\nOcupantes:\n ");

        for (Pessoa ocupante : ocupantes) {
            result.append(ocupante.toString()).append("; ");

        }

        result.append("\n\n");

        return result.toString();
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public List<Pessoa> getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(List<Pessoa> ocupantes) {
        this.ocupantes = ocupantes;
    }
}

