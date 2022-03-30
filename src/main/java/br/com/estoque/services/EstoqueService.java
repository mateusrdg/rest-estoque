package br.com.estoque.services;

import br.com.estoque.model.Estoque;

import java.util.List;

public interface EstoqueService {

    public Estoque buscarPorSku(String sku);

    public List<Estoque> buscarTodos();

    public Estoque inserir(Estoque produto);

    public void deletar(String id);
}
