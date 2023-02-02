package net.local.poc.service.empregadosvc.application.ports.persistence;

import java.util.List;
import java.util.Optional;

import net.local.poc.service.empregadosvc.application.domain.Empregado;

public interface LoadEmpregadoPort {
    Optional<Empregado> loadByCodEmpregado(Integer codEmpregado);
    List<Empregado> loadByCodDepartamento(Integer codDepartamento);
    List<Empregado> loadByCodEmpresa(Integer codEmpresa);
    List<Empregado> loadAll();
}
