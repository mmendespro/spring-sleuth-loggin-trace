package net.local.poc.service.departamentosvc.application.dto;

public class DepartamentoRequest {

    private Integer codEmpresa;
    private String departamentoNome;
    
    public DepartamentoRequest(Integer codEmpresa, String departamentoNome) {
        this.codEmpresa = codEmpresa;
        this.departamentoNome = departamentoNome;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public String getDepartamentoNome() {
        return departamentoNome;
    }

}
