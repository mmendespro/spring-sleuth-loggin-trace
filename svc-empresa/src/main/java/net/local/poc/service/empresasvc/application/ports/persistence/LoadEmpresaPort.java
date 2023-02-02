package net.local.poc.service.empresasvc.application.ports.persistence;

import java.util.List;
import java.util.Optional;

import net.local.poc.service.empresasvc.application.domain.Empresa;

public interface LoadEmpresaPort {
    List<Empresa> loadAll();
    Optional<Empresa> loadByCodEmpresa(Integer codEmpresa);
}
