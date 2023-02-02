package net.local.poc.service.empregadosvc.application.ports.usecases;

import java.util.List;

import net.local.poc.service.empregadosvc.application.dto.EmpregadoResponse;

public interface ListarTodos {
    List<EmpregadoResponse> listar();
}
