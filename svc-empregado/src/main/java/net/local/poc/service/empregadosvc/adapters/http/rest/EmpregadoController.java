package net.local.poc.service.empregadosvc.adapters.http.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.service.empregadosvc.application.dto.EmpregadoRequest;
import net.local.poc.service.empregadosvc.application.dto.EmpregadoResponse;
import net.local.poc.service.empregadosvc.application.ports.usecases.CriarEmpregado;
import net.local.poc.service.empregadosvc.application.ports.usecases.ListarPorDepartamento;
import net.local.poc.service.empregadosvc.application.ports.usecases.ListarPorEmpresa;
import net.local.poc.service.empregadosvc.application.ports.usecases.ListarTodos;

@RestController
@RequestMapping("empregados")
public class EmpregadoController {
    
    private final CriarEmpregado criarEmpregado;
    private final ListarTodos listarTodos;
    private final ListarPorEmpresa listarPorEmpresa;
    private final ListarPorDepartamento listarPorDepartamento;

    public EmpregadoController(CriarEmpregado criarEmpregado, ListarTodos listarTodos,
            ListarPorEmpresa listarPorEmpresa, ListarPorDepartamento listarPorDepartamento) {
        this.criarEmpregado = criarEmpregado;
        this.listarTodos = listarTodos;
        this.listarPorEmpresa = listarPorEmpresa;
        this.listarPorDepartamento = listarPorDepartamento;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody EmpregadoRequest request) {
        criarEmpregado.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<EmpregadoResponse>> listar() {
        return ResponseEntity.ok(listarTodos.listar());
    }

    @GetMapping(path = "/empresa/{codEmpresa}")
    public ResponseEntity<List<EmpregadoResponse>> listarEmpresa(@PathVariable(name = "codEmpresa") Integer codEmpresa) {
        return ResponseEntity.ok(listarPorEmpresa.listarEmpresa(codEmpresa));
    }

    @GetMapping(path = "/departamento/{codDepartamento}")
    public ResponseEntity<List<EmpregadoResponse>> listarDepartamento(@PathVariable(name = "codDepartamento") Integer codDepartamento) {
        return ResponseEntity.ok(listarPorDepartamento.listarDepartamento(codDepartamento));
    }
}
