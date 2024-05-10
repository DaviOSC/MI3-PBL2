package br.uefs.ecomp.bazar.model;

import java.util.Date;

public class LeilaoAutomaticoFechado extends LeilaoAutomatico
{
    public LeilaoAutomaticoFechado(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto, Date horarioInicio, Date horarioFim)
    {
        super(lPrecoMinimo, lIncrementoMinimo, lVendedor, lProduto, horarioInicio,  horarioFim);
    }
}
