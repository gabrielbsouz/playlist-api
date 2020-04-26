package br.com.gabs.playlistapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PlaylistApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistApiApplication.class, args);
	}

}
