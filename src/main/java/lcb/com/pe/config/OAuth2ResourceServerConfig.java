package lcb.com.pe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class OAuth2ResourceServerConfig extends GlobalMethodSecurityConfiguration{
	// @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER - 1)

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		return new lcb.com.pe.config.OAuth2MethodSecurityExpressionHandler();
	}

}
