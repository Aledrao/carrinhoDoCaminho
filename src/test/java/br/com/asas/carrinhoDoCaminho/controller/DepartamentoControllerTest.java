package br.com.asas.carrinhoDoCaminho.controller;

import br.com.asas.carrinhoDoCaminho.CarrinhoDoCaminhoApplication;
import br.com.asas.carrinhoDoCaminho.model.Departamento;
import br.com.asas.carrinhoDoCaminho.service.DepartamentoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CarrinhoDoCaminhoApplication.class)
public class DepartamentoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private DepartamentoService departamentoServiceMock;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void deveriaApresentarTodosDepartamentos() throws Exception {
        List<Departamento> departamentosMock = departamentos();

        when(departamentoServiceMock.listaDepartamentos()).thenReturn(departamentosMock);

        mockMvc.perform(MockMvcRequestBuilders.get("/departamento/listar").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].codigo", is(1))).andExpect(jsonPath("$[0].departamento", is("Eletrônicos")))
            .andExpect(jsonPath("$[1].codigo", is(2))).andExpect(jsonPath("$[1].departamento", is("Matinais")))
        ;

    }

    private List<Departamento> departamentos() {
        Departamento departamentoUm = new Departamento();
        departamentoUm.setCodigo(1);
        departamentoUm.setDepartamento("Eletrônicos");

        Departamento departamentoDois = new Departamento();
        departamentoDois.setCodigo(2);
        departamentoDois.setDepartamento("Matinais");

        List<Departamento> departamentos = new ArrayList<>();
        departamentos.add(departamentoUm);
        departamentos.add(departamentoDois);

        return departamentos;
    }
}
