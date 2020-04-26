package br.com.gabs.playlistapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket msCorinthansApi(){

        return new Docket(DocumentationType.SWAGGER_2)

                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.gabs.playlistapi"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.info());
    }

    public ApiInfo info() {

        return new ApiInfoBuilder()
                .title("Playlist API")
                .description("API responsável pelo controle de informações de uma Playlist de Músicas.")
                .version("1.0")
                .build();
    }
}
