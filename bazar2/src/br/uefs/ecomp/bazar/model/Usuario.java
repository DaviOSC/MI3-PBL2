package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.*;

import java.util.ArrayList;
import java.util.Iterator;
import br.uefs.ecomp.bazar.util.Iterador;
import java.util.Date;

public class Usuario
{
    private String login;
    private String nome;
    private String senha;
    private String cpf;
    private String endereco;
    private String telefone;
    private Leilao leilaoAtivo;

    private ArrayList<Produto> produtosCadastrados =  new ArrayList<Produto>();

    public Usuario(String login, String nome, String senha, String cpf, String endereco, String telefone)
    {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public String getLogin()
    {
        return this.login;
    }
    public String getNome()
    {
        return this.nome;
    }
    public String getSenha()
    {
        return this.senha;
    }
    public String getCpf()
    {
        return this.cpf;
    }
    public String getEndereco()
    {
        return this.endereco;
    }
    public String getTelefone()
    {
        return this.telefone;
    }
    
    //modfica o atributo referente ao leil�o como participante ou como vendedor
    public void setLeilaoAtivo(Leilao leilao)
    {
        this.leilaoAtivo = leilao;
    }
    //um iterador da lista do requerimento 4 dos user stories
    public Iterador listarProdutosCadastrados()
    {
        Iterador iterador = new Iterador(produtosCadastrados.iterator());
        return iterador;
    }
    //adiciona o usuario no leil�o como participante e define seu atributo leilao ativo
    public void participarLeilao(Leilao leilao)
    {
        leilao.cadastrarParticipante(this);
        setLeilaoAtivo(leilao);
    }
    //cria um novo produto e adiciona-o na lista de produtos do usu�rio
    public Produto cadastrarProduto(String pTipo, String pDescResum, String pDescDetalh ) throws ProdutoNaoCadastrouException
    {
        if(pTipo.equals(""))
        {
            throw new ProdutoNaoCadastrouException("Tipo do produto n?o cadastrado.");
        }
        else if(pDescResum.equals(""))
        {
            throw new ProdutoNaoCadastrouException("Descricao resumida do produto n?o cadastrada.");
        }
        else
        {
            Produto produto = new Produto(pTipo, pDescResum, pDescDetalh, this);
            produtosCadastrados.add(produto);
            return produto;
        }
    }
    public Leilao cadastrarLeilaoManual(double preco, double incremento, Produto produto)
    {
        Leilao leilao = new LeilaoManual(preco, incremento,this, produto);
        return leilao;
    }
    public Leilao cadastrarLeilaoAutomatico(double preco, double incremento, Produto produto, Date momentoInicio, Date momentoFim)
    {
        Leilao leilao = new LeilaoAutomatico(preco, incremento,this, produto, momentoInicio, momentoFim);
        return leilao;
    }
    public Leilao cadastrarLeilaoAutomaticoFechado(double preco, double incremento, Produto produto, Date momentoInicio, Date momentoFim)
    {
        Leilao leilao = new LeilaoAutomaticoFechado(preco, incremento,this, produto, momentoInicio, momentoFim);
        return leilao;
    }
    // inicia o leil�o passado e defini-o como leil�o ativo do usuario(vendedor)
    public void iniciarLeilao(Leilao leilao)
    {
        this.leilaoAtivo = leilao;
        this.leilaoAtivo.iniciar();
    }
    // chama o metodo dar lance no leil�o ativo(participante), passando o usuario e o valor
    public void darLance(Double valor) throws LanceInvalidoException
    {
        try
        {
            leilaoAtivo.darLance(this, valor);
        }
        catch(LanceInvalidoException e)
        {
            
        }
    }
    // chama o metodo dar lance minimo leil�o ativo(participante), passando o usuario como parametro
    public void darLanceMinimo() throws LanceInvalidoException
    {
       try
        {
            leilaoAtivo.darLanceMinimo(this);
        }
        catch(LanceInvalidoException e)
        {
            
        }
    }
//    
//    public void darLanceAutomaticoFechado(double valor)
//    {
//        leilaoAtivo.darLance(this, valor);
//    }
    // encerra o leil�o ativo(vendedor) e retorna uma venda.
    public Venda encerrarLeilaoAtivo()
    {
        leilaoAtivo.encerrar();
        return leilaoAtivo.getVenda();
    }


        
}
