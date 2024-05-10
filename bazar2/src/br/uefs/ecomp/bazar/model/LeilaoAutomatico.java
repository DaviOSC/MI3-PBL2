package br.uefs.ecomp.bazar.model;

public class LeilaoAutomatico extends Leilao
{
    public LeilaoAutomatico(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto);
    }
}
