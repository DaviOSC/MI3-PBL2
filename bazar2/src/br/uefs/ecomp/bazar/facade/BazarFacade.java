package br.uefs.ecomp.bazar.facade;

import java.util.Iterator;
import java.util.List;
import br.uefs.ecomp.bazar.model.ControllerBazar;
import br.uefs.ecomp.bazar.model.Leilao;
import br.uefs.ecomp.bazar.model.Produto;
import br.uefs.ecomp.bazar.model.Usuario;
import br.uefs.ecomp.bazar.model.Venda;
import java.util.Date;

public class BazarFacade {

    ControllerBazar cb;

    public BazarFacade() {
        this.cb = new ControllerBazar();
    }

    //1
    public Usuario cadastrarUsuario(String login, String nome, String senha,
            String cpf, String endereco, String telefone) {
        return cb.cadastrarUsuario(login, nome, senha, cpf, endereco, telefone);
    }
    //2
    public Usuario fazerLogin(String login, String senha) {
        return cb.fazerLogin(login, senha);
    }
    //3
    public Produto cadastrarProduto(String tipo, String descricaoResumida,
            String descricaoDetalhada) {
        return cb.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
    }
    //4
    public Iterator listarProdutosCadastrados() {
        return this.cb.listarProdutosCadastrados();
    }
    //5
    public Leilao cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo) {
        return this.cb.cadastrarLeilaoManual(produto, precoMinimo, incrementoMinimo);
    }
    //6
    public void iniciarLeilao(Leilao leilao) {
        this.cb.iniciarLeilao(leilao);
    }
    //7
    public Iterator listarLeiloesIniciados() {
        return this.cb.listarLeiloesIniciados();
    }
    //8
    public void participarLeilao(Leilao leilao) {
        this.cb.participarLeilao(leilao);
    }
    //9
    public void darLanceMinimo() {
        this.cb.darLanceMinimo();
    }
    //10
    public void darLance(double valor) {
        this.cb.darLance(valor);
    }
    //11
    public Venda encerrarLeilao() {
        return this.cb.encerrarLeilao();
    }
    //12
    public Leilao cadastrarLeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Date momentoInicio, Date momentoFim) {
        return this.cb.cadastrarLeilaoAutomatico(produto, precoMinimo, incrementoMinimo, momentoInicio, momentoFim);
    }
    //13
    public Leilao cadastrarLeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Date momentoInicio, Date momentoFim) {
        return this.cb.cadastrarLeilaoAutomaticoFechado(produto, precoMinimo, incrementoMinimo, momentoInicio, momentoFim);
    }
    //14
    public void darLanceLeilaoAutomaticoFechado(double valor)
    {
        this.cb.darLanceLeilaoAutomaticoFechado(valor);
    }
    //15
    public Iterator abrirEnvelopesLeilaoAutomáticoFechado(Leilao leilao)
    {
        return this.cb.abrirEnvelopesLeilaoAutomaticoFechado(leilao);
    }
    //16
    public Date listarMomentoAtual()
    {
        return this.cb.listarMomentoAtual();
    }
    //17
    //18
    //19
    public Iterator listarParticipantesLeilao(Leilao leilao)
    {
        return this.cb.listarParticipantesLeilao(leilao);
    }
    //20
    public Iterator listarLances(Leilao leilao)
    {
        return this.cb.listarLances(leilao);
    }
    //21
    public Iterator listarLeiloes()
    {
        return this.cb.getListaLeiloes().iterator();
    }
    //22
    public Iterator buscarLeiloesTempo(Date momentoA, Date momentoB)
    {
        return this.cb.buscarLeiloesTempo(momentoA, momentoB);
    }
            
            
    
}
