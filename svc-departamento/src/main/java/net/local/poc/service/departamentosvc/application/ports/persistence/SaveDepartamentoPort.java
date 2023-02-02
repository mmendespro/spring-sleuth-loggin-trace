package net.local.poc.service.departamentosvc.application.ports.persistence;

import net.local.poc.service.departamentosvc.application.domain.Departamento;

public interface SaveDepartamentoPort {
    void salvar(Departamento departamento);
}
