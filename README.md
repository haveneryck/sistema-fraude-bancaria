# 🔍 Sistema de Detecção de Fraude Bancária — Machine Learning com Spring Boot

Sistema inteligente de detecção de fraude em transações bancárias utilizando Machine Learning com Java + Spring Boot + Weka 3.8.6.

## 🚀 Tecnologias Utilizadas

- Java 22
- Spring Boot
- Weka 3.8.6
- Algoritmo J48 (Árvore de Decisão)
- Maven

## 📋 Sobre o Projeto

O sistema treina um modelo de Machine Learning com dados históricos de transações bancárias e classifica novas transações como **fraude** ou **não fraude** com base nos padrões aprendidos.

### Funcionalidades

- Treinamento de modelo com dados de transações históricas
- Classificação de novas transações em tempo real
- Arquitetura com responsabilidade única: lógica de ML completamente isolada da camada Spring Boot

## 📁 Estrutura do Projeto

src/main/java/com/haveneryck/sistemafraudebancaria/
├── SistemaFraudeBancariaApplication.java   # Classe principal (Spring Boot)
└── DeteccaoDeFraudeBancaria.java           # Lógica de Machine Learning (Weka)

## 🧠 Como Funciona o Machine Learning

| Etapa | Descrição |
|-------|-----------|
| 1. Coleta de dados | Transações bancárias com atributos: valor, origem e classificação (fraude/não fraude) |
| 2. Treinamento | Modelo treinado com algoritmo J48 (árvore de decisão) via Weka |
| 3. Classificação | Novas transações classificadas em tempo real pelo modelo treinado |

## ⚙️ Como Executar

**Pré-requisitos**
- Java 22+
- Maven

**Passos**

```bash
# Clone o repositório
git clone git@github.com:haveneryck/sistema-fraude-bancaria.git

# Entre na pasta
cd sistema-fraude-bancaria

# Execute o projeto
./mvnw spring-boot:run
```

## 📈 Exemplo de Classificação

Transação: valor=50000.00, origem=internacional
Resultado: Fraude: sim
Transação: valor=150.00, origem=nacional
Resultado: Fraude: não

## 🏗️ Decisões de Arquitetura

- **Responsabilidade única**: a classe `DeteccaoDeFraudeBancaria` encapsula toda a lógica de ML, mantendo a classe principal limpa
- **Weka 3.8.6**: biblioteca consolidada para Machine Learning em Java, com suporte nativo ao algoritmo J48
- **J48**: implementação do algoritmo C4.5, ideal para classificação binária com dados tabulares

## 👨‍💻 Autor

**Vinícius Oliveira Brito**
[LinkedIn](https://linkedin.com/in/haveneryck) • [GitHub](https://github.com/haveneryck)