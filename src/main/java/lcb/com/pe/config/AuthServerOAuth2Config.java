package lcb.com.pe.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
/*import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;*/
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import lcb.com.pe.security.Authorities;

@Configuration
@EnableAuthorizationServer
public class AuthServerOAuth2Config  extends AuthorizationServerConfigurerAdapter implements EnvironmentAware{

	 private static final String ENV_OAUTH = "authentication.oauth.";
     private static final String PROP_CLIENTID = "clientid";
     private static final String PROP_SECRET = "secret";
     private static final String PROP_TOKEN_VALIDITY_SECONDS = "tokenValidityInSeconds";

     private RelaxedPropertyResolver propertyResolver;
     
     @Autowired
     @Qualifier("authenticationManagerBean")
     private AuthenticationManager authenticationManager;

     @Autowired
     private DataSource dataSource;

     @Bean
     public TokenStore tokenStore() {
         return new JdbcTokenStore(dataSource);
     }

     /*@Bean
     public ApprovalStore approvalStore() {
         return new JdbcApprovalStore(dataSource);
     }

     @Bean
     public AuthorizationCodeServices authorizationCodeServices() {
         return new JdbcAuthorizationCodeServices(dataSource);
     }*/
          
     /**
      * We expose the JdbcClientDetailsService because it has extra methods that the Interface does not have. E.g.
      * {@link org.springframework.security.oauth2.provider.client.JdbcClientDetailsService#listClientDetails()} which we need for the
      * admin page.
      */
     
     /*@Bean
     public JdbcClientDetailsService clientDetailsService() {
         return new JdbcClientDetailsService(dataSource);
     }*/

     @Override
     public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
         //clients.withClientDetails(clientDetailsService());
         
         clients
         .inMemory()
         .withClient(propertyResolver.getProperty(PROP_CLIENTID))
         .authorizedGrantTypes("authorization_code", "password", "refresh_token")
         .authorities(Authorities.ROLE_ADMIN.name(), Authorities.ROLE_USER.name())
         .scopes("read", "write")
         .secret(propertyResolver.getProperty(PROP_SECRET))
         .accessTokenValiditySeconds(propertyResolver.getProperty(PROP_TOKEN_VALIDITY_SECONDS, Integer.class, 2000));
         
     }


     /*@Override
     public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
         //oauthServer.realm("sparklr2/client");
         //oauthServer.allowFormAuthenticationForClients();
    	 oauthServer
         .tokenKeyAccess("permitAll()")
         .checkTokenAccess("isAuthenticated()");
     }*/
     
     @Override
     public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
           endpoints
             .tokenStore(tokenStore())
             .authenticationManager(authenticationManager);
    	 
         /*endpoints
         .approvalStore(approvalStore())
         .authorizationCodeServices(authorizationCodeServices())
         .tokenStore(tokenStore());*/
     }
     
     @Override
     public void setEnvironment(Environment environment) {
         this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_OAUTH);
     }
	
}
