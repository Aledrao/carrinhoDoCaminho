package br.com.asas.carrinhoDoCaminho.service;

import br.com.asas.carrinhoDoCaminho.model.Item;
import br.com.asas.carrinhoDoCaminho.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public Item buscarItemPorCodigo(Long codigo) {
        return itemRepository.findByCodigo(codigo);
    }

    public Item salvarItem(Item item) {
        return itemRepository.save(item);
    }
}
