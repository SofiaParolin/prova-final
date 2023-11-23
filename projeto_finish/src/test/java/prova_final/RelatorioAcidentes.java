package prova_final;

import java.util.ArrayList;
import java.util.List;

public class RelatorioAcidentes {

    public static void main(String[] args) {
        //Cadastrado De Rodovia:
        Rodovia br_10 = new Rodovia("BR-10", "Alto");
        Rodovia br_20 = new Rodovia("BR-20", "Baixo");
        Rodovia br_30 = new Rodovia("BR-30", "Medio");

        //Cadastrado De Pesssoa(Motorista):
        Pessoa mateus = new Pessoa("Mateus", 20, "Masculino","Motorista","Sim");
        Pessoa jose = new Pessoa("Jose", 30, "Masculino","Motorista","Nao");
        Pessoa julia = new Pessoa("Julia", 25, "Feminino","Motorista","Nao");
        Pessoa pedro = new Pessoa("Pedro", 28, "Masculino","Motorista","NAo");
        Pessoa martias = new Pessoa("Martias", 49, "Masculino","Motorista","Nao");
        Pessoa fernanda = new Pessoa("Fernanda", 50, "Feminino","Motorista","Sim");
        Pessoa debora = new Pessoa("Debora", 20, "Feminino","Motorista","Nao");

        //Cadastrado De Pesssoa(Motorista), teste de se Motorista e se esta bebado:
        Pessoa maindri = new Pessoa("Maindri", 30, "Feminino","","");
        Pessoa diogo = new Pessoa("diogo", 33, "Masculino","","");

        maindri.verificarMotorista("sim");
        diogo.verificarMotorista( "nao");

        maindri.verificarEmbriagueis("sim");
        diogo.verificarEmbriagueis("nao");

        //Cadastrado De Pesssoa(Passageiro):
        Pessoa joana = new Pessoa("Joana", 22, "Feminino","Passageiro","Nao");

        //Cadastrado de veiculo com os ocupantes:
        Veiculo gol_bola = new Veiculo("Gol Bola", 2011, new ArrayList<>());
        gol_bola.adicionarOcupante("Gol bola",mateus);

        Veiculo moto = new Veiculo("Moto", 2010, new ArrayList<>());
        moto.adicionarOcupante("Moto",jose);

        Veiculo polo = new Veiculo("Polo", 2018, new ArrayList<>());
        polo.adicionarOcupante("Polo",julia);

        Veiculo bicicleta = new Veiculo("Bicicleta", 2017, new ArrayList<>());
        bicicleta.adicionarOcupante("Bicicleta",pedro);

        Veiculo bicicleta1 = new Veiculo("Bicicleta", 2011, new ArrayList<>());
        bicicleta1.adicionarOcupante("Bicicleta",martias);

        Veiculo saveiro = new Veiculo("Saveiro", 2018, new ArrayList<>());
        saveiro.adicionarOcupante("Saveiro",fernanda);

        Veiculo gol_quadrado = new Veiculo("Gol Quadrado", 2009, new ArrayList<>());
        gol_quadrado.adicionarOcupante("Gol Quadrado",maindri);
        gol_quadrado.adicionarOcupante("Gol Quadrado",joana);


        //Cadastrado de veiculo_carga  com os ocupantes:
        Veiculo_Carga caminhao = new Veiculo_Carga("Caminhao", 2018, new ArrayList<>(), 500);
        caminhao.adicionarOcupante("Caminhao",debora);
        caminhao.adicionarOcupante("Caminhao",diogo);



        Acidente acidente1 = new Acidente(br_20, 2, 3, "Fevereiro",new ArrayList<>());
        acidente1.getVeiculosDoAcidente().add(saveiro);
        acidente1.getVeiculosDoAcidente().add(gol_bola);


        Acidente acidente2 = new Acidente(br_10, 4, 2, "Maio", new ArrayList<>());
        acidente2.getVeiculosDoAcidente().add(bicicleta);
        acidente2.getVeiculosDoAcidente().add(caminhao);

        Acidente acidente3 = new Acidente(br_10, 2, 1, "Fevereiro", new ArrayList<>());
        acidente3.getVeiculosDoAcidente().add(bicicleta1);
        acidente3.getVeiculosDoAcidente().add(gol_quadrado);

        Acidente acidente4 = new Acidente(br_30, 6, 2, "Abril", new ArrayList<>());
        acidente4.getVeiculosDoAcidente().add(polo);
        acidente4.getVeiculosDoAcidente().add(moto);


        cadastrarRodovia(br_10);
        cadastrarRodovia(br_20);
        cadastrarRodovia(br_30);

        cadastrarAcidente(acidente1);
        cadastrarAcidente(acidente2);
        cadastrarAcidente(acidente3);
        cadastrarAcidente(acidente4);


        List<Acidente> acidentesEmbriagados = CondutorEmbriagado();
        System.out.println("Acidentes com pessoas embriadas:\n"+ acidentesEmbriagados);

        AcidentesPericulosidade();
        VeiculosCargaEnvolvidos();

        String rodoviaMaisAcidentesBicicletas = rodoviaComMaisAcidentesComBicicletas();
        System.out.println("Rodovia com mais acidentes envolvendo bicicletas: " + rodoviaMaisAcidentesBicicletas + "\n");

        String resultadoRodovia = rodoviaComMaisAcidentesComVitimasFatais();
        System.out.println(resultadoRodovia);

        int acidentesComVeiculosNovos = AcidentesComVeiculosNovos();
        System.out.println("Numero de acidentes com veiculos com ano superior ou igual 2013, foi de (" + acidentesComVeiculosNovos+ ")\n");

        List<String> rodoviasNoCarnaval = rodoviasComAcidentesNoCarnaval();
        System.out.println("Rodovias que registraram acidentes no carnaval (fevereiro): " + rodoviasNoCarnaval+ "\n");
    }
    private static List<Rodovia> rodovias = new ArrayList<>();
    private static List<Acidente> acidentes = new ArrayList<>();

    public static void cadastrarRodovia(Rodovia rodovia) {
        rodovias.add(rodovia);
    }

    public static void cadastrarAcidente(Acidente acidente) {
        acidentes.add(acidente);
    }
    public static List<Acidente> CondutorEmbriagado() {
        List<Acidente> acidentesEmbriagados = new ArrayList<>();
        for (Acidente acidente : acidentes) {
            boolean adicionouAcidente = false;

            for (Veiculo veiculo : acidente.getVeiculosDoAcidente()) {
                for (Pessoa pessoa : veiculo.getOcupantes()) {
                    if (pessoa != null && pessoa.getEmbriagado() != null && pessoa.getEmbriagado().equalsIgnoreCase("Sim")) {
                        if (!adicionouAcidente) {
                            acidentesEmbriagados.add(acidente);
                            adicionouAcidente = true;
                        }
                        break;
                    }
                }
            }
        }
        return acidentesEmbriagados;
    }
    public static void AcidentesPericulosidade() {
        String[] niveisPericulosidade = new String[rodovias.size()];
        int[] contagemPorPericulosidade = new int[rodovias.size()];

        for (int i = 0; i < rodovias.size(); i++) {
            niveisPericulosidade[i] = rodovias.get(i).getGrauPericulosidade();
            contagemPorPericulosidade[i] = 0;
        }

        for (Acidente acidente : acidentes) {
            for (int i = 0; i < rodovias.size(); i++) {
                if (acidente.getRodovia().equals(rodovias.get(i))) {
                    contagemPorPericulosidade[i]++;
                    break;
                }
            }
        }
        System.out.println("Contagem de acidentes por periculosidade:");
        for (int i = 0; i < rodovias.size(); i++) {
            System.out.println(niveisPericulosidade[i] + ": " + contagemPorPericulosidade[i]);
        }
        System.out.println("\n");
    }
    public static void VeiculosCargaEnvolvidos() {
        System.out.println("Veiculos de carga envolvidos em acidentes:");

        for (Acidente acidente : acidentes) {
            for (Veiculo veiculo : acidente.getVeiculosDoAcidente()) {
                if (veiculo instanceof Veiculo_Carga) {
                    Veiculo_Carga veiculoCarga = (Veiculo_Carga) veiculo;
                    System.out.println("Acidente na Rodovia: " + acidente.getRodovia().getSiglas());
                    System.out.println("Veiculo de carga: " + veiculoCarga.getNomeVeiculo() +
                            " - Ano fabricacao: " + veiculoCarga.getAnoFabricacao());
                    System.out.println("Ocupantes: " + veiculoCarga.getOcupantes());
                    System.out.println("Quantidade de carga: " + veiculoCarga.getQtCarga()+"\n");
                }
            }
        }
    }
    public static String rodoviaComMaisAcidentesComBicicletas() {
        int maxAcidentes = 0;
        String rodoviaComMaisAcidentes = "";

        for (Rodovia rodovia : rodovias) {
            int acidentesComBicicletas = 0;

            for (Acidente acidente : acidentes) {
                for (Veiculo veiculo : acidente.getVeiculosDoAcidente()) {
                    if (veiculo.getNomeVeiculo().equalsIgnoreCase("Bicicleta") && acidente.getRodovia().equals(rodovia)) {
                        acidentesComBicicletas++;
                        break;
                    }
                }
            }

            if (acidentesComBicicletas > maxAcidentes) {
                maxAcidentes = acidentesComBicicletas;
                rodoviaComMaisAcidentes = rodovia.getSiglas() + " - " + acidentesComBicicletas + " acidentes";
            }
        }

        return rodoviaComMaisAcidentes;
    }
    public static String rodoviaComMaisAcidentesComVitimasFatais() {
        int maxVitimasFatais = 0;
        String rodoviaComMaisAcidentes = "";

        for (Rodovia rodovia : rodovias) {
            int totalVitimasFatais = 0;

            for (Acidente acidente : acidentes) {
                if (acidente.getRodovia().equals(rodovia)) {
                    totalVitimasFatais += acidente.getVitimasFatais();
                }
            }

            if (totalVitimasFatais > maxVitimasFatais) {
                maxVitimasFatais = totalVitimasFatais;
                rodoviaComMaisAcidentes = rodovia.getSiglas();
            }
        }

        return "Rodovia que mais teve vitima fatais: " + rodoviaComMaisAcidentes + " - Total de vitimas fatais: " + maxVitimasFatais+ "\n";
    }
    public static int AcidentesComVeiculosNovos() {
        int contador = 0;

        for (Acidente acidente : acidentes) {
            for (Veiculo veiculo : acidente.getVeiculosDoAcidente()) {
                if (veiculo.getAnoFabricacao() >= 2013) {
                    contador++;
                    break;
                }
            }
        }

        return contador;
    }
    public static List<String> rodoviasComAcidentesNoCarnaval() {
        List<String> rodoviasNoCarnaval = new ArrayList<>();

        for (Acidente acidente : acidentes) {
            if (acidente.getMes().equalsIgnoreCase("fevereiro")) {
                Rodovia rodoviaAcidente = acidente.getRodovia();
                if (rodoviaAcidente != null && !rodoviasNoCarnaval.contains(rodoviaAcidente.getSiglas())) {
                    rodoviasNoCarnaval.add(rodoviaAcidente.getSiglas());
                }
            }
        }

        return rodoviasNoCarnaval;
    }


}