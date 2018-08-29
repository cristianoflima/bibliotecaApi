package br.com.obpc.livrariaObpcApi.daos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.obpc.livrariaObpcApi.interfaces.IUsuarioDao;
import br.com.obpc.livrariaObpcApi.models.Usuario;
import br.com.obpc.livrariaObpcApi.reponse.ResponseBuilder;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;
import br.com.obpc.livrariaObpcApi.repository.UsuarioRepository;

@Service
public class UsuarioDao implements IUsuarioDao {
	
	@Autowired
	private UsuarioRepository repositoryService;
	
	@Override
	public ResponseDto buscarTodos() throws Exception {
		Iterable<Usuario> interable = repositoryService.findAll();
		List<Usuario> usuarios = new ArrayList<>();
		interable.forEach(usuarios::add);
		
		if(usuarios.isEmpty())
			return new ResponseBuilder().comSucesso().comMensagem("Nenhum livro encontrado").build();
		else
			return new ResponseBuilder().comSucesso().comMensagem("Total de livros encontrados: "+usuarios.size()).comLista(usuarios).build();
	}

	@Override
	public ResponseDto salvarUsuario(Usuario usuario) throws Exception {
		usuario = repositoryService.save(usuario);
		
		if(usuario.getId() != null)
			return new ResponseBuilder().comSucesso().comMensagem("Usuario salvo com sucesso: "+usuario.getEmail()).comItem(usuario).build();
		else
			return new ResponseBuilder().comSucesso().comMensagem("Usuario "+usuario.getEmail()+" NÃO salvo!").build();
	}

}
