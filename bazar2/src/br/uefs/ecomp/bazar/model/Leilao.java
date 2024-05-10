package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;

public class Leilao
{
    // Constantes para representar os estados de um leilão qualquer:
    static final int CADASTRADO = 0;
    static final int INICIADO = 1;
    static final int ENCERRADO = 2;
    
    private double precoMinimo;
    private double incrementoMinimo;
    private int status;
    private Produto produto;
    private Usuario vendedor;
    private Venda venda;
    private Lance ultimoLance;
    
    //estrutura para armazenar os participantes do leilão 
    private ArrayList<Usuario> participantes = new ArrayList<>();
    
    public Leilao(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto)
    {
        this.precoMinimo = lPrecoMinimo;
        this.incrementoMinimo = lIncrementoMinimo;
        this.vendedor = lVendedor;
        this.produto = lProduto;
        this.status = CADASTRADO;
    }
    
    public Usuario getVendedor()
    {
        return this.vendedor;
    }
    public Produto getProduto()
    {
        return this.produto;
    }
    
    // define o status do leilão como iniciado, "reseta" o ultimo lance e define esse como leilão ativo do vendedor
    public void iniciar()
    {
        this.status = INICIADO;
        this.ultimoLance = null;
        vendedor.setLeilaoAtivo(this);
    }
    // define o status como encerrado e gera uma venda.
    public void encerrar()
    {
        this.status = ENCERRADO;
        // verifica se existe uma venda e se um lance já foi dado
        if (this.venda == null && this.ultimoLance != null)
        {
            this.venda = new Venda(this.ultimoLance, this);
            // modfica o status do produto
            this.produto.setVendido();
        }
    }
    
    public int getStatus()
    {
        return status;
    }
    // adiciona um participante na lista de participantes do leilão
    public void cadastrarParticipante(Usuario usuario)
    {
        participantes.add(usuario);
    }
    // um usuário dá um lance com base no preço minimo e no incremento
    public void darLanceMinimo(Usuario usuario)
    {
        Lance lance = new Lance(usuario, this.precoMinimo + this.incrementoMinimo);
        //atualização do ultimo lance do leilão
        this.ultimoLance = lance;
        this.precoMinimo = lance.getValor();
    }
    // um lance com um valor especifico decidido pelo usuário e verifica suas condições de validação, returnando falso caso não seja aceitável
    public boolean darLance(Usuario usuario, double preco)
    {
        Lance lance = new Lance(usuario, preco);
        
        //comparação dos dados do lance criado e os parametros do leilão
        if (lance.getValor() >= (this.precoMinimo + this.incrementoMinimo))
        {
            //atualização do ultimo lance do leilão
            this.ultimoLance = lance;
            this.precoMinimo = lance.getValor()+ this.incrementoMinimo;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public Venda getVenda()
    {
        return this.venda;
    }
    // retorna o ultimo lance do leilão;
    public Lance getUltimoLance()
    {
        return this.ultimoLance;
    }
    
    
}