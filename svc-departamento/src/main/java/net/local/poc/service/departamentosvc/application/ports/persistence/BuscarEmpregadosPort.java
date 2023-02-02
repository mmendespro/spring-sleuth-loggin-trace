package net.local.poc.service.departamentosvc.application.ports.persistence;

import java.util.List;

import net.local.poc.service.departamentosvc.application.dto.EmpregadoDTO;

public interface BuscarEmpregadosPort {
    List<EmpregadoDTO> buscar(Integer codDepartamento);
}
