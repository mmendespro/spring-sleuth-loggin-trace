package net.local.poc.service.departamentosvc.infrastructure.persistence.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.local.poc.service.departamentosvc.application.domain.Departamento;
import net.local.poc.service.departamentosvc.infrastructure.persistence.repository.DepartamentoRepository;

@Component
public class InitDatabase {
    
    private final DepartamentoRepository repository;

    private Logger logger = LoggerFactory.getLogger(InitDatabase.class);

    public InitDatabase(DepartamentoRepository repository) {
        this.repository = repository;
    }

    public void init() {
        logger.info("Iniciando database em memória...");
        repository.salvar(new Departamento(1, 1, "Tecnologia da Informação"));
        repository.salvar(new Departamento(2, 1, "Propaganda e Marketing"));
    }
}
