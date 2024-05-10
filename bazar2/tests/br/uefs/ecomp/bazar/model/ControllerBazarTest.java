package br.uefs.ecomp.bazar.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import java.util.Date;

import br.uefs.ecomp.bazar.model.exception.LanceInvalidoException;
import br.uefs.ecomp.bazar.model.exception.LeilaoNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.LoginFalhouException;
import br.uefs.ecomp.bazar.model.exception.ProdutoNaoCadastrouException;
import br.uefs.ecomp.bazar.model.exception.UsuarioNaoCadastrouException;
import br.uefs.ecomp.bazar.util.Iterador;

public class ControllerBazarTest {

	private Usuario u1, u2, u3;
	private Produto p1, p2, p3;	
	private Leilao l1, l2, l3;
	ControllerBazar cb = new ControllerBazar();

	@Test
	public void testCadastrarUsuario() throws UsuarioNaoCadastrouException {
		assertEquals(0, cb.usuarios.tamanho());
		u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
		assertEquals(1, cb.usuarios.tamanho());
		u2 = cb.cadastrarUsuario("joao", "Joao dos Santos", "senha2", "987654321-01", "Rua Pessoa, 12, Centro", "7532216543");
		u3 = cb.cadastrarUsuario("pedro", "Pedro da Silva", "senha3", "456789123-01", "Rua Andrade, 45, Cidade Nova", "7532217890");
		assertEquals(3, cb.usuarios.tamanho());
	}
	
	@Test
	public void testFazerLogin() throws UsuarioNaoCadastrouException, LoginFalhouException {
		u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
		//assertNull(cb.fazerLogin("maria", "senhaerrada"));
		//assertNull(cb.fazerLogin("joao", "senha1"));
		Usuario usuarioLogado = cb.fazerLogin("maria", "senha1");
		assertNotNull(usuarioLogado);
		assertSame(u1, usuarioLogado);
	}
	
	@Test
	public void testCadastrarListarProdutos() throws UsuarioNaoCadastrouException, LoginFalhouException, ProdutoNaoCadastrouException {
		u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
		cb.fazerLogin("maria", "senha1");
		
		// cadastra produtos do usuario logado
		p1 = cb.cadastrarProduto("telefone", "Galaxy S", "Samsung Galaxy S");
		assertNotNull(p1);
		assertEquals("telefone", p1.getTipo());
		assertEquals("Galaxy S", p1.getDescricaoResumida());
		assertEquals("Samsung Galaxy S", p1.getDescricaoDetalhada());
		
		p2 = cb.cadastrarProduto("telefone", "iPhone 4S", "Apple iPhone 4S");
		assertNotNull(p2);
		
		Iterador iterador = cb.listarProdutosCadastrados();
		assertTrue(iterador.temProximo());
		iterador.proximo();
		assertTrue(iterador.temProximo());
		Produto proximo = (Produto) iterador.proximo();
		assertSame(p2, proximo);
		assertFalse(iterador.temProximo());
		
	}
	
	@Test
	public void testCadastrarLeiloes() throws UsuarioNaoCadastrouException, LoginFalhouException, ProdutoNaoCadastrouException, LeilaoNaoCadastrouException {
		u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
		cb.fazerLogin("maria", "senha1");
		p1 = cb.cadastrarProduto("telefone", "Galaxy S", "Samsung Galaxy S");
		p2 = cb.cadastrarProduto("telefone", "iPhone 4S", "Apple iPhone 4S");

		assertEquals(0, cb.leiloes.tamanho());
		l1 = cb.cadastrarLeilaoManual(p1, 200.00, 5.00);
		assertEquals(1, cb.leiloes.tamanho());
		l2 = cb.cadastrarLeilaoManual(p1, 500.00, 10.00);
		assertEquals(2, cb.leiloes.tamanho());
		
		u2 = cb.cadastrarUsuario("joao", "Joao dos Santos", "senha2", "987654321-01", "Rua Pessoa, 12, Centro", "7532216543");
		cb.fazerLogin("joao", "senha2");
		p3 = cb.cadastrarProduto("tablet", "iPad 2", "Apple iPad 2");
		l3 = cb.cadastrarLeilaoManual(p3, 1000.00, 20.00);
		assertEquals(3, cb.leiloes.tamanho());
		assertSame(l3, cb.leiloes.recupera(2));
	}
	
	@Test
	public void testIniciarLeiloesListarLeiloesIniciados() throws UsuarioNaoCadastrouException, LoginFalhouException, ProdutoNaoCadastrouException, LeilaoNaoCadastrouException {
		u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
		cb.fazerLogin("maria", "senha1");
		p1 = cb.cadastrarProduto("telefone", "Galaxy S", "Samsung Galaxy S");
		p2 = cb.cadastrarProduto("telefone", "iPhone 4S", "Apple iPhone 4S");
		l1 = cb.cadastrarLeilaoManual(p1, 200.00, 5.00);
		l2 = cb.cadastrarLeilaoManual(p2, 500.00, 10.00);
		
		Iterador iterador = cb.listarLeiloesIniciados();
		assertFalse(iterador.temProximo());
		cb.iniciarLeilao(l1);
		iterador = cb.listarLeiloesIniciados();
		assertTrue(iterador.temProximo());
		Leilao proximo = (Leilao) iterador.proximo();
		assertEquals(Leilao.INICIADO, proximo.getStatus());
		assertFalse(iterador.temProximo());
		
		cb.iniciarLeilao(l2);
		
		u2 = cb.cadastrarUsuario("joao", "Joao dos Santos", "senha2", "987654321-01", "Rua Pessoa, 12, Centro", "7532216543");
		cb.fazerLogin("joao", "senha2");
		p3 = cb.cadastrarProduto("tablet", "iPad 2", "Apple iPad 2");
		l3 = cb.cadastrarLeilaoManual(p3, 1000.00, 20.00);
		cb.iniciarLeilao(l3);
		
		iterador = cb.listarLeiloesIniciados();
		iterador.proximo();
		iterador.proximo();
		proximo = (Leilao) iterador.proximo();
		assertEquals(Leilao.INICIADO, proximo.getStatus());
		assertSame(l3, proximo);
	}
	
	@Test
	public void testLancesLeilaoEncerrarLeilao() 
			throws UsuarioNaoCadastrouException, LoginFalhouException, 
			ProdutoNaoCadastrouException, LeilaoNaoCadastrouException, 
			LanceInvalidoException {
		// Como o sistema ainda nao eh multi-usuario, cada usuario 
		// deve fazer login depois de acoes de outros usuarios.
		// Por enquanto, cada usuario so participa de um leilao de cada vez
		// e apenas um leilao pode ocorrer por vez.
		
		u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
		u2 = cb.cadastrarUsuario("joao", "Joao dos Santos", "senha2", "987654321-01", "Rua Pessoa, 12, Centro", "7532216543");
		u3 = cb.cadastrarUsuario("pedro", "Pedro da Silva", "senha3", "456789123-01", "Rua Andrade, 45, Cidade Nova", "7532217890");
		
		cb.fazerLogin("maria", "senha1");
		p1 = cb.cadastrarProduto("telefone", "Galaxy S", "Samsung Galaxy S");
		l1 = cb.cadastrarLeilaoManual(p1, 200.00, 5.00);
		cb.iniciarLeilao(l1);
		
		cb.fazerLogin("joao", "senha2");
		cb.participarLeilao(l1);
		cb.darLanceMinimo();
		assertEquals(205.00, l1.getUltimoLance().getValor(), 0.001);
		
		cb.fazerLogin("pedro", "senha3");
		cb.participarLeilao(l1);
		cb.darLanceMinimo();
		assertEquals(210.00, l1.getUltimoLance().getValor(), 0.001);
	
		cb.fazerLogin("joao", "senha2");
		cb.darLanceMinimo();
		assertEquals(215.00, l1.getUltimoLance().getValor(), 0.001);
		
		cb.fazerLogin("pedro", "senha3");
		cb.darLanceMinimo();
		assertEquals(220.00, l1.getUltimoLance().getValor(), 0.001);
		
		cb.fazerLogin("joao", "senha2");
		cb.darLance(250.00);
		assertEquals(250.00, l1.getUltimoLance().getValor(), 0.001);

		cb.fazerLogin("maria", "senha1");
		Venda venda = cb.encerrarLeilao();
		assertEquals(250.00, venda.getValor(), 0.001);
	}
         @Test
        public void testListarLeiloesIniciados() {
        // Criando alguns leilões
        Date dataAtual = new Date();
        Date dataFutura = new Date(System.currentTimeMillis() + 1000000);
        Date dataPassada = new Date(System.currentTimeMillis() - 1000000);
        Date dataPassada2 = new Date(System.currentTimeMillis() - 2000000);
        Date dataFutura2 = new Date(System.currentTimeMillis() + 2000000);

        Leilao leilao1 = new LeilaoManual(dataPassada2);
        Leilao leilao2 = new LeilaoManual(dataPassada);
        Leilao leilao3 = new LeilaoManual(dataAtual);
        Leilao leilao4 = new LeilaoManual(dataFutura);
        Leilao leilao5 = new LeilaoManual(dataFutura2);

        
        
        // Adicionando os leilões a uma lista
        cb.cadastrarLeilao(leilao2);
        cb.cadastrarLeilao(leilao1);
        cb.cadastrarLeilao(leilao3);
        cb.cadastrarLeilao(leilao5);
        cb.cadastrarLeilao(leilao4);
        
        leilao3.status = Leilao.INICIADO;
        leilao2.status = Leilao.INICIADO;
        leilao1.status = Leilao.INICIADO;
        leilao5.status = Leilao.INICIADO;
        leilao4.status = Leilao.INICIADO;
        
        
        Iterador<Leilao> iterador = cb.listarLeiloesIniciados();


        assertEquals(leilao1, iterador.next());
        assertEquals(leilao2, iterador.next()); 
        assertEquals(leilao3, iterador.next()); 
        assertEquals(leilao4, iterador.next()); 
        assertEquals(leilao5, iterador.next());

    }


        
        

}
