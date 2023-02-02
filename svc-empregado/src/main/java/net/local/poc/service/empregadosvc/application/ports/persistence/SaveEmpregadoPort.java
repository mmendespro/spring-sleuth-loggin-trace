package net.local.poc.service.empregadosvc.application.ports.persistence;

import net.local.poc.service.empregadosvc.application.domain.Empregado;

public interface SaveEmpregadoPort {
    void salvar(Empregado empregado);
}
