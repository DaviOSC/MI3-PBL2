package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario
{
    private String login;
    private String nome;
    private String senha;
    private String cpf;
    private String endereco;
    private String telefone;
    private Leilao leilaoAtivo;

    private ArrayList produtosCadastrados =  new ArrayList<>();

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
    public String getSenha()
    {
        return this.senha;
    }
    //modfica o atributo referente ao leil�o como participante ou como vendedor
    public void setLeilaoAtivo(Leilao leilao)
    {
        this.leilaoAtivo = leilao;
    }
    //um iterador da lista do requerimento 4 dos user stories
    public Iterator listarProdutosCadastrados()
    {
        return produtosCadastrados.iterator();  
    }
    //adiciona o usuario no leil�o como participante e define seu atributo leilao ativo
    public void participarLeilao(Leilao leilao)
    {
        leilao.cadastrarParticipante(this);
        setLeilaoAtivo(leilao);
    }
    //cria um novo produto e adiciona-o na lista de produtos do usu�rio
    public Produto cadastrarProduto(String pTipo, String pDescResum, String pDescDetalh )
    {
        Produto produto = new Produto(pTipo, pDescResum, pDescDetalh, this);
        produtosCadastrados.add(produto);
        return produto;
    }
    //cria um leil�o de acordo com os parametros passados e retorna-o
    public Leilao cadastrarLeilao(double preco, double incremento, Produto produto)
    {
        Leilao leilao = new Leilao(preco, incremento, this, produto);
        return leilao;
    }
    // inicia o leil�o passado e defini-o como leil�o ativo do usuario(vendedor)
    public void iniciarLeilao(Leilao leilao)
    {
        this.leilaoAtivo = leilao;
        this.leilaoAtivo.iniciar();
    }
    // chama o metodo dar lance no leil�o ativo(participante), passando o usuario e o valor
    public void darLance(Double valor)
    {
        leilaoAtivo.darLance(this, valor);
    }
    // chama o metodo dar lance minimo leil�o ativo(participante), passando o usuario como parametro
    public void darLanceMinimo()
    {
       leilaoAtivo.darLanceMinimo(this);
    }
    // encerra o leil�o ativo(vendedor) e retorna uma venda.
    public Venda encerrarLeilaoAtivo()
    {
        leilaoAtivo.encerrar();
        return leilaoAtivo.getVenda();
    }
    
    
}
