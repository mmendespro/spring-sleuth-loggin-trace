package net.local.poc.service.empresasvc.application.ports.persistence;

import net.local.poc.service.empresasvc.application.domain.Empresa;

public interface SaveEmpresaPort {
    void save(Empresa empresa);
}
