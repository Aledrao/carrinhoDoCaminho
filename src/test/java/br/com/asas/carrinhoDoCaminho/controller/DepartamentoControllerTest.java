package br.com.asas.carrinhoDoCaminho.controller;

import br.com.asas.carrinhoDoCaminho.CarrinhoDoCaminhoApplication;
import br.com.asas.carrinhoDoCaminho.model.Departamento;
import br.com.asas.carrinhoDoCaminho.service.DepartamentoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    public void naoDeveriaRetornarUmaListaDepartamento() throws Exception {

        when(departamentoServiceMock.listaDepartamentos()).thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/departamento/listar").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)))
        ;
    }

    @Test
    public void deveriaSalvarDepartamento() throws Exception {
        Departamento departamentoNovo = new Departamento();
        departamentoNovo.setDepartamento("Congelados");

        when(departamentoServiceMock.salvar(any(Departamento.class))).thenReturn(departamento());

        mockMvc.perform(MockMvcRequestBuilders.post("/departamento/salvar").contentType(MediaType.APPLICATION_JSON)
            .content("{\"departamento\": \"Congelados\"}"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.codigo", is(1)))
            .andExpect(jsonPath("$.departamento", is("Congelados")))
        ;

        ArgumentCaptor<Departamento> departamentoCaptor = ArgumentCaptor.forClass(Departamento.class);
        verify(departamentoServiceMock, times(1)).salvar(departamentoCaptor.capture());
        verifyNoMoreInteractions(departamentoServiceMock);

        assertNull(departamentoNovo.getCodigo());
        assertThat(departamentoNovo.getDepartamento(), is("Congelados"));
    }

    @Test
    public void deveriaAtualizarDepartamento() throws Exception {
        Departamento departamento = departamento();

        when(departamentoServiceMock.atualiza(any(Departamento.class))).thenReturn(departamento);

        mockMvc.perform(put("/departamento/atualizar")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"codigo\": 1, \"departamento\": \"Bebidas\" }"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("$.codigo", is(1)))
            .andExpect(jsonPath("$.departamento", is("Congelados")))
        ;

        ArgumentCaptor<Departamento> departamentoCaptor = ArgumentCaptor.forClass(Departamento.class);
        verify(departamentoServiceMock, times(1)).atualiza(departamentoCaptor.capture());
        verifyNoMoreInteractions(departamentoServiceMock);

        assertThat(departamento.getCodigo(), is(1));
        assertThat(departamento.getDepartamento(), is("Congelados"));
    }

    private Departamento departamento() {
        Departamento departamento = new Departamento();
        departamento.setCodigo(1);
        departamento.setDepartamento("Congelados");

        return departamento;
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
