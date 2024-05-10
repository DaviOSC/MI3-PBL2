package br.uefs.ecomp.bazar.model;

public class Venda
{
    private double valor;
    private Usuario comprador;
    private Usuario vendedor;
    private Produto produto;
    private Leilao leilao;
    
    public Venda(Lance vLance, Leilao vLeilao)
    {
        this.valor = vLance.getValor();
        this.comprador = vLance.getParticipante();
        this.vendedor = vLeilao.getVendedor();
        this.produto = vLeilao.getProduto();
        this.leilao = vLeilao;
    }

    public double getValor()
    {
        return valor;
    }
    
    public Usuario getVendedor()
    {
        return vendedor;
    }
    
    public Usuario getComprador()
    {
        return comprador;
    }
    
    public Produto getProduto()
    {
        return produto;
    }
    
    public Leilao getLeilao()
    {
        return leilao;
    }
}
