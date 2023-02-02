package net.local.poc.service.empresasvc.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import net.local.poc.service.empresasvc.application.domain.Empresa;
import net.local.poc.service.empresasvc.application.dto.DepartamentoDTO;
import net.local.poc.service.empresasvc.application.dto.EmpregadoDTO;
import net.local.poc.service.empresasvc.application.dto.EmpresaRequest;
import net.local.poc.service.empresasvc.application.dto.EmpresaResponse;
import net.local.poc.service.empresasvc.application.ports.persistence.LoadDepartamentoPort;
import net.local.poc.service.empresasvc.application.ports.persistence.LoadEmpregadoPort;
import net.local.poc.service.empresasvc.application.ports.persistence.LoadEmpresaPort;
import net.local.poc.service.empresasvc.application.ports.persistence.SaveEmpresaPort;
import net.local.poc.service.empresasvc.application.ports.usecases.CriarEmpresa;
import net.local.poc.service.empresasvc.application.ports.usecases.ListarEmpresaComDepartamentos;
import net.local.poc.service.empresasvc.application.ports.usecases.ListarEmpresaComEmpregados;
import net.local.poc.service.empresasvc.application.ports.usecases.ListarTodos;

public class EmpresaService implements CriarEmpresa, ListarTodos, ListarEmpresaComEmpregados, ListarEmpresaComDepartamentos {
    
    private final LoadEmpregadoPort loadEmpregadoPort;
    private final LoadDepartamentoPort loadDepartamentoPort;
    private final LoadEmpresaPort loadEmpresaPort;
    private final SaveEmpresaPort saveEmpresaPort;

    public EmpresaService(LoadEmpregadoPort loadEmpregadoPort, LoadDepartamentoPort loadDepartamentoPort,
            LoadEmpresaPort loadEmpresaPort, SaveEmpresaPort saveEmpresaPort) {
        this.loadEmpregadoPort = loadEmpregadoPort;
        this.loadDepartamentoPort = loadDepartamentoPort;
        this.loadEmpresaPort = loadEmpresaPort;
        this.saveEmpresaPort = saveEmpresaPort;
    }

    @Override
    public void criar(EmpresaRequest request) {
        saveEmpresaPort.save(new Empresa(loadEmpresaPort.loadAll().size() + 1, request.getEmpresaNome()));
    }

    @Override
    public List<EmpresaResponse> listar() {
        return loadEmpresaPort.loadAll().stream().map(this::maptoResponse).collect(Collectors.toList());
    }

    @Override
    public EmpresaResponse listarEmpresaComEmpregados(Integer codEmpresa) {
        Empresa emp = loadEmpresaPort.loadByCodEmpresa(codEmpresa).orElseThrow(NoSuchElementException::new);
        var result = maptoResponse(emp, new ArrayList<>(), loadEmpregadoPort.loadEmpregados(codEmpresa));
        return result;
    }

    @Override
    public EmpresaResponse listarEmpresaComDepartamento(Integer codEmpresa) {
        Empresa emp = loadEmpresaPort.loadByCodEmpresa(codEmpresa).orElseThrow(NoSuchElementException::new);
        var result = maptoResponse(emp, loadDepartamentoPort.loadDepartamentos(codEmpresa), new ArrayList<>());
        return result;
    }

    @Override
    public EmpresaResponse listarEmpresaComDepartamentoEmpregado(Integer codEmpresa) {
        Empresa emp = loadEmpresaPort.loadByCodEmpresa(codEmpresa).orElseThrow(NoSuchElementException::new);
        var result = maptoResponse(emp, loadDepartamentoPort.loadDepartamentosEmpregados(codEmpresa), new ArrayList<>());
        return result;
    }

    private EmpresaResponse maptoResponse(Empresa empresa) {
        return new EmpresaResponse(empresa.getCodEmpresa(), empresa.getEmpresaNome(), new ArrayList<>(), new ArrayList<>());
    }

    private EmpresaResponse maptoResponse(Empresa empresa, List<DepartamentoDTO> departamentos, List<EmpregadoDTO> empregados) {
        return new EmpresaResponse(empresa.getCodEmpresa(), empresa.getEmpresaNome(), departamentos, empregados);
    }
}
