package net.local.poc.service.empregadosvc.infrastructure.persistence.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import net.local.poc.service.empregadosvc.application.domain.Empregado;
import net.local.poc.service.empregadosvc.application.ports.persistence.LoadEmpregadoPort;
import net.local.poc.service.empregadosvc.application.ports.persistence.SaveEmpregadoPort;

public class EmpregadoRepository implements LoadEmpregadoPort, SaveEmpregadoPort {

    private final Map<Integer,Empregado> inMemoryDB = new TreeMap<>();

    @Override
    public void salvar(Empregado empregado) {
        inMemoryDB.putIfAbsent(empregado.getCodEmpregado(), empregado);
    }

    @Override
    public Optional<Empregado> loadByCodEmpregado(Integer codEmpregado) {
        return Optional.of(inMemoryDB.get(codEmpregado));
    }

    @Override
    public List<Empregado> loadByCodDepartamento(Integer codDepartamento) {
        return inMemoryDB.values().stream().filter(emp -> emp.getCodDepartamento().equals(codDepartamento)).collect(Collectors.toList());
    }

    @Override
    public List<Empregado> loadByCodEmpresa(Integer codEmpresa) {
        return inMemoryDB.values().stream().filter(emp -> emp.getCodEmpresa().equals(codEmpresa)).collect(Collectors.toList());
    }

    @Override
    public List<Empregado> loadAll() {
        return inMemoryDB.values().stream().collect(Collectors.toList());
    }
    
}
