package org.user_service.Config.Interceptor;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@Component
//public class FeignClientInterceptor implements RequestInterceptor {
//
//    private Logger logger = LoggerFactory.getLogger(RestTemplateInterceptor.class);
//
//    @Autowired
//    private OAuth2AuthorizedClientManager manager;
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        String token = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build())
//                        .getAccessToken().getTokenValue();
//
//        logger.info("Feign Client Interceptor: Token: {}",token);
//
//        requestTemplate.header("Authorization","Bearer" + token);
//    }
//}

public class FeignClientInterceptor {
}
