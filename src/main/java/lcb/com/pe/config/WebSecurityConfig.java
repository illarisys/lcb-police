package lcb.com.pe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
    /*@Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;
    
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;*/

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		/*.antMatchers("/")
		.antMatchers("/login")
		.antMatchers("/images/**")
		.antMatchers("/layout/**")
		.antMatchers("/template-pages/**")
		.antMatchers("/pages/**")
		.antMatchers("/theme/**")*/
		.antMatchers("/favicon.ico")
		.antMatchers("/forgot")
		.antMatchers("/recover")
		.antMatchers("/404");

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http            
                .authorizeRequests()
                .antMatchers("/crm/**").authenticated()
            .and()
                .logout()
                .logoutUrl("/oauth/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/oauth/logout"))
                //.addLogoutHandler(customLogoutSuccessHandler)
                .deleteCookies("JSESSIONID")
            .and()
                .requestMatchers()
                .antMatchers("/login", "/logout", "/oauth/authorize", "/oauth/confirm_access")
            .and()
                .authorizeRequests()
                .anyRequest().authenticated();
                
        	/*http
        	.exceptionHandling()
        	.authenticationEntryPoint(customAuthenticationEntryPoint);*/
        	
             http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }	
	
	
	/* 
	@Bean
	public FilterRegistrationBean remoteAddressFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		RemoteAddrFilter filter = new RemoteAddrFilter();
		// filter.setAllow("127.0.0.1");
		filter.setAllow("172.16.20.89");
		//filterRegistrationBean.addUrlPatterns("/gs/serving-web-content/testParameters");
		filterRegistrationBean.setFilter(filter);
		return filterRegistrationBean;
	}
	*/	 
	 

}
