package net.local.poc.service.departamentosvc.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import net.local.poc.service.departamentosvc.adapters.http.client.BuscarEmpregadoClient;
import net.local.poc.service.departamentosvc.application.dto.EmpregadoDTO;
import net.local.poc.service.departamentosvc.application.ports.persistence.BuscarEmpregadosPort;

@Component
public class BuscarEmpregadoAdapter implements BuscarEmpregadosPort {

    private final BuscarEmpregadoClient client;

    public BuscarEmpregadoAdapter(BuscarEmpregadoClient client) {
        this.client = client;
    }

    @Override
    public List<EmpregadoDTO> buscar(Integer codDepartamento) {
        var result = client.buscar(codDepartamento);
        return result.getBody();
    }
    
}
