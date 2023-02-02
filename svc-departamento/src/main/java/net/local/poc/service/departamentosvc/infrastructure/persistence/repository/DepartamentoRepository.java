package net.local.poc.service.departamentosvc.infrastructure.persistence.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.local.poc.service.departamentosvc.application.domain.Departamento;
import net.local.poc.service.departamentosvc.application.ports.persistence.LoadDepartamentoPort;
import net.local.poc.service.departamentosvc.application.ports.persistence.SaveDepartamentoPort;

public class DepartamentoRepository implements LoadDepartamentoPort, SaveDepartamentoPort {
    
    private final Map<Integer,Departamento> inMemoryDB = new TreeMap<>();

    @Override
    public void salvar(Departamento departamento) {
        inMemoryDB.putIfAbsent(departamento.getCodDepartamento(), departamento);
    }

    @Override
    public Optional<Departamento> loadByCodDepartamento(Integer codDepartamento) {
        return Optional.of(inMemoryDB.get(codDepartamento));
    }

    @Override
    public List<Departamento> loadByCodEmpresa(Integer codEmpresa) {
        return inMemoryDB.values().stream().filter(dep -> dep.getCodEmpresa().equals(codEmpresa)).collect(Collectors.toList());
    }

    @Override
    public List<Departamento> loadAll() {
        return inMemoryDB.values().stream().collect(Collectors.toList());
    }
}
