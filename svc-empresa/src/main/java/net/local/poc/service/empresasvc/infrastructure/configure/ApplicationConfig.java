package net.local.poc.service.empresasvc.infrastructure.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.service.empresasvc.infrastructure.persistence.repository.EmpresaRepository;


@Configuration
public class ApplicationConfig {
    
    @Bean
    public EmpresaRepository repository() {
        return new EmpresaRepository();
    }
}
