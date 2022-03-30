package br.com.estoque.services.impl;

import br.com.estoque.model.Estoque;
import br.com.estoque.repositories.EstoqueRepository;
import br.com.estoque.services.EstoqueService;
import br.com.estoque.services.exceptions.DataIntegratyViolationException;
import br.com.estoque.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    @Override
    public Estoque buscarPorSku(String sku) {
        Optional<Estoque> obj = this.repository.findBySku(sku);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Estoque não encontrado! Sku: " + sku + ", Tipo: " + Estoque.class.getName()));
    }

    @Override
    public List<Estoque> buscarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Estoque inserir(Estoque obj) {
        Optional<Estoque> sku = repository.findBySku(obj.getSku());
        if (sku.isPresent()) {
            throw new DataIntegratyViolationException("Sku já existe");
        }
        Estoque estoque = new Estoque();
        if (obj.getQuantidade() <= 0) {
            estoque.setEmEstoque(false);
            estoque.setSku(obj.getSku());
            estoque.setQuantidade(obj.getQuantidade());
        }
        else {
            estoque.setEmEstoque(true);
            estoque.setSku(obj.getSku());
            estoque.setQuantidade(obj.getQuantidade());
        }
        return this.repository.save(estoque);
    }

    @Override
    public void deletar(String sku) {
        Estoque produto = buscarPorSku(sku);
        this.repository.delete(produto);
    }
}
