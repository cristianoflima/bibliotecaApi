package br.com.obpc.livrariaObpcApi.interfaces;

import br.com.obpc.livrariaObpcApi.models.Usuario;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;

public interface IUsuarioDao {
	
	public ResponseDto buscarTodos() throws Exception;
	public ResponseDto salvarUsuario(Usuario usuario) throws Exception;

}
