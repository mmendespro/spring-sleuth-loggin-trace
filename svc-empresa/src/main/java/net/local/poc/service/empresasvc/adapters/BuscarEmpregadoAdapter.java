package net.local.poc.service.empresasvc.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import net.local.poc.service.empresasvc.adapters.http.client.BuscarEmpregadoClient;
import net.local.poc.service.empresasvc.application.dto.EmpregadoDTO;
import net.local.poc.service.empresasvc.application.ports.persistence.LoadEmpregadoPort;

@Component
public class BuscarEmpregadoAdapter implements LoadEmpregadoPort {

    private final BuscarEmpregadoClient client;

    public BuscarEmpregadoAdapter(BuscarEmpregadoClient client) {
        this.client = client;
    }

    @Override
    public List<EmpregadoDTO> loadEmpregados(Integer codEmpresa) {
        var result = client.buscar(codEmpresa);
        return result.getBody();
    }
    
}
