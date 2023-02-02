package net.local.poc.service.empresasvc.application.domain;

public class Empresa {
    
    private Integer codEmpresa;
    private String empresaNome;
    
    public Empresa() {
    }

    public Empresa(Integer codEmpresa, String empresaNome) {
        this.codEmpresa = codEmpresa;
        this.empresaNome = empresaNome;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getEmpresaNome() {
        return empresaNome;
    }

    public void setEmpresaNome(String empresaNome) {
        this.empresaNome = empresaNome;
    }

}
