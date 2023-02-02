package net.local.poc.service.empresasvc.application.ports.usecases;

import java.util.List;

import net.local.poc.service.empresasvc.application.dto.EmpresaResponse;

public interface ListarTodos {
    List<EmpresaResponse> listar();
}
