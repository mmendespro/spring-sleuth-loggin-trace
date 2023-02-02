package net.local.poc.service.empregadosvc.application.ports.usecases;

import net.local.poc.service.empregadosvc.application.dto.EmpregadoRequest;

public interface CriarEmpregado {
    void criar(EmpregadoRequest empregadoRequest);
}
