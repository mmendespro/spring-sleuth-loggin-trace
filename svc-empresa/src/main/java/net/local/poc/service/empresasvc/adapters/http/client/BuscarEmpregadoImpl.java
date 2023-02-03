package net.local.poc.service.empresasvc.adapters.http.client;

import java.util.List;

import org.springframework.stereotype.Component;

import net.local.poc.service.empresasvc.application.dto.EmpregadoDTO;
import net.local.poc.service.empresasvc.application.ports.httpclients.LoadEmpregadoPort;

@Component
public class BuscarEmpregadoImpl implements LoadEmpregadoPort {

    private final BuscarEmpregadoClient client;

    public BuscarEmpregadoImpl(BuscarEmpregadoClient client) {
        this.client = client;
    }

    @Override
    public List<EmpregadoDTO> loadEmpregados(Integer codEmpresa) {
        var result = client.buscar(codEmpresa);
        return result.getBody();
    }
    
}
