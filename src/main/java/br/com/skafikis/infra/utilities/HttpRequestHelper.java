package br.com.skafikis.infra.utilities;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpRequestHelper {
    private final HttpClient httpClient;

    public HttpRequestHelper() {
        httpClient = HttpClient.newHttpClient();
    }

    public HttpResponse<String> sendRequest(String url, String method, String body, String token) {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json");

            if (token != null) {
                builder.header("Authorization", "Bearer " + token);
            }

            if (method.equalsIgnoreCase("POST")) {
                builder.POST(HttpRequest.BodyPublishers.ofString(body));
            } else if (method.equalsIgnoreCase("GET")) {
                builder.GET();
            }

            return httpClient.send(builder.build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception exception) {
            throw new RuntimeException("Failed to send HTTP request ",exception);
        }
    }
}
