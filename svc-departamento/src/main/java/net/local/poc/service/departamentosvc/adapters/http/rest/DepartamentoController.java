package net.local.poc.service.departamentosvc.adapters.http.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.service.departamentosvc.application.dto.DepartamentoRequest;
import net.local.poc.service.departamentosvc.application.dto.DepartamentoResponse;
import net.local.poc.service.departamentosvc.application.ports.usecases.CriarDepartamento;
import net.local.poc.service.departamentosvc.application.ports.usecases.ListarPorEmpresa;
import net.local.poc.service.departamentosvc.application.ports.usecases.ListarPorEmpresaComEmpregados;
import net.local.poc.service.departamentosvc.application.ports.usecases.ListarTodos;

@RestController
@RequestMapping("departamentos")
public class DepartamentoController {
    
    private final CriarDepartamento criarDepartamento;
    private final ListarTodos listarTodos;
    private final ListarPorEmpresa listarPorEmpresa;
    private final ListarPorEmpresaComEmpregados listarPorEmpresaComEmpregados;

    public DepartamentoController(CriarDepartamento criarDepartamento, ListarTodos listarTodos,
            ListarPorEmpresa listarPorEmpresa, ListarPorEmpresaComEmpregados listarPorEmpresaComEmpregados) {
        this.criarDepartamento = criarDepartamento;
        this.listarTodos = listarTodos;
        this.listarPorEmpresa = listarPorEmpresa;
        this.listarPorEmpresaComEmpregados = listarPorEmpresaComEmpregados;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody DepartamentoRequest request) {
        criarDepartamento.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> listar() {
        return ResponseEntity.ok(listarTodos.listarTodos());
    }

    @GetMapping(path = "/empresa/{codEmpresa}")
    public ResponseEntity<List<DepartamentoResponse>> listarPorEmpresa(@PathVariable(name = "codEmpresa") Integer codEmpresa) {
        return ResponseEntity.ok(listarPorEmpresa.listarPorEmpresa(codEmpresa));
    }

    @GetMapping(path = "/empresa/{codEmpresa}/empregados")
    public ResponseEntity<List<DepartamentoResponse>> listarPorEmpresaEmpregados(@PathVariable(name = "codEmpresa") Integer codEmpresa) {
        return ResponseEntity.ok(listarPorEmpresaComEmpregados.listarPorEmpresaComEmpregados(codEmpresa));
    }
}
