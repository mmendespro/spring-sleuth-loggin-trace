package net.local.poc.service.empregadosvc.infrastructure.persistence.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.local.poc.service.empregadosvc.application.domain.Empregado;
import net.local.poc.service.empregadosvc.infrastructure.persistence.repository.EmpregadoRepository;

@Component
public class InitDatabase {
    
    private final EmpregadoRepository repository;

    private Logger logger = LoggerFactory.getLogger(InitDatabase.class);

    public InitDatabase(EmpregadoRepository repository) {
        this.repository = repository;
    }

    public void init() {
        logger.info("Iniciando database em memória...");
        repository.salvar(new Empregado(1, 1, 1, "Eduardo"));
        repository.salvar(new Empregado(2, 1, 1, "Marcia"));

        repository.salvar(new Empregado(3, 2, 1, "Paulo"));
        repository.salvar(new Empregado(4, 2, 1, "Fernando"));
    }
}
