package net.local.poc.service.empregadosvc.infrastructure.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.service.empregadosvc.application.services.EmpregadoService;
import net.local.poc.service.empregadosvc.infrastructure.persistence.repository.EmpregadoRepository;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public EmpregadoRepository repository() {
        return new EmpregadoRepository();
    }

    @Bean
    public EmpregadoService service(EmpregadoRepository repository) {
        return new EmpregadoService(repository, repository);
    }
}
