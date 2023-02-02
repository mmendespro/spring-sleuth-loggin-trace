package net.local.poc.service.empresasvc.application.dto;

public class EmpresaRequest {

    private String empresaNome;

    public EmpresaRequest(String empresaNome) {
        this.empresaNome = empresaNome;
    }

    public String getEmpresaNome() {
        return empresaNome;
    }

}
