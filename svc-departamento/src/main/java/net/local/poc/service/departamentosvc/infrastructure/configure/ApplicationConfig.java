package net.local.poc.service.departamentosvc.infrastructure.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.service.departamentosvc.application.ports.persistence.BuscarEmpregadosPort;
import net.local.poc.service.departamentosvc.application.services.DepartamentoService;
import net.local.poc.service.departamentosvc.infrastructure.persistence.repository.DepartamentoRepository;

@Configuration
public class ApplicationConfig {
    
    @Bean
    public DepartamentoRepository repository() {
        return new DepartamentoRepository();
    }

    @Bean
    public DepartamentoService service(DepartamentoRepository repository, BuscarEmpregadosPort buscarEmpregadosPort) {
        return new DepartamentoService(buscarEmpregadosPort, repository, repository);
    }
}
