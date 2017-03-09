package lcb.com.pe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class DefaultView extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "forward:/pages/login.html" );
        registry.addViewController( "/login" ).setViewName( "forward:/pages/login.html" );
        registry.addViewController( "/forgot" ).setViewName( "forward:/pages/forgot.html" );
        registry.addViewController( "/error" ).setViewName( "forward:/pages/error.html" );
        registry.addViewController( "/404" ).setViewName( "forward:/pages/404.html" );
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers( registry );
    }
}