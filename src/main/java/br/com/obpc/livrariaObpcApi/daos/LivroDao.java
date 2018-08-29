package br.com.obpc.livrariaObpcApi.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.obpc.livrariaObpcApi.interfaces.ILivroDao;
import br.com.obpc.livrariaObpcApi.models.Livro;
import br.com.obpc.livrariaObpcApi.reponse.ResponseBuilder;
import br.com.obpc.livrariaObpcApi.reponse.ResponseDto;
import br.com.obpc.livrariaObpcApi.repository.LivroRepository;

@Service
public class LivroDao implements ILivroDao{
	
	@Autowired
	private LivroRepository repositoryService;
	
	@Autowired
	private EntityManager em;
	
	@Override
	public ResponseDto salvar(Livro livro) throws Exception {
		Livro itemSalvo = repositoryService.save(livro);
		if(itemSalvo.getId() != null)
			return new ResponseBuilder().comSucesso().comMensagem("Livro "+itemSalvo.getTitulo()+" salvo com sucesso, ID gerado: "+itemSalvo.getId()).comItem(itemSalvo).build();
		else
			return new ResponseBuilder().comSucesso().comMensagem("Livro "+livro.getTitulo()+" NÃO salvo!").build();
	}

	@Override
	public ResponseDto buscarTodosLivros() throws Exception {
		Iterable<Livro> interable = repositoryService.findAll();
		List<Livro> livros = new ArrayList<>();
		interable.forEach(livros::add);
		
		if(livros.isEmpty())
			return new ResponseBuilder().comSucesso().comMensagem("Nenhum livro encontrado").build();
		else
			return new ResponseBuilder().comSucesso().comMensagem("Total de livros encontrados: "+livros.size()).comLista(livros).build();
			
	}

	@Override
	public ResponseDto buscarLivroPorId(Integer id) throws Exception {
		Livro item = repositoryService.findOne(id);
		if(item != null)
			return new ResponseBuilder().comSucesso().comMensagem("Livro com ID: "+id+" encontrado.").comItem(item) .build();
		else
			return new ResponseBuilder().comSucesso().comMensagem("Livro com ID: "+id+" NÂO encontrado.").build();
	}

	@Override
	@SuppressWarnings("unchecked")
	public ResponseDto buscarLivroComFiltro(Livro livro) throws Exception {
		
		if(livro.isNull())
			throw new RuntimeException("Livro não pode ser NULL.");

		Session s = em.unwrap(Session.class);
		Criteria c = s.createCriteria(Livro.class);
		
		if(livro.getAutor() != null)
			c.add(Restrictions.like("autor", "%"+livro.getAutor()+"%"));
			
		if(livro.getEditora() != null)
			c.add(Restrictions.like("editora", "%"+livro.getEditora()+"%"));
		
		if(livro.getLivrariaId() != null)
			c.add(Restrictions.like("livrariaId", livro.getLivrariaId()));
		
		if(livro.getTitulo() != null)
			c.add(Restrictions.like("titulo", "%"+livro.getTitulo()+"%"));
		
		if(livro.getAno() != null)
			c.add(Restrictions.like("ano", livro.getAno()));
		
		if(livro.getTema() != null)
			c.add(Restrictions.like("tema", "%"+livro.getTema()+"%"));
		
		
		List<Livro> livros = (List<Livro>) c.list();
		
		if(livros.isEmpty())
			return new ResponseBuilder().comSucesso().comMensagem("Nenhum livro encontrado com Título: "+livro.getTitulo()).build();
		else
			return new ResponseBuilder().comSucesso().comMensagem("Total de livros encontrados: "+livros.size()).comLista(livros).build();
	}

}
