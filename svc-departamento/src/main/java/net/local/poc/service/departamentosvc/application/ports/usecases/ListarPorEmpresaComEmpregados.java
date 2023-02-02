package net.local.poc.service.departamentosvc.application.ports.usecases;

import java.util.List;

import net.local.poc.service.departamentosvc.application.dto.DepartamentoResponse;

public interface ListarPorEmpresaComEmpregados {
    List<DepartamentoResponse> listarPorEmpresaComEmpregados(Integer codEmpresa);    
}
