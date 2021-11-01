package com.fr.projetjee;
import com.fr.projetjee.persistence.entities.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class ProjetjeeApplication implements CommandLineRunner{

  public static void main(String[] args) {
    SpringApplication.run(ProjetjeeApplication.class, args);
  }
  
  /**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("ADMIN");
		user.setPassword("ADMIN");

		//userRepository.save(user);
	}
}
