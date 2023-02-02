package net.local.poc.service.empregadosvc.application.dto;

public class EmpregadoResponse {
    
    private Integer codEmpregado;
    private Integer codDepartamento;
    private Integer codEmpresa;
    private String empregadoNome;
    
    public EmpregadoResponse(Integer codEmpregado, Integer codDepartamento, Integer codEmpresa, String empregadoNome) {
        this.codEmpregado = codEmpregado;
        this.codDepartamento = codDepartamento;
        this.codEmpresa = codEmpresa;
        this.empregadoNome = empregadoNome;
    }

    public Integer getCodEmpregado() {
        return codEmpregado;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public String getEmpregadoNome() {
        return empregadoNome;
    }

}
