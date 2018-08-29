package br.com.obpc.livrariaObpcApi.interfaces;

import br.com.obpc.livrariaObpcApi.models.Livro;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;

public interface ILivroDao {
	
	public ResponseDto salvar(Livro livro) throws Exception;
	public ResponseDto buscarTodosLivros() throws Exception;
	public ResponseDto buscarLivroPorId(Integer id) throws Exception;
	public ResponseDto buscarLivroComFiltro(Livro livro) throws Exception;

}
