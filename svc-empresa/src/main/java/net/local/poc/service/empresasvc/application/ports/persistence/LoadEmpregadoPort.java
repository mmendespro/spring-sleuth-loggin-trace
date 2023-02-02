package net.local.poc.service.empresasvc.application.ports.persistence;

import java.util.List;

import net.local.poc.service.empresasvc.application.dto.EmpregadoDTO;

public interface LoadEmpregadoPort {
    List<EmpregadoDTO> loadEmpregados(Integer codEmpresa);
}
