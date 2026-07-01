package com.haveneryck.sistemafraudebancaria;

// ETAPA 1: IMPORTAÇÂO DE BIBLIOTECAS

import weka.classifiers.Classifier; // Interface que define metodos obrigatorios para algoritimos de classificação
import weka.classifiers.trees.J48; // Algoritimo de decisão que aprende a responder: "é fraude? sim ou não?"

import weka.core.Attribute; // Representa uma coluna dos dados (Ex: "valor", "origem")
import weka.core.Instance; // Representa uma linha de dados (como uma linha do excel)
import weka.core.DenseInstance; // Representa uma linha completa de dados (Com valores reais)
import weka.core.Instances; // Representa o conjunto de dados (Como uma planilha), é o Dataset

// Ferramentas de log usadas para ocultar avisos do weka (Não afettam o funcionamento do código)
import java.util.logging.Level; // Controla o nível de importancia dos avidos exibidos
import java.util.logging.Logger; // Usado para configurar o sistema do logs do Java
import java.util.ArrayList;

public class DeteccaoDeFraudeBancaria {
    private Classifier classificador; // Modelo de Classificação utilizado
    private Instances dadosTreinamento; // Conjunto de dados usado para treinar o modelo

    // Atributos do nosso conjunto de dados
    private Attribute atributoValor;
    private Attribute atributoOrigem;
    private Attribute atributoFraude;

    // ETAPA 2: DEFINIÇÃO DOS ATRIBUTOS (colunas da "planilha")
    public void definirAtributos() {
        atributoValor = new Attribute("valor"); // Valor da transação

        ArrayList<String> valoresOrigem = new ArrayList<>();
        valoresOrigem.add("internacional");
        valoresOrigem.add("nacional");
        atributoOrigem = new Attribute("origem", valoresOrigem); // Origem da transação

        ArrayList<String> valoresFraude = new ArrayList<>();
        valoresFraude.add("nao");
        valoresFraude.add("sim");
        atributoFraude = new Attribute("fraude", valoresFraude); // rotulo: se é ou não fraude

        ArrayList<Attribute> atributos = new ArrayList<>();
        atributos.add(atributoValor);
        atributos.add(atributoOrigem);
        atributos.add(atributoFraude);

        // ETAPA 3: CRIAÇÂO DO DATASET (estrutura base da planilha)

        //Cria o dataset chamado "transacoes" com os atributos definidos. COmeça vazio (0 linhas)
        dadosTreinamento = new Instances("transacoes", atributos, 0);

        //Define o ultimo atributo ("fraude") como a classe alvo para a previsão.
        dadosTreinamento.setClassIndex(dadosTreinamento.numAttributes() - 1);
    }
    // Método auxiliar para criar e adicionar nova transação ao dataset de treino
    /* Significa que aqui sera criada uma nova instancia de dados (uma linha),
     * com a mesma quantidade de colunas (atributos) do dataset dadosTreinamento.
     * É como criar uma nova linha em branco em uma planilha, onde você ainda vai
     * preencher as colunas: valor, origem e fraude.
     */
    private  void adicionarTransacao(double valor, String origem, String fraude){
        Instance instancia = new DenseInstance(dadosTreinamento.numAttributes());

        // setDataset(...) é uma configuração obrigatória que diz a instancia:
        //"Você vai seguir a mesma estrutura do dataset - os mesmos atributos, na mesma ordem e com os mesmos dados."
        instancia.setDataset(dadosTreinamento);

        instancia.setValue(atributoValor, valor);
        instancia.setValue(atributoOrigem, origem);
        instancia.setValue(atributoFraude, fraude);
        dadosTreinamento.add(instancia);

        // ETAPA 4: ADIÇÂO DE EXEMPLOS (dados de treino para o modelo aprender)
    }

    public void adicionarExemplos() {
        // Exemplos de transacoes FRAUDULENTAS (Valores altos + origem internacional)
        adicionarTransacao(5000, "internacional", "sim");
        adicionarTransacao(10000, "internacional", "sim");
        adicionarTransacao(7500, "internacional", "sim");
        adicionarTransacao(8000, "internacional", "sim");

        // Exemplos de transações NORMAIS (valores baixos + origem nacional)
        adicionarTransacao(200, "nacional", "nao");
        adicionarTransacao(150, "nacional", "nao");
        adicionarTransacao(300, "nacional", "nao");
        adicionarTransacao(400, "nacional", "nao");

        // Exemplos adicionais:
        // Transações com valos médios/altos em território nacional
        //pode ser usado para demonstrar variação ou desafiar o modelo:

        adicionarTransacao(1000, "nacional", "sim");
        adicionarTransacao(1500, "nacional", "sim");
        adicionarTransacao(20000, "nacional", "sim");
    }

    // ESTAPA 5: TREINAMENTO DO MODELO
    public void treinarModelo() throws Exception{
        classificador = new J48(); // Cria o modelo de decisão chamado J48 (método matemático)
        classificador.buildClassifier(dadosTreinamento);
    }

    // ETAPA 6: CLASSIFICAÇÂO DE NOVAS TRANSAÇÕES
    public String classificarTransacao(double valor, String origem) throws Exception {
        // Cria uma nova transação para prever se é fraude ou não
        Instance novaInstancia = new DenseInstance(dadosTreinamento.numAttributes());
        novaInstancia.setDataset(dadosTreinamento);
        novaInstancia.setValue(atributoValor, valor);
        novaInstancia.setValue(atributoOrigem, origem);

        // Pedir para o classificador prever se a nova transação é fraude ou não
        // O resultado será 0.0 (não é fraude) ou 1.0 (é fraude), conforme treinamento
        double previsao = classificador.classifyInstance(novaInstancia);
        //Obs: classifyInstance retorna número decimal porque usa o mesmo método para prever classes e números

        // Transforma o número previsto em texto (ex: 0 "não", 1 "sim") e monta a resposta final
        return "Fraude: " + dadosTreinamento.classAttribute().value((int) previsao);
    }
}
