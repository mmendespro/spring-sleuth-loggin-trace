package net.local.poc.service.empregadosvc.application.services;

import java.util.List;
import java.util.stream.Collectors;

import net.local.poc.service.empregadosvc.application.domain.Empregado;
import net.local.poc.service.empregadosvc.application.dto.EmpregadoRequest;
import net.local.poc.service.empregadosvc.application.dto.EmpregadoResponse;
import net.local.poc.service.empregadosvc.application.ports.persistence.LoadEmpregadoPort;
import net.local.poc.service.empregadosvc.application.ports.persistence.SaveEmpregadoPort;
import net.local.poc.service.empregadosvc.application.ports.usecases.CriarEmpregado;
import net.local.poc.service.empregadosvc.application.ports.usecases.ListarPorDepartamento;
import net.local.poc.service.empregadosvc.application.ports.usecases.ListarPorEmpresa;
import net.local.poc.service.empregadosvc.application.ports.usecases.ListarTodos;

public class EmpregadoService implements CriarEmpregado, ListarTodos, ListarPorDepartamento, ListarPorEmpresa {
    
    private final LoadEmpregadoPort loadEmpregadoPort;
    private final SaveEmpregadoPort saveEmpregadoPort;
    
    public EmpregadoService(LoadEmpregadoPort loadEmpregadoPort, SaveEmpregadoPort saveEmpregadoPort) {
        this.loadEmpregadoPort = loadEmpregadoPort;
        this.saveEmpregadoPort = saveEmpregadoPort;
    }

    @Override
    public void criar(EmpregadoRequest empregadoRequest) {
        saveEmpregadoPort.salvar(new Empregado(loadEmpregadoPort.loadAll().size() + 1, empregadoRequest.getCodDepartamento(), empregadoRequest.getCodEmpresa(), empregadoRequest.getEmpregadoNome()));
    }

    @Override
    public List<EmpregadoResponse> listar() {
        return loadEmpregadoPort.loadAll().stream().map(this::maptoResponse).collect(Collectors.toList());
    }

    @Override
    public List<EmpregadoResponse> listarDepartamento(Integer codDepartamento) {
        return loadEmpregadoPort.loadByCodDepartamento(codDepartamento).stream().map(this::maptoResponse).collect(Collectors.toList());
    }

    @Override
    public List<EmpregadoResponse> listarEmpresa(Integer codEmpresa) {
        return loadEmpregadoPort.loadByCodEmpresa(codEmpresa).stream().map(this::maptoResponse).collect(Collectors.toList());
    }

    private EmpregadoResponse maptoResponse(Empregado emp) {
        return new EmpregadoResponse(emp.getCodEmpregado(), emp.getCodDepartamento(), emp.getCodEmpresa(), emp.getEmpregadoNome());
    }
}
