package br.com.obpc.livrariaObpcApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.obpc.livrariaObpcApi.interfaces.ILivroDao;
import br.com.obpc.livrariaObpcApi.models.Livro;
import br.com.obpc.livrariaObpcApi.reponse.ResponseBuilder;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;


/**
 * Controller para serviços relacionados a persistência/consulta de livros
 * http://localhost:8080//biblioteca/livro
 * @author Cristiano F. Lima
 *
 */
@RestController
@RequestMapping("/livro")
public class LivrosController {
	
	@Autowired
	ILivroDao dao;
	
	/**
	 * Metodo tipo GET, retorna todos os livros cadastrados
	 * @return ResponseDto
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDto buscarTodosLivros() {
		try {
			return dao.buscarTodosLivros();
		} catch (Exception e) {
			return new ResponseBuilder().semSucesso(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem("Erro ao buscar todos os livros, ERROR_MSG: "+e.getMessage()).build();
		}
	}
	
	
	/**
	 * Metodo tipo POST, para cadastro de livros.
	 * @return ResponseDto
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDto save(@RequestBody Livro livro) {
		try {
			return dao.salvar(livro) ;
		} catch (Exception e) {
			return new ResponseBuilder().semSucesso(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem("Erro ao salvar livro, ERROR_MSG: "+e.getMessage()).comItem(livro).build();
		}
	}
	
	/**
	 * Metodo tipo GET, para consulta de livro por ID
	 * @param ID do livro a ser consultado
	 * @return ResponseDto
	 */
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDto buscarLivro(@PathVariable("id") String id) {
		try {
			return dao.buscarLivroPorId(Integer.valueOf(id)) ;
		} catch (Exception e) {
			return new ResponseBuilder().semSucesso(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem("Erro ao buscar todos os livros com ID: "+id+", ERROR_MSG: "+e.getMessage()).build();
		}
	}
	
	/**
	 * Metodo tipo POST, para consulta de livros a partir de um filtro.
	 * @param Objeto do tipo Livro
	 * @return ResponseDto
	 */
	@PostMapping(path="/titulo", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseDto buscarLivroComFiltro(@RequestBody Livro livro) {
		try {
				return dao.buscarLivroComFiltro(livro) ;
		} catch (Exception e) {
			return new ResponseBuilder().semSucesso(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem("Erro ao buscar livros, ERROR_MSG: "+e.getMessage()).build();
		}
	}

}
