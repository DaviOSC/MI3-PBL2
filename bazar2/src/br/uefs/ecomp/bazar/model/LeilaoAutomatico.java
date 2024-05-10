package br.uefs.ecomp.bazar.model;

import java.util.Date;

public class LeilaoAutomatico extends Leilao
{
    public LeilaoAutomatico(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto, Date horarioInicio, Date horarioFim)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto);
    }
}
