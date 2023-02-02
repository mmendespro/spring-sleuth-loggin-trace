package net.local.poc.service.departamentosvc.application.dto;

public class EmpregadoDTO {
    
    private Integer codEmpregado;
    private Integer codEmpresa;
    private String empregadoNome;

    public EmpregadoDTO(Integer codEmpregado, Integer codEmpresa, String empregadoNome) {
        this.codEmpregado = codEmpregado;
        this.codEmpresa = codEmpresa;
        this.empregadoNome = empregadoNome;
    }

    public Integer getCodEmpregado() {
        return codEmpregado;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public String getEmpregadoNome() {
        return empregadoNome;
    }

}
