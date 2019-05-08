package com.mera.inkrot.apachecxf;

import com.mera.inkrot.apachecxf.service.CustomerService;
import com.mera.inkrot.apachecxf.service.impl.CustomerServiceImpl;
import com.mera.inkrot.apachecxf.service.impl.HelloServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EntityScan("com.mera.inkrot.apachecxf.model")
@ComponentScan({"com.mera.inkrot.apachecxf.service", "com.mera.inkrot.apachecxf.rest"})
@EnableJpaRepositories("com.mera.inkrot.apachecxf.repository")
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class Application extends SpringBootServletInitializer {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CustomerServiceImpl customerService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Replaces the need for web.xml
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
        return new ServletRegistrationBean(new CXFServlet(), "/api/*");
    }

    // Replaces cxf-servlet.xml
    @Bean
    // <jaxws:endpoint id="helloWorld" implementor="demo.spring.service.HelloWorldImpl" address="/HelloWorld"/>
    public EndpointImpl helloService() {
        Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
        Object implementor = new HelloServiceImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/hello");
        return endpoint;
    }

    @Bean
    public EndpointImpl customerService() {
        Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
        Object implementor = new CustomerServiceImpl();
        EndpointImpl endpoint = new EndpointImpl(bus, customerService);
        endpoint.publish("/customer");
        return endpoint;
    }

    // Used when deploying to a standalone servlet container, i.e. tomcat
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}