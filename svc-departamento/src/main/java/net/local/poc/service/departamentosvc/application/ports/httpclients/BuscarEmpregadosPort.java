package net.local.poc.service.departamentosvc.application.ports.httpclients;

import java.util.List;

import net.local.poc.service.departamentosvc.application.dto.EmpregadoDTO;

public interface BuscarEmpregadosPort {
    List<EmpregadoDTO> buscar(Integer codDepartamento);
}
