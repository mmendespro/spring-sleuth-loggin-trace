package net.local.poc.service.empresasvc.application.ports.usecases;

import net.local.poc.service.empresasvc.application.dto.EmpresaRequest;

public interface CriarEmpresa {
    void criar(EmpresaRequest request);
}
