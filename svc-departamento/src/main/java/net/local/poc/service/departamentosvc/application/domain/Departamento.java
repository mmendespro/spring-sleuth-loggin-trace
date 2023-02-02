package net.local.poc.service.departamentosvc.application.domain;

public class Departamento {

    private Integer codDepartamento;
    private Integer codEmpresa;
    private String departamentoNome;
    
    public Departamento() {
    }

    public Departamento(Integer codDepartamento, Integer codEmpresa, String departamentoNome) {
        this.codDepartamento = codDepartamento;
        this.codEmpresa = codEmpresa;
        this.departamentoNome = departamentoNome;
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

    public String getDepartamentoNome() {
        return departamentoNome;
    }

    public void setDepartamentoNome(String departamentoNome) {
        this.departamentoNome = departamentoNome;
    }

}
