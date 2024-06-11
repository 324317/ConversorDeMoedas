package br.com.alura.conversor.principal;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        Scanner scanner = new Scanner(System.in);
        String apiKey = "05722a7cf4-e8164e0f78-sevzw0";
        List<String> conversionHistory = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        while (true) {
            System.out.println("========================================");
            System.out.println("Menu de Conversão de Moedas:");
            System.out.println("1. USD (Dólar Americano)");
            System.out.println("2. BRL (Real Brasileiro)");
            System.out.println("3. EUR (Euro)");
            System.out.println("4. GBP (Libra Esterlina)");
            System.out.println("5. JPY (Iene Japonês)");
            System.out.println("6. ARS (Peso Argentino)");
            System.out.println("7. CAD (Dólar Canadense)");
            System.out.println("8. AUD (Dólar Australiano)");
            System.out.println("9. CHF (Franco Suíço)");
            System.out.println("10. CNY (Yuan Chinês)");
            System.out.println("11. Exibir Histórico de Conversões");
            System.out.println("12. Sair");
            System.out.println("========================================");
            System.out.print("Escolha a moeda de origem (número): ");
            int fromChoice = scanner.nextInt();
            if (fromChoice == 12) break;

            if (fromChoice == 11) {
                displayConversionHistory(conversionHistory);
                continue;
            }

            System.out.print("Escolha a moeda de destino (número): ");
            int toChoice = scanner.nextInt();
            if (toChoice == 12) break;

            String fromCurrency = getCurrencyCode(fromChoice);
            String toCurrency = getCurrencyCode(toChoice);

            if (fromCurrency == null || toCurrency == null) {
                System.out.println("Escolha inválida. Tente novamente.");
                continue;
            }

            String url = String.format("https://api.fastforex.io/fetch-one?from=%s&to=%s&api_key=%s", fromCurrency, toCurrency, apiKey);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("accept", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("========================================");
            System.out.println("Resposta JSON bruta:");
            System.out.println(response.body());
            System.out.println("========================================");

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject result = jsonObject.getAsJsonObject("result");
            double exchangeRate = result.get(toCurrency).getAsDouble();

            System.out.println("========================================");
            System.out.println("Taxa de câmbio " + fromCurrency + " para " + toCurrency + ": " + exchangeRate);
            System.out.println("========================================");

            String timestamp = LocalDateTime.now().format(formatter);
            String logEntry = String.format("%s: %s para %s - Taxa: %f", timestamp, fromCurrency, toCurrency, exchangeRate);
            conversionHistory.add(logEntry);
        }

        scanner.close();
    }

    private static String getCurrencyCode(int choice) {
        switch (choice) {
            case 1: return "USD";
            case 2: return "BRL";
            case 3: return "EUR";
            case 4: return "GBP";
            case 5: return "JPY";
            case 6: return "ARS";
            case 7: return "CAD";
            case 8: return "AUD";
            case 9: return "CHF";
            case 10: return "CNY";
            default: return null;
        }
    }

    private static void displayConversionHistory(List<String> conversionHistory) {
        System.out.println("========================================");
        System.out.println("Histórico de Conversões:");
        if (conversionHistory.isEmpty()) {
            System.out.println("Nenhuma conversão realizada até o momento.");
        } else {
            for (String logEntry : conversionHistory) {
                System.out.println(logEntry);
            }
        }
        System.out.println("========================================");
    }
}