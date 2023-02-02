package net.local.poc.service.empresasvc.adapters.http.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.service.empresasvc.application.dto.EmpresaRequest;
import net.local.poc.service.empresasvc.application.dto.EmpresaResponse;
import net.local.poc.service.empresasvc.application.ports.usecases.CriarEmpresa;
import net.local.poc.service.empresasvc.application.ports.usecases.ListarEmpresaComDepartamentos;
import net.local.poc.service.empresasvc.application.ports.usecases.ListarEmpresaComEmpregados;
import net.local.poc.service.empresasvc.application.ports.usecases.ListarTodos;

@RestController
@RequestMapping("empresas")
public class EmpresaController {
    
    private final CriarEmpresa criarEmpresa;
    private final ListarTodos listarTodos;
    private final ListarEmpresaComEmpregados listarEmpresaComEmpregados;
    private final ListarEmpresaComDepartamentos listarEmpresaComDepartamentos;

    public EmpresaController(CriarEmpresa criarEmpresa, ListarTodos listarTodos,
            ListarEmpresaComEmpregados listarEmpresaComEmpregados,
            ListarEmpresaComDepartamentos listarEmpresaComDepartamentos) {
        this.criarEmpresa = criarEmpresa;
        this.listarTodos = listarTodos;
        this.listarEmpresaComEmpregados = listarEmpresaComEmpregados;
        this.listarEmpresaComDepartamentos = listarEmpresaComDepartamentos;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody EmpresaRequest request) {
        criarEmpresa.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> listar() {
        return ResponseEntity.ok(listarTodos.listar());
    }

    @GetMapping(path = "/{codEmpresa}/empregados")
    public ResponseEntity<EmpresaResponse> listarEmpregadosPorEmpresa(@PathVariable(name = "codEmpresa") Integer codEmpresa) {
        return ResponseEntity.ok(listarEmpresaComEmpregados.listarEmpresaComEmpregados(codEmpresa));
    }

    @GetMapping(path = "/{codEmpresa}/departamentos")
    public ResponseEntity<EmpresaResponse> listarDepartamentosPorEmpresa(@PathVariable(name = "codEmpresa") Integer codEmpresa) {
        return ResponseEntity.ok(listarEmpresaComDepartamentos.listarEmpresaComDepartamento(codEmpresa));
    }

    @GetMapping(path = "/{codEmpresa}/departamentos/empregados")
    public ResponseEntity<EmpresaResponse> listarDepartamentosComEmpregadosPorEmpresa(@PathVariable(name = "codEmpresa") Integer codEmpresa) {
        return ResponseEntity.ok(listarEmpresaComDepartamentos.listarEmpresaComDepartamentoEmpregado(codEmpresa));
    }
}
