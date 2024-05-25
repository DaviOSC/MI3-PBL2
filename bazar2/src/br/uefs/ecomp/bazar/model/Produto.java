package br.uefs.ecomp.bazar.model;

import java.io.Serializable;

public class Produto implements Serializable
{
    private String tipo;
    private String descricaoResumida;
    private String descricaoDetalhada;
    private boolean vendido;
    private Usuario vendedor;
    
    public Produto(String pTipo, String pDescResum, String pDescDetalh, Usuario pVendedor)
    {
        this.tipo = pTipo;
        this.descricaoResumida = pDescResum;
        this.descricaoDetalhada = pDescDetalh;
        this.vendedor = pVendedor;
        this.vendido = false;
    }
    
    public boolean isVendido()
    {
        return vendido;
    }
    
    public String getDescricaoResumida()
    {
        return descricaoResumida;
    }
    
    public String getDescricaoDetalhada()
    {
        return descricaoDetalhada;
    }
    
    public String getTipo()
    {
        return tipo;
    }
    
    public void setVendido()
    {
        this.vendido = true;
    }
    
    @Override
    public String toString()
    {
        return descricaoResumida;
    }
    
            
}
