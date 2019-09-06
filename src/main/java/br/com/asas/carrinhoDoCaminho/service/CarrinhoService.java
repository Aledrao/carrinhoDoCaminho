package br.com.asas.carrinhoDoCaminho.service;

import br.com.asas.carrinhoDoCaminho.model.Carrinho;
import br.com.asas.carrinhoDoCaminho.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho salvar(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public List<Carrinho> listarCarrinhos(Long codigo) {
        return carrinhoRepository.findAll();
    }

    public Carrinho buscarPorCodigo(Long codigo) {
        return carrinhoRepository.getOne(codigo);
    }

    public Carrinho atualizar(Carrinho carrinho) {
        return carrinhoRepository.saveAndFlush(carrinho);
    }

    public void excluir(Long codigo) {
        carrinhoRepository.deleteById(codigo);
    }


}
