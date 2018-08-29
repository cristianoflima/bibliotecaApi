package br.com.obpc.livrariaObpcApi.interfaces;

import br.com.obpc.livrariaObpcApi.models.DadosPessoais;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;

public interface IDadosPessoaisDao {
	
	public ResponseDto salvarDadosPessoais(DadosPessoais dp) throws Exception;

}
