package org.sid.billing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultTemplate;

import java.util.Map;

@SpringBootApplication
public class BillingApplication {
	private VaultTemplate vaultTemplate;

	public BillingApplication(VaultTemplate vaultTemplate) {
		this.vaultTemplate = vaultTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}

	@Bean
	CommandLineRunner start(){
		return args -> {
			vaultTemplate.opsForVersionedKeyValue("secret").put("mySecrets", Map.of("mySecret.p1","659844919"));
		};
	}

}
