package net.local.poc.service.empresasvc.application.dto;

public class EmpregadoDTO {
    
    private Integer codEmpregado;
    private String empregadoNome;
    
    public EmpregadoDTO(Integer codEmpregado, String empregadoNome) {
        this.codEmpregado = codEmpregado;
        this.empregadoNome = empregadoNome;
    }

    public Integer getCodEmpregado() {
        return codEmpregado;
    }

    public String getEmpregadoNome() {
        return empregadoNome;
    }
    
}
