package com.fatec.produto.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.produto.model.Catalogo;
import com.fatec.produto.model.IImagemRepository;
import com.fatec.produto.model.IProdutoRepository;
import com.fatec.produto.model.Imagem;
import com.fatec.produto.model.Produto;

@Service
public class ProdutoServico implements IProdutoServico {
	@Autowired
	IProdutoRepository repositoryP;
	@Autowired
	IImagemRepository repositoryI;

	@Override
	public List<Catalogo> consultaCatalogo() {
		Catalogo c = null;
		List<Catalogo> lista = new ArrayList<>();
		List<Produto> ListaP = repositoryP.findAll();
		List<Imagem> listaI = repositoryI.findAll();

		for (Produto p : ListaP) {
			for (Imagem i : listaI) {
				if (p.getId().equals(i.getId())) {
					c = new Catalogo(p.getId(), p.getDescricao(), p.getCategoria(), p.getCusto(),
							p.getQuantidadeNoEstoque(), i.getArquivo());
					lista.add(c);
				}
			}
		}
		return lista;

	}

}
