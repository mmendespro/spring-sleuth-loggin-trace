package net.local.poc.service.departamentosvc.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.local.poc.service.departamentosvc.application.domain.Departamento;
import net.local.poc.service.departamentosvc.application.dto.DepartamentoRequest;
import net.local.poc.service.departamentosvc.application.dto.DepartamentoResponse;
import net.local.poc.service.departamentosvc.application.dto.EmpregadoDTO;
import net.local.poc.service.departamentosvc.application.ports.persistence.BuscarEmpregadosPort;
import net.local.poc.service.departamentosvc.application.ports.persistence.LoadDepartamentoPort;
import net.local.poc.service.departamentosvc.application.ports.persistence.SaveDepartamentoPort;
import net.local.poc.service.departamentosvc.application.ports.usecases.CriarDepartamento;
import net.local.poc.service.departamentosvc.application.ports.usecases.ListarPorEmpresa;
import net.local.poc.service.departamentosvc.application.ports.usecases.ListarPorEmpresaComEmpregados;
import net.local.poc.service.departamentosvc.application.ports.usecases.ListarTodos;

public class DepartamentoService implements CriarDepartamento, ListarTodos, ListarPorEmpresa, ListarPorEmpresaComEmpregados {

    private final BuscarEmpregadosPort buscarEmpregadosPort;
    private final LoadDepartamentoPort loadDepartamentoPort;
    private final SaveDepartamentoPort saveDepartamentoPort;

    public DepartamentoService(BuscarEmpregadosPort buscarEmpregadosPort, LoadDepartamentoPort loadDepartamentoPort,
            SaveDepartamentoPort saveDepartamentoPort) {
        this.buscarEmpregadosPort = buscarEmpregadosPort;
        this.loadDepartamentoPort = loadDepartamentoPort;
        this.saveDepartamentoPort = saveDepartamentoPort;
    }

    @Override
    public void criar(DepartamentoRequest request) {
        saveDepartamentoPort.salvar(new Departamento(loadDepartamentoPort.loadAll().size()+1,request.getCodEmpresa(), request.getDepartamentoNome()));
    }

    @Override
    public List<DepartamentoResponse> listarTodos() {
        return loadDepartamentoPort.loadAll()
                                   .stream()
                                   .map(this::maptoResponse)
                                   .collect(Collectors.toList());
    }

    @Override
    public List<DepartamentoResponse> listarPorEmpresa(Integer codEmpresa) {
        return loadDepartamentoPort.loadAll()
                                   .stream()
                                   .filter(dep -> dep.getCodEmpresa().equals(codEmpresa))
                                   .map(this::maptoResponse)
                                   .collect(Collectors.toList());
    }

    @Override
    public List<DepartamentoResponse> listarPorEmpresaComEmpregados(Integer codEmpresa) {
        return loadDepartamentoPort.loadAll()
                                   .stream()
                                   .filter(dep -> dep.getCodEmpresa().equals(codEmpresa))
                                   .map(dep -> maptoResponse(dep, buscarEmpregadosPort.buscar(dep.getCodDepartamento())))
                                   .collect(Collectors.toList());
    }

    private DepartamentoResponse maptoResponse(Departamento dep) {
        return new DepartamentoResponse(dep.getCodDepartamento(), dep.getCodEmpresa(), dep.getDepartamentoNome(), new ArrayList<>());
    }

    private DepartamentoResponse maptoResponse(Departamento dep, List<EmpregadoDTO> empregados) {
        return new DepartamentoResponse(dep.getCodDepartamento(), dep.getCodEmpresa(), dep.getDepartamentoNome(), empregados);
    }
}
