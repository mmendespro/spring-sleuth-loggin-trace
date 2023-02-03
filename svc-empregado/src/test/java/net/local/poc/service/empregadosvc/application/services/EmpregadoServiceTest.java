package net.local.poc.service.empregadosvc.application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.local.poc.service.empregadosvc.application.domain.Empregado;
import net.local.poc.service.empregadosvc.application.dto.EmpregadoResponse;
import net.local.poc.service.empregadosvc.application.ports.persistence.LoadEmpregadoPort;
import net.local.poc.service.empregadosvc.application.ports.persistence.SaveEmpregadoPort;

@ExtendWith(MockitoExtension.class)
public class EmpregadoServiceTest {
 
    @Mock
    private LoadEmpregadoPort loadEmpregadoPort;
    
    @Mock
    private SaveEmpregadoPort saveEmpregadoPort;

    @InjectMocks
    private EmpregadoService empregadoServiceSUT;

    @Test
    @DisplayName(("Should return a list of all empregados"))
    void testListar() {
        // Arrange
        when(loadEmpregadoPort.loadAll()).thenReturn(getListaEmpregados());
        // Act
        List<EmpregadoResponse> result = empregadoServiceSUT.listar();
        // Assert
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName(("Should return a list of empregados by codDepartamento"))
    void testlistarDepartamento() {
        // Arrange
        when(loadEmpregadoPort.loadByCodDepartamento(anyInt())).thenReturn(getListaEmpregadosPorDepartamento());
        // Act
        List<EmpregadoResponse> result = empregadoServiceSUT.listarDepartamento(1);
        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    private List<Empregado> getListaEmpregados() {
        List<Empregado> lista = new ArrayList<>();
        lista.add(new Empregado(1,1,1,"A")); 
        lista.add(new Empregado(2,1,1,"B")); 
        lista.add(new Empregado(3,2,1,"C"));
        return lista; 
    }

    private List<Empregado> getListaEmpregadosPorDepartamento() {
        return getListaEmpregados().stream()
                                   .filter(emp -> emp.getCodDepartamento().equals(1))
                                   .collect(Collectors.toList());
    }
}
