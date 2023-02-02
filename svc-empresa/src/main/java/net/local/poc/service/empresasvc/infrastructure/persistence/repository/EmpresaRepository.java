package net.local.poc.service.empresasvc.infrastructure.persistence.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.local.poc.service.empresasvc.application.domain.Empresa;
import net.local.poc.service.empresasvc.application.ports.persistence.LoadEmpresaPort;
import net.local.poc.service.empresasvc.application.ports.persistence.SaveEmpresaPort;

public class EmpresaRepository implements LoadEmpresaPort, SaveEmpresaPort {
    
    private final Map<Integer,Empresa> inMemoryDB = new TreeMap<>();

    @Override
    public void save(Empresa empresa) {
        inMemoryDB.putIfAbsent(empresa.getCodEmpresa(), empresa);
    }

    @Override
    public List<Empresa> loadAll() {
        return inMemoryDB.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Empresa> loadByCodEmpresa(Integer codEmpresa) {
        return Optional.of(inMemoryDB.get(codEmpresa));
    }

}
