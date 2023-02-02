package net.local.poc.service.empresasvc.application.dto;

import java.util.List;

public class EmpresaResponse {
    
    private Integer codEmpresa;
    private String empresaNome;
    private List<DepartamentoDTO> departamentos;
    private List<EmpregadoDTO> empregados;

    public EmpresaResponse(Integer codEmpresa, String empresaNome, List<DepartamentoDTO> departamentos,
            List<EmpregadoDTO> empregados) {
        this.codEmpresa = codEmpresa;
        this.empresaNome = empresaNome;
        this.departamentos = departamentos;
        this.empregados = empregados;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public String getEmpresaNome() {
        return empresaNome;
    }

    public List<DepartamentoDTO> getDepartamentos() {
        return departamentos;
    }

    public List<EmpregadoDTO> getEmpregados() {
        return empregados;
    }

    
}
