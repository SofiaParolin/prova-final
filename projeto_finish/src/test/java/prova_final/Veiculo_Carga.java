package prova_final;

import java.util.List;

public class Veiculo_Carga extends Veiculo{
    protected int qtCarga;



    public Veiculo_Carga() {
        super();
        setQtCarga(0);

    }

    public Veiculo_Carga(String nomeVeiculo, int anoFabricacao, List<Pessoa> ocupantes,int qtCarga ) {
        super(nomeVeiculo, anoFabricacao, ocupantes);
        this.qtCarga = qtCarga;
    }
    @Override
    public String toString() {
        return super.toString()+
                " -quantidade carga- " + qtCarga +";\n";
    }

    public int getQtCarga() {
        return qtCarga;
    }

    public void setQtCarga(int qtCarga) {
        this.qtCarga = qtCarga;
    }

}
