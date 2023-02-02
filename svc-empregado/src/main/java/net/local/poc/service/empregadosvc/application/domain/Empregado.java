package net.local.poc.service.empregadosvc.application.domain;

public class Empregado {
    
    private Integer codEmpregado;
    private Integer codDepartamento;
    private Integer codEmpresa;
    private String empregadoNome;

    public Empregado() {
    }
    
    public Empregado(Integer codEmpregado, Integer codDepartamento, Integer codEmpresa, String empregadoNome) {
        this.codEmpregado = codEmpregado;
        this.codDepartamento = codDepartamento;
        this.codEmpresa = codEmpresa;
        this.empregadoNome = empregadoNome;
    }

    public Integer getCodEmpregado() {
        return codEmpregado;
    }

    public void setCodEmpregado(Integer codEmpregado) {
        this.codEmpregado = codEmpregado;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getEmpregadoNome() {
        return empregadoNome;
    }

    public void setEmpregadoNome(String empregadoNome) {
        this.empregadoNome = empregadoNome;
    }
    
}
