package org.user_service.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfig {
//
//    @Autowired
//    private ClientRegistrationRepository clientRegistrationRepository;
//    @Autowired
//    private OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;


    // Jab ek se jyada instances hote hain tab load ko balance krna... isliye we use loadBalancer...
    //toh isse hmara restTemplate localhost ke bjaye services ke name se api call krega...

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        return new RestTemplate();
// Configuring Interceptors also for okta security...
//        RestTemplate restTemplate = new RestTemplate();
//
//        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//        interceptors.add(new RestTemplateInterceptor(manager(
//                clientRegistrationRepository,
//                oAuth2AuthorizedClientRepository
//        )));
//        restTemplate.setInterceptors(interceptors);
//
//        return restTemplate;
    }

    // Declaring the bean of OAuth2AuthorizedClient manager...
//
//    @Bean
//    public OAuth2AuthorizedClientManager manager(
//            ClientRegistrationRepository clientRegistrationRepository,
//            OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository
//    )
//    {
//        OAuth2AuthorizedClientProvider provider = OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
//
//        DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,auth2AuthorizedClientRepository);
//
//        defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);
//
//        return defaultOAuth2AuthorizedClientManager;
//    }
}
