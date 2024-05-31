package br.uefs.ecomp.bazar.model;

import java.io.Serializable;
import java.util.Date;

public class Venda implements Serializable
{
    private static final long serialVersionUID = 1L;

    private double valor;
    private Usuario comprador;
    private Usuario vendedor;
    private Produto produto;
    private Leilao leilao;
    private Date momentoDaVenda;
    
    public Venda(Lance vLance, Leilao vLeilao)
    {
        this.valor = vLance.getValor();
        this.comprador = vLance.getParticipante();
        this.vendedor = vLeilao.getVendedor();
        this.produto = vLeilao.getProduto();
        this.leilao = vLeilao;
        this.momentoDaVenda = new Date();
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
