package net.local.poc.service.empresasvc.infrastructure.persistence.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.local.poc.service.empresasvc.application.domain.Empresa;
import net.local.poc.service.empresasvc.infrastructure.persistence.repository.EmpresaRepository;

@Component
public class InitDatabase {
    
    private final EmpresaRepository repository;

    private Logger logger = LoggerFactory.getLogger(InitDatabase.class);

    public InitDatabase(EmpresaRepository repository) {
        this.repository = repository;
    }

    public void init() {
        logger.info("Iniciando database em memória...");
        repository.save(new Empresa(1, "DFX Transporte"));
    }
}
