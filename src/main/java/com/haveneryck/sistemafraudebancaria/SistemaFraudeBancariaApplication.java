package com.haveneryck.sistemafraudebancaria;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaFraudeBancariaApplication {

    // TESTE COMPLETO DO PROCESSO DE ML
    public static void main(String[] args) {
        // Oculta avisos sobre bibliotecas nativas (não afeta o funcionamento)
        Logger.getLogger("com.github.fommil.netlib").setLevel(Level.SEVERE);
        // Criação do detector
        DeteccaoDeFraudeBancaria detector = new DeteccaoDeFraudeBancaria();

        try {
            // ETAPA 2 - DEFINIR ATRIBUTOS
            detector.definirAtributos();

            // ETAPA 4 - ADICIONAR EXEMPLOS
            detector.adicionarExemplos();

            // ETAPA 5 - Treinar modelo
            detector.treinarModelo();

            // ETAPA 6 - Classificar novas transações
            String resultado1 = detector.classificarTransacao(5000, "internacional");
            String resultado2 = detector.classificarTransacao(200, "nacional");
            String resultado3 = detector.classificarTransacao(10000, "internacional");
            String resultado4 = detector.classificarTransacao(150, "nacional");
            String resultado5 = detector.classificarTransacao(7500, "internacional");
            String resultado6 = detector.classificarTransacao(300, "nacional");
            String resultado7 = detector.classificarTransacao(8000, "internacional");
            String resultado8 = detector.classificarTransacao(400, "nacional");

            String resultado9 = detector.classificarTransacao(1000, "nacional");
            String resultado10 = detector.classificarTransacao(395, "internacional");

            // Impressão dos resultados
            System.out.println("Teste 1: " + resultado1);
            System.out.println("Teste 2: " + resultado2);
            System.out.println("Teste 3: " + resultado3);
            System.out.println("Teste 4: " + resultado4);
            System.out.println("Teste 5: " + resultado5);
            System.out.println("Teste 6: " + resultado6);
            System.out.println("Teste 7: " + resultado7);
            System.out.println("Teste 8: " + resultado8);

            System.out.println("Teste 9: " + resultado9);
            System.out.println("Teste 10: " + resultado10);

        }  catch (Exception e) {
            System.out.println("Erro ao classificar a transação: " + e.getMessage());
        }
    }
}