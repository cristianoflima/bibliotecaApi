package br.com.obpc.livrariaObpcApi.interfaces;

import br.com.obpc.livrariaObpcApi.dtos.DadosCadastraisDto;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;

public interface ICadastroUsuario {
	
	public ResponseDto cadastrarUsuario(DadosCadastraisDto dados) throws Exception;

}
