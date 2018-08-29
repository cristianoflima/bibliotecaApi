package br.com.obpc.livrariaObpcApi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.obpc.livrariaObpcApi.models.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer>{

}
