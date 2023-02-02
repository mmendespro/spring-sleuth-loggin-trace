package net.local.poc.service.empregadosvc.application.dto;

public class EmpregadoRequest {
    
    private Integer codDepartamento;
    private Integer codEmpresa;
    private String empregadoNome;
    
    public EmpregadoRequest(Integer codDepartamento, Integer codEmpresa, String empregadoNome) {
        this.codDepartamento = codDepartamento;
        this.codEmpresa = codEmpresa;
        this.empregadoNome = empregadoNome;
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
