package br.uefs.ecomp.bazar.model;

import java.io.Serializable;
import java.util.Date;

public class Lance implements Serializable
{
    private static final long serialVersionUID = 1L;
    private double valor;
    private Usuario participante;
    private Date momentoDoLance;
    
    // Construtor padr�o da classe
    public Lance(Usuario lParticipante, double lValor)
    {
        this.valor = lValor;
        this.participante = lParticipante;
        this.momentoDoLance = new Date();
    }
    
    // m�todos que retornam atributos do Lance
    public double getValor()
    {
        return valor;
    }
    
    public Usuario getParticipante()
    {
        return participante;
    }
    
    public Date getMomento()
    {
        return momentoDoLance;
    }
            
}
