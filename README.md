# Conversor de Moedas

## Descrição

Este projeto é um conversor de moedas simples que utiliza a API FastForex para obter taxas de câmbio em tempo real. O usuário pode selecionar moedas de origem e destino para realizar a conversão e visualizar a taxa de câmbio atual. O histórico de conversões é armazenado e pode ser exibido a qualquer momento.

## Funcionalidades

- Conversão de moedas entre várias opções disponíveis.
- Exibição da taxa de câmbio atual entre as moedas selecionadas.
- Armazenamento e exibição do histórico de conversões realizadas.

## Tecnologias Utilizadas

- Java
- Biblioteca `HttpClient` para requisições HTTP.
- Biblioteca `Gson` para manipulação de JSON.
- API FastForex para obtenção das taxas de câmbio.

## Pré-requisitos

- Java 11 ou superior.
- Conexão com a internet para acessar a API de conversão de moedas.

## Como Executar

1. Clone o repositório para sua máquina local:

    ```bash
    git clone https://github.com/seu-usuario/conversor-de-moedas.git
    cd conversor-de-moedas
    ```

2. Compile o projeto:

    ```bash
    javac -cp .:gson-2.8.6.jar br/com/alura/conversor/principal/Main.java
    ```

3. Execute o projeto:

    ```bash
    java -cp .:gson-2.8.6.jar br.com.alura.conversor.principal.Main
    ```

## Uso

1. Ao iniciar o programa, um menu será exibido com as opções de moedas disponíveis para conversão.
2. Escolha a moeda de origem digitando o número correspondente.
3. Escolha a moeda de destino digitando o número correspondente.
4. A taxa de câmbio atual será exibida.
5. Para visualizar o histórico de conversões, escolha a opção 11 no menu principal.
6. Para sair do programa, escolha a opção 12 no menu principal.

## Exemplo de Uso

```plaintext
========================================
Menu de Conversão de Moedas: 
1. USD (Dólar Americano)
2. BRL (Real Brasileiro)
3. EUR (Euro)
4. GBP (Libra Esterlina)
5. JPY (Iene Japonês)
6. ARS (Peso Argentino)
7. CAD (Dólar Canadense)
8. AUD (Dólar Australiano)
9. CHF (Franco Suíço)
10. CNY (Yuan Chinês)
11. Exibir Histórico de Conversões
12. Sair
========================================
Escolha a moeda de origem (número): 1
Escolha a moeda de destino (número): 2
========================================
Resposta JSON bruta:
{"base":"USD","result":{"BRL":5.42},"updated":"2023-10-01T12:00:00Z"}
========================================
Taxa de câmbio USD para BRL: 5.42
========================================
```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorias e correções.
