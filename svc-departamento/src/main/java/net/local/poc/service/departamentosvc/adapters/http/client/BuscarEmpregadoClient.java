package net.local.poc.service.departamentosvc.adapters.http.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.local.poc.service.departamentosvc.application.dto.EmpregadoDTO;

@FeignClient(name = "buscarEmpregado", url = "http://empregado-service-jvm:8082")
public interface BuscarEmpregadoClient {
    
    @GetMapping( "/empregados/departamento/{codDepartamento}")
    ResponseEntity<List<EmpregadoDTO>> buscar(@PathVariable Integer codDepartamento);
}
