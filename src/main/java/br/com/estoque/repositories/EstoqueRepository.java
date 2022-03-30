package br.com.estoque.repositories;

import br.com.estoque.model.Estoque;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends MongoRepository<Estoque, String> {

    Optional<Estoque> findBySku(String sku);
}
