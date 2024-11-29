package br.com.skafikis.infra.utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CelcoinAuthHelper {
    private final HttpClient httpClient;
    private final String clientId;
    private final String clientSecret;

    public CelcoinAuthHelper(HttpClient httpClient, String clientId, String clientSecret) {
        this.httpClient = httpClient;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getAuthorizationToken() {
        try {
            String urlParams = String.format("client_id=%s&grant_type=client_credentials&client_secret=%s", clientId, clientSecret);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://sandbox.openfinance.celcoin.dev/v5/token"))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(urlParams))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonResponse.get("access_token").getAsString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get authentication", e);
        }
    }
}
