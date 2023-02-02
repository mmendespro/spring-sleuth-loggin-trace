package net.local.poc.service.departamentosvc.application.ports.usecases;

import net.local.poc.service.departamentosvc.application.dto.DepartamentoRequest;

public interface CriarDepartamento {
    void criar(DepartamentoRequest request);
}
