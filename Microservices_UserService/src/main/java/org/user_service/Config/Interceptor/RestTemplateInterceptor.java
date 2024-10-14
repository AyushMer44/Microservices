//package org.user_service.Config.Interceptor;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
//
//import java.io.IOException;
//
//public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
//    private OAuth2AuthorizedClientManager manager;
//
//    private Logger logger = LoggerFactory.getLogger(RestTemplateInterceptor.class);
//
//    public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {
//        this.manager = manager;
//    }
//
//    @Override
//    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        String token = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build())
//                .getAccessToken().getTokenValue();
//
//        logger.info("Rest Template Interceptor: Token: {}",token);
//
//        request.getHeaders().add("Authorization","Bearer"+token);
//
//        return execution.execute(request,body);
////        ClientHttpResponse response = execution.execute(request, body);
////        if (response.getRawStatusCode() == 401){
////            response.getBody().close();
////        }
////        logger.info("Rest Template Interceptor: Success");
////        return response;
//    }
//}
