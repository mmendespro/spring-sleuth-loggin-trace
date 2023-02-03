package net.local.poc.service.departamentosvc.adapters.http.client;

import java.util.List;

import org.springframework.stereotype.Component;

import net.local.poc.service.departamentosvc.application.dto.EmpregadoDTO;
import net.local.poc.service.departamentosvc.application.ports.httpclients.BuscarEmpregadosPort;

@Component
public class BuscarEmpregadoImpl implements BuscarEmpregadosPort {

    private final BuscarEmpregadoClient client;

    public BuscarEmpregadoImpl(BuscarEmpregadoClient client) {
        this.client = client;
    }

    @Override
    public List<EmpregadoDTO> buscar(Integer codDepartamento) {
        var result = client.buscar(codDepartamento);
        return result.getBody();
    }
    
}
