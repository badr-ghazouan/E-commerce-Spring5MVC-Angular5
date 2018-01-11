package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "web")
public class WebConfig extends WebMvcConfigurerAdapter {


    @Bean
    public InternalResourceViewResolver inertInternalResourceViewResolverInitiator()
    {
        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();

        resolver.setPrefix("/views/src/");
        resolver.setSuffix(".html");
        //resolver.setExposeContextBeansAsAttributes(true);

        System.out.println("Web Configuration : loading View Resolver");

        return resolver;
    }


    @Override
    public void configureDefaultServletHandling
            (DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }



    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        converters.add(jsonMessageConverter);
    }




    }
