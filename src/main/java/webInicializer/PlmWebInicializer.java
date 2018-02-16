package webInicializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"artista", "musica","playlist","musicaPL","usuario"})
@EnableJpaRepositories({"artista", "musica","playlist","musicaPL","usuario"})
@EntityScan({"artista", "musica","playlist","musicaPL","usuario"})
public class PlmWebInicializer {

	public static void main(String[] args) {
		SpringApplication.run(PlmWebInicializer.class, args);
	}
}
