package br.com.obpc.livrariaObpcApi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.obpc.livrariaObpcApi.dtos.DadosCadastraisDto;
import br.com.obpc.livrariaObpcApi.interfaces.ICadastroUsuario;
import br.com.obpc.livrariaObpcApi.interfaces.IDadosPessoaisDao;
import br.com.obpc.livrariaObpcApi.interfaces.IUsuarioDao;
import br.com.obpc.livrariaObpcApi.models.DadosPessoais;
import br.com.obpc.livrariaObpcApi.models.Usuario;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;

@Service
public class CadastroUsuarioImpl implements ICadastroUsuario{
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IDadosPessoaisDao dadosPessoaisDao;

	@Override
	public ResponseDto cadastrarUsuario(DadosCadastraisDto dados) throws Exception {
		
		Usuario usuario = new Usuario();
		
		if(dados.getEmail() != null)
			usuario.setEmail(dados.getEmail());
		if(dados.getSenha() != null)
			usuario.setPassword(dados.getSenha());
		if(dados.getStatus() != null)
			usuario.setStatus(dados.getStatus());
		
		ResponseDto retorno = usuarioDao.salvarUsuario(usuario);
		if(retorno.getItem() != null) {
			usuario = (Usuario) retorno.getItem();
			
			DadosPessoais dp = new DadosPessoais();
			dp.setUser(usuario);
			
			if(dados.getNome() != null)
				dp.setNome(dados.getNome());
			if(dados.getFone() != null)
				dp.setTelefone(dados.getFone());
			if(dados.getLogradouro() != null)
				dp.setLogradouro(dados.getLogradouro());
			if(dados.getNumero() != null)
				dp.setNumero(dados.getNumero());
			if(dados.getComplemento() != null)
				dp.setComplemento(dados.getComplemento());
			if(dados.getBairro() != null)
				dp.setBairro(dados.getBairro());
			if(dados.getCidade() != null)
				dp.setCidade(dados.getCidade());
			if(dados.getUf() != null)
				dp.setUf(dados.getUf());
			if(dados.getCep() != null)
				dp.setCep(dados.getCep());
			
			ResponseDto retornoDp = dadosPessoaisDao.salvarDadosPessoais(dp);
			if(retornoDp.getItem() == null)
				retorno.setMensagem("Usuario salvo sem Dados Cadatrais");
		}
		
		return retorno;
	}

}
