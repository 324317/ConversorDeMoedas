package br.com.alura.conversor.principal;

import com.google.gson.Gson;
//import com.google.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.fastforex.io/fetch-one?from=USD&to=BRL&api_key=05722a7cf4-e8164e0f78-sevzw0"))
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


//        "https://api.fastforex.io/fetch-one?from="+USD+"&to="+BRL+"&api_key=05722a7cf4-e8164e0f78-sevzw0"
    }
}