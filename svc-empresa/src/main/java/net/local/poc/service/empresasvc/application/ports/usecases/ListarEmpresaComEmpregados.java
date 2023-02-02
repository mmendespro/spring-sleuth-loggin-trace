package net.local.poc.service.empresasvc.application.ports.usecases;

import net.local.poc.service.empresasvc.application.dto.EmpresaResponse;

public interface ListarEmpresaComEmpregados {
    EmpresaResponse listarEmpresaComEmpregados(Integer codEmpresa);
}
