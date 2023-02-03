package net.local.poc.service.empresasvc.infrastructure.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.service.empresasvc.application.ports.httpclients.LoadDepartamentoPort;
import net.local.poc.service.empresasvc.application.ports.httpclients.LoadEmpregadoPort;
import net.local.poc.service.empresasvc.application.services.EmpresaService;
import net.local.poc.service.empresasvc.infrastructure.persistence.repository.EmpresaRepository;


@Configuration
public class ApplicationConfig {
    
    @Bean
    public EmpresaRepository repository() {
        return new EmpresaRepository();
    }

    @Bean
    public EmpresaService service(LoadEmpregadoPort empregadoPort, LoadDepartamentoPort departamentoPort, EmpresaRepository repository) {
        return new EmpresaService(empregadoPort, departamentoPort, repository, repository);
    }
}
