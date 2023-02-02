package net.local.poc.service.empresasvc.application.ports.usecases;

import net.local.poc.service.empresasvc.application.dto.EmpresaResponse;

public interface ListarEmpresaComDepartamentos {
    EmpresaResponse listarEmpresaComDepartamento(Integer codEmpresa);
    EmpresaResponse listarEmpresaComDepartamentoEmpregado(Integer codEmpresa);
}
