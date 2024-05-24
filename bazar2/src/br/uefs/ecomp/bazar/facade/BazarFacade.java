package br.uefs.ecomp.bazar.facade;

import java.util.Iterator;
import java.util.List;
import br.uefs.ecomp.bazar.model.ControllerBazar;
import br.uefs.ecomp.bazar.model.Leilao;
import br.uefs.ecomp.bazar.model.Produto;
import br.uefs.ecomp.bazar.model.Usuario;
import br.uefs.ecomp.bazar.model.Venda;
import br.uefs.ecomp.bazar.model.exception.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Date;

public class BazarFacade {

    ControllerBazar cb;

    public BazarFacade() {
        this.cb = new ControllerBazar();
    }

    //1
    public Usuario cadastrarUsuario(String login, String nome, String senha, String cpf, String endereco, String telefone) throws UsuarioNaoCadastrouException
    {
        try
        {
            return cb.cadastrarUsuario(login, nome, senha, cpf, endereco, telefone);
        }
        catch(UsuarioNaoCadastrouException e)
        {
          throw e;  
        } 
    }
    //2
    public Usuario fazerLogin(String login, String senha) throws LoginFalhouException
    {
       try
       {
           return cb.fazerLogin(login, senha);
       }
       catch(LoginFalhouException e)
       {
           throw e;
       }
    }
    //3
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada) throws ProdutoNaoCadastrouException
    {
        try
        { 
            return cb.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
        }
        catch(ProdutoNaoCadastrouException e)
        {
            throw e;
        }
    }
    //4
    public Iterator listarProdutosCadastrados() {
        return this.cb.listarProdutosCadastrados();
    }
    //5
    public Leilao cadastrarLeilaoManual(Produto produto, double precoMinimo, double incrementoMinimo) throws LeilaoNaoCadastrouException
    {
        try
        {
            return this.cb.cadastrarLeilaoManual(produto, precoMinimo, incrementoMinimo);
        }
        catch(LeilaoNaoCadastrouException e)
        {
            throw e;
        }
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
    public void participarLeilao(Leilao leilao)
    {
        cb.checkStates();
        this.cb.participarLeilao(leilao);
    }
    //9
    public void darLanceMinimo() throws LanceInvalidoException{
        try
        {
            this.cb.darLanceMinimo();
        }
        catch(LanceInvalidoException e)
        {
            throw e;
        }
    }
    //10
    public boolean darLance(double valor) throws LanceInvalidoException
    {   
        cb.checkStates();
        try
        {
            return this.cb.darLance(valor);
        }
        catch(LanceInvalidoException e)
        {
            throw e;
        }
    }
    //11
    public Venda encerrarLeilao() {
        return this.cb.encerrarLeilao();
    }
    //12
    public Leilao cadastrarLeilaoAutomatico(Produto produto, double precoMinimo, double incrementoMinimo, Date momentoInicio, Date momentoFim)throws LeilaoNaoCadastrouException
    {
        try
        {
            return this.cb.cadastrarLeilaoAutomatico(produto, precoMinimo, incrementoMinimo, momentoInicio, momentoFim);
        }
        catch(LeilaoNaoCadastrouException e)
        {
            throw e;
        }
    }
    //13
    public Leilao cadastrarLeilaoAutomaticoFechado(Produto produto, double precoMinimo, double incrementoMinimo, Date momentoInicio, Date momentoFim)throws LeilaoNaoCadastrouException
    {
        try
        {
            return this.cb.cadastrarLeilaoAutomaticoFechado(produto, precoMinimo, incrementoMinimo, momentoInicio, momentoFim);
        }
        catch(LeilaoNaoCadastrouException e)
        {
            throw e;
        }
    }
    //14
//    public void darLanceLeilaoAutomaticoFechado(double valor)
//    {
//        this.cb.darLanceLeilaoAutomaticoFechado(valor);
//    }
    //15
    public Iterator abrirEnvelopesLeilaoAutomaticoFechado() throws LeilaoNaoEncerradoException
    {
        try
        {
            return this.cb.abrirEnvelopesLeilaoAutomaticoFechado();
        }
        catch(LeilaoNaoEncerradoException e)
        {
            throw e;
        }
    }
    //16
    public Date listarMomentoAtual()
    {
        return this.cb.listarMomentoAtual();
    }
    //17
    public void salvarDados(String arquivo) throws IOException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo)))
        {
            oos.writeObject(this.cb);
            oos.close();
        }
        catch (IOException e)
        {
            throw e;
        }    
    } 
    //18
    public void carregarDados(String arquivo) throws IOException, ClassNotFoundException
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo)))
        {
            this.cb = (ControllerBazar) ois.readObject();
            ois.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            throw e;
        }        
    }
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
    
    public void test()
    {
        System.out.print("TESTE");
    }

}
