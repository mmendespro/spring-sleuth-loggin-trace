package net.local.poc.service.empresasvc.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import net.local.poc.service.empresasvc.adapters.http.client.BuscarDepartamentoClient;
import net.local.poc.service.empresasvc.application.dto.DepartamentoDTO;
import net.local.poc.service.empresasvc.application.ports.persistence.LoadDepartamentoPort;

@Component
public class BuscarDepartamentoAdapter implements LoadDepartamentoPort {

    private final BuscarDepartamentoClient client;

    public BuscarDepartamentoAdapter(BuscarDepartamentoClient client) {
        this.client = client;
    }

    @Override
    public List<DepartamentoDTO> loadDepartamentos(Integer codEmpresa) {
        var result = client.buscar(codEmpresa);
        return result.getBody();
    }

    @Override
    public List<DepartamentoDTO> loadDepartamentosEmpregados(Integer codEmpresa) {
        var result = client.buscarComEmpregados(codEmpresa);
        return result.getBody();
    }

}
