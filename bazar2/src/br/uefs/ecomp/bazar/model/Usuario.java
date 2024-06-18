package br.uefs.ecomp.bazar.model;

import br.uefs.ecomp.bazar.model.exception.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String login;
    private String nome;
    private String senha;
    private String cpf;
    private String endereco;
    private String telefone;
    private transient Leilao leilaoAtivo;

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
    
    public Iterator listarProdutosCadastrados()
    {
        return produtosCadastrados.iterator();
    }
    //adiciona o usuario no leilao como participante e define seu atributo leilao ativo
    public void participarLeilao(Leilao leilao) throws UsuarioJaParticipaException
    {
        leilao.cadastrarParticipante(this);
        setLeilaoAtivo(leilao);
    }
    //cria um novo produto e adiciona-o na lista de produtos do usu�rio
    public Produto cadastrarProduto(String pTipo, String pDescResum, String pDescDetalh ) throws ProdutoNaoCadastrouException
    {
        if(pTipo.equals(""))
        {
            throw new ProdutoNaoCadastrouException("Tipo do produto não cadastrado.");
        }
        else if(pDescResum.equals(""))
        {
            throw new ProdutoNaoCadastrouException("Descricao resumida do produto não cadastrada.");
        }
        else
        {
            Produto produto = new Produto(pTipo, pDescResum, pDescDetalh, this);
            produtosCadastrados.add(produto);
            return produto;
        }
    }
    
    public Leilao cadastrarLeilaoManual(double preco, double incremento, Produto produto) throws LeilaoNaoCadastrouException
    {
        if(incremento <= 0)
        {
            throw new LeilaoNaoCadastrouException("Incremento minimo deve ser maior que zero.");
        }
        else if(preco <= 0)
        {
            throw new LeilaoNaoCadastrouException("Preco minimo deve ser maior que zero.");
        }
        else if(produto == null)
        {
            throw new LeilaoNaoCadastrouException("Produto não selecionado.");
        }
        else
        {
            Leilao leilao = new LeilaoManual(preco, incremento,this, produto);
            return leilao;  
        }
        
    }
    public Leilao cadastrarLeilaoAutomatico(double preco, double incremento, Produto produto, Date momentoInicio, Date momentoFim) throws LeilaoNaoCadastrouException
    {
        if(incremento <= 0)
        {
            throw new LeilaoNaoCadastrouException("Incremento minimo deve ser maior que zero.");
        }
        else if(preco <= 0)
        {
            throw new LeilaoNaoCadastrouException("Preco minimo deve ser maior que zero.");
        }
        else if(produto == null)
        {
            throw new LeilaoNaoCadastrouException("Produto não selecionado.");
        }
        else if(momentoFim.compareTo(momentoInicio) < 0)
        {
            throw new LeilaoNaoCadastrouException("Momento de termino do leilao deve ocorrer apos momento de inicio.");
        }
        else if(momentoInicio.compareTo(new Date()) < 0 )
        {
            throw new LeilaoNaoCadastrouException("Momento de inicio do leilao deve ocorrer apos a hora atual.");
        }
        else
        {
            Leilao leilao = new LeilaoAutomatico(preco, incremento,this, produto, momentoInicio, momentoFim);
            return leilao;  
        }
    }
    public Leilao cadastrarLeilaoAutomaticoFechado(double preco, double incremento, Produto produto, Date momentoInicio, Date momentoFim) throws LeilaoNaoCadastrouException
    {
        if(incremento <= 0)
        {
            throw new LeilaoNaoCadastrouException("Incremento minimo deve ser maior que zero.");
        }
        else if(preco <= 0)
        {
            throw new LeilaoNaoCadastrouException("Preco minimo deve ser maior que zero.");
        }
        else if(produto == null)
        {
            throw new LeilaoNaoCadastrouException("Produto não selecionado.");
        }
        else if(momentoFim.compareTo(momentoInicio) < 0)
        {
            throw new LeilaoNaoCadastrouException("Momento de termino do leilao deve ocorrer apos momento de inicio.");
        }
        else if(momentoInicio.compareTo(new Date()) < 0 )
        {
            throw new LeilaoNaoCadastrouException("Momento de inicio do leilao deve ocorrer apos a hora atual.");
        }
        else
        {
            Leilao leilao = new LeilaoAutomaticoFechado(preco, incremento,this, produto, momentoInicio, momentoFim);
            return leilao;  
        }
    }

    public void iniciarLeilao(Leilao leilao)
    {
        this.leilaoAtivo = leilao;
        this.leilaoAtivo.iniciar();
    }
    // chama o metodo dar lance no leil�o ativo(participante), passando o usuario e o valor
    public boolean darLance(Double valor) throws LanceInvalidoException, LeilaoNaoParticipaException
    {
        if(leilaoAtivo == null)
        {
            throw new LeilaoNaoParticipaException("Não existe Leilao");
        }
        return leilaoAtivo.darLance(this, valor);
    }
    // chama o metodo dar lance minimo leil�o ativo(participante), passando o usuario como parametro
    public void darLanceMinimo() throws LanceInvalidoException, LeilaoNaoParticipaException
    {
        if(leilaoAtivo == null)
        {
            throw new LeilaoNaoParticipaException("Não existe Leilao");
        }
        leilaoAtivo.darLanceMinimo(this);
    }

    // encerra o leil�o ativo(vendedor) e retorna uma venda.
    public Venda encerrarLeilaoAtivo()
    {
        leilaoAtivo.encerrar();
        return leilaoAtivo.getVenda();
    }
    
    public Leilao getLeilaoAtivo()
    {
        return this.leilaoAtivo;
    }
    @Override
    public String toString()
    {
        return this.login;
    }

        
}
