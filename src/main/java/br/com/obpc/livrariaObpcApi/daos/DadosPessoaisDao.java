package br.com.obpc.livrariaObpcApi.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.obpc.livrariaObpcApi.interfaces.IDadosPessoaisDao;
import br.com.obpc.livrariaObpcApi.models.DadosPessoais;
import br.com.obpc.livrariaObpcApi.reponse.ResponseBuilder;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;
import br.com.obpc.livrariaObpcApi.repository.DadosPessoaisRepository;

@Service
public class DadosPessoaisDao implements IDadosPessoaisDao {
	
	@Autowired
	private DadosPessoaisRepository repositoryService;

	@Override
	public ResponseDto salvarDadosPessoais(DadosPessoais dp) throws Exception {

		dp = repositoryService.save(dp);
		
		if(dp.getId() != null)
			return new ResponseBuilder().comSucesso().comMensagem("Dados pessoais do Usuario: "+dp.getUser().getEmail()+" salvo com sucesso.").comItem(dp).build();
		else
			return new ResponseBuilder().comSucesso().comMensagem("Dados pessoais não foram salvo.").build();
	}

}
