package net.local.poc.service.departamentosvc.application.ports.persistence;

import java.util.List;
import java.util.Optional;

import net.local.poc.service.departamentosvc.application.domain.Departamento;

public interface LoadDepartamentoPort {
    Optional<Departamento> loadByCodDepartamento(Integer codDepartamento);
    List<Departamento> loadByCodEmpresa(Integer codEmpresa);
    List<Departamento> loadAll();
}
