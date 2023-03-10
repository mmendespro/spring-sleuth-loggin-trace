package net.local.poc.service.empresasvc.adapters.http.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.local.poc.service.empresasvc.application.dto.DepartamentoDTO;

@FeignClient(name = "buscarDepartamento", url = "http://departamento-service-jvm:8081")
public interface BuscarDepartamentoClient {
    
    @GetMapping( "/departamentos/empresa/{codEmpresa}")
    ResponseEntity<List<DepartamentoDTO>> buscar(@PathVariable Integer codEmpresa);

    @GetMapping(path = "/departamentos/empresa/{codEmpresa}/empregados")
    public ResponseEntity<List<DepartamentoDTO>> buscarComEmpregados(@PathVariable(name = "codEmpresa") Integer codEmpresa);
}
