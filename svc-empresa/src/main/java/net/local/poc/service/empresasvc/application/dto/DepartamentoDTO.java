package net.local.poc.service.empresasvc.application.dto;

import java.util.List;

public class DepartamentoDTO {
    
    private Integer codDepartamento;
    private String departamentoNome;
    private List<EmpregadoDTO> empregados;

    public DepartamentoDTO(Integer codDepartamento, String departamentoNome, List<EmpregadoDTO> empregados) {
        this.codDepartamento = codDepartamento;
        this.departamentoNome = departamentoNome;
        this.empregados = empregados;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public String getDepartamentoNome() {
        return departamentoNome;
    }

    public List<EmpregadoDTO> getEmpregados() {
        return empregados;
    }
    
}
