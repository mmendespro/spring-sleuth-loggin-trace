package net.local.poc.service.departamentosvc.application.dto;

import java.util.List;

public class DepartamentoResponse {
    
    private Integer codDepartamento;
    private Integer codEmpresa;
    private String departamentoNome;
    private List<EmpregadoDTO> empregados;

    public DepartamentoResponse(Integer codDepartamento, Integer codEmpresa, String departamentoNome,
            List<EmpregadoDTO> empregados) {
        this.codDepartamento = codDepartamento;
        this.codEmpresa = codEmpresa;
        this.departamentoNome = departamentoNome;
        this.empregados = empregados;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public String getDepartamentoNome() {
        return departamentoNome;
    }

    public List<EmpregadoDTO> getEmpregados() {
        return empregados;
    }
    
}
