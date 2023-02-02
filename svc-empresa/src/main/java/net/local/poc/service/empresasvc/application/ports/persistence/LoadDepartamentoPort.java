package net.local.poc.service.empresasvc.application.ports.persistence;

import java.util.List;

import net.local.poc.service.empresasvc.application.dto.DepartamentoDTO;

public interface LoadDepartamentoPort {
    List<DepartamentoDTO> loadDepartamentos(Integer codEmpresa);
    List<DepartamentoDTO> loadDepartamentosEmpregados(Integer codEmpresa);
}
