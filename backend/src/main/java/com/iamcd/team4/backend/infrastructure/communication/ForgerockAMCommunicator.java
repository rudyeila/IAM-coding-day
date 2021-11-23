package com.iamcd.team4.backend.infrastructure.communication;

import com.iamcd.team4.backend.logic.model.AccessToken;
import com.iamcd.team4.backend.logic.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Component
public class ForgerockAMCommunicator {

    private WebClient webClient;

    public ForgerockAMCommunicator(@Value("${forgeRock.url}") String url) {
        DefaultUriBuilderFactory factoryWithoutEncoding = new DefaultUriBuilderFactory(url);
        factoryWithoutEncoding.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        this.webClient = WebClient.builder()
                .uriBuilderFactory(factoryWithoutEncoding)
                .baseUrl(url)
                .build();

    }

    public User getUserInfo(String token) {
        return webClient.get()
                .uri("/userinfo")
                .headers(h -> h.setBearerAuth(token))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(User.class)
                .block();
    }

    public AccessToken getAccessToken(String authorizationCode) {
        MultiValueMap<String, String> bodyValues = new LinkedMultiValueMap<>();
        bodyValues.add("grant_type", "authorization_code");
        bodyValues.add("client_id", "testclient");
        bodyValues.add("code", authorizationCode);
        bodyValues.add("redirect_uri", "http://localhost:4200");

        AccessToken token = webClient.post()
                .uri("/access_token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromFormData(bodyValues))
                .retrieve()
                .bodyToMono(AccessToken.class)
                .block();

        return token;
    }

}
