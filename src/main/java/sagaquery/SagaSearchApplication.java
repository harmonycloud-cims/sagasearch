package sagaquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})

@EnableJpaRepositories(value = "sagaquery.repository",excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern="com\\.harmonycloud\\..*")})
@EnableSwagger2
@EntityScan("sagaquery.entity")
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern="com\\.harmonycloud\\..*")})
public class SagaSearchApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    public static void main(String[] args) {
        SpringApplication.run(SagaSearchApplication.class, args);
    }

}
