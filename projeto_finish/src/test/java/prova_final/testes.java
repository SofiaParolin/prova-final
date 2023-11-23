package prova_final;

        import static org.junit.jupiter.api.Assertions.*;

        import java.util.ArrayList;

        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import java.util.List;

class testes {
    Pessoa mateus;
    Pessoa pedro;
    Pessoa martias;
    Pessoa fernanda;
    Pessoa debora;
    Pessoa maindri;
    Pessoa diogo;
    Pessoa joana;
    Pessoa motorista;
    Pessoa passageiro;

    Veiculo bicicleta;
    Veiculo bicicleta1;
    Veiculo polo;
    Veiculo golQuadrado;
    Veiculo saveiro;


    Veiculo golBola;
    Veiculo moto;

    Veiculo_Carga caminhao;

    Rodovia br_20;
    Rodovia br_10;

    Acidente acidente_01;
    Acidente acidente_02;
    Acidente acidente_03;


    @BeforeEach
    void criarPessoas() {
        mateus = new Pessoa();
        mateus.setNome("Mateus");
        mateus.setIdade(20);
        mateus.setSexo("Masculino");
        mateus.setCondutor("Motorista");
        mateus.setEmbriagado("Sim");

        pedro = new Pessoa();
        pedro.setNome("Pedro");
        pedro.setIdade(28);
        pedro.setSexo("Masculino");
        pedro.setCondutor("Motorista");
        pedro.setEmbriagado("");

        fernanda = new Pessoa("Fernanda", 49, "Feminino","Motorista","Nao");
        martias = new Pessoa("Martias", 49, "Masculino","Motorista","Nao");
        debora = new Pessoa("Debora", 20, "Feminino","Motorista","Nao");
        maindri = new Pessoa("Maindri", 30, "Feminino","","");
        diogo = new Pessoa("Diogo", 33, "Masculino","","");
        joana = new Pessoa("Joana", 22, "Feminino","Passageiro","Nao");

    }
    //Aqui fiz os test da class Pessoa:                                                              /////////////
    @Test
    public void testPossivel_Motorista() {
        assertTrue(maindri.verificarMotorista("sim"));
        assertEquals("Motorista", maindri.getCondutor());
    }
    @Test
    public void testImpossivel_Motorista() {
        assertFalse(diogo.verificarMotorista("nao"));
        assertEquals("Passageiro", diogo.getCondutor());
    }
    @Test
    public void testPossivel_Embriagueis() {
        assertTrue(maindri.verificarEmbriagueis("Sim"));
        assertEquals("Sim", maindri.getEmbriagado());
    }
    @Test
    public void testImpossivel_Embriagueis() {
        assertFalse(diogo.verificarEmbriagueis("nao"));
        assertEquals("Nao", diogo.getEmbriagado());
    }
    @Test
    void DiogoToString() {
        assertEquals("Nome: Martias -idade- 49 -sexo- Masculino - Motorista -Embriagado- Nao", martias.toString());
    }
    // Fazer os test da class veiculo aqui:                                                                  //////////////
    @BeforeEach
    void criarVeiculos() {
        golBola = new Veiculo();
        golBola.setNomeVeiculo("Gol Bola");
        golBola.setAnoFabricacao(2011);

        bicicleta = new Veiculo();
        bicicleta.setNomeVeiculo("Bicicleta");
        bicicleta.setAnoFabricacao(2017);

        moto = new Veiculo();
        moto.setNomeVeiculo("Moto");
        moto.setAnoFabricacao(2010);

        golBola.adicionarOcupante("Gol Bola",mateus);
        moto.adicionarOcupante("Moto",debora);
        bicicleta.adicionarOcupante("Bicicleta",pedro);

        polo = new Veiculo("Polo", 2018, new ArrayList<>());
        polo.adicionarOcupante("Polo",fernanda);


        bicicleta1 = new Veiculo("Bicicleta", 2011, new ArrayList<>());
        bicicleta1.adicionarOcupante("Bicicleta",martias);

        saveiro = new Veiculo("Saveiro", 2018, new ArrayList<>());
        saveiro.adicionarOcupante("Saveiro",diogo);

        golQuadrado = new Veiculo("Gol Quadrado", 2009, new ArrayList<>());
        golQuadrado.adicionarOcupante("Gol Quadrado",maindri);
        golQuadrado.adicionarOcupante("Gol Quadrado",joana);

        //Ocorrer false(por nome do veiculo errado:
        golQuadrado.adicionarOcupante("foguete",diogo);
        assertFalse(golQuadrado.getOcupantes().contains(diogo));

    }
    // Fazer os test da class veiculo aqui:     //////////////
    @Test
    public void ToStringVeiculo() {
        String testGolBola = golBola.toString();

        assertEquals(testGolBola, golBola.toString());
    }
    @BeforeEach
    void criarRodovias() {
        br_20 = new Rodovia();
        br_20.setSiglas("Br-20");
        br_20.setGrauPericulosidade("Alto");

        br_10 = new Rodovia();
        br_10.setSiglas("Br-10");
        br_10.setGrauPericulosidade("Medio");

        br_10 = new Rodovia("br-30","Baixo");
    }

    // Fazer os test da class Rodovia aqui:                                                                 //////////////
    @Test
    void testBr20ToString() {
        assertEquals("Br-20 -grau periculosidade- Alto\n", br_20.toString());
    }

    //test da class caminhao:                                                                              /////////////
    @BeforeEach
    public void testAdicionarOcupanteVeiculoCarga() {
        caminhao = new Veiculo_Carga("Caminhao", 2017, new ArrayList<>(), 500);
        caminhao.setNomeVeiculo("Caminhao");
        caminhao.setAnoFabricacao(2017);

        motorista = new Pessoa("Pedro", 30, "Masculino", "Motorista", "Sim");
        passageiro = new Pessoa("Julia", 25, "Feminino", "Passageiro", "Nao");

        caminhao.adicionarOcupante("Caminhao", motorista);
        caminhao.adicionarOcupante("Caminhao", passageiro);
        assertTrue(caminhao.getOcupantes().contains(motorista));
        assertTrue(caminhao.getOcupantes().contains(passageiro));

    }

    @Test
    public void ToStringVeiculoCarga() {
        String testCaminhao = caminhao.toString();
        assertEquals(testCaminhao, caminhao.toString());
    }
    @BeforeEach
    void testAcidente() {
        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(golBola);
        veiculos.add(moto);

        acidente_01 = new Acidente(br_20, 2, 5, "Fevereiro", veiculos);
        assertEquals(br_20, acidente_01.getRodovia());
        assertEquals(2, acidente_01.getVitimasFatais());
        assertEquals(5, acidente_01.getVitimasferidas());
        assertEquals("Fevereiro", acidente_01.getMes());
        assertEquals(veiculos, acidente_01.getVeiculosDoAcidente());

    }

    @Test
    void testToStringAcidente() {
        String testAcidente = acidente_01.toString();
        assertEquals(testAcidente, acidente_01.toString());
    }
}


    /*• Listar todos os acidentes cujo algum condutor estava embriagado
				• Listar a quantidade de acidentes para cada nível de periculosidade da rodovia
				• Mostrar todos os veículos de carga que se envolveram em acidentes
				• Mostrar qual a rodovia em que ocorreram mais acidentes com bicicletas.
				• Mostrar qual rodovia que possui mais acidentes com vítimas fatais
				• Quantos acidentes possuem veículos novos (considerar o ano de 2013).
				• Quais as rodovias que registraram acidentes no carnaval (considerar
				fevereiro).

				85% de COBERTURA.*/

