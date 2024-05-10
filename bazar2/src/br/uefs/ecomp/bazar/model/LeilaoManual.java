package br.uefs.ecomp.bazar.model;

import java.util.Date;

public class LeilaoManual extends Leilao
{
    public LeilaoManual(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto);
    }
    
    public LeilaoManual(Date date)
    {
        super(date);
    }
    
}
