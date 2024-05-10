package br.uefs.ecomp.bazar.model;

public class Lance
{
    private double valor;
    private Usuario participante;
    
    // Construtor padr�o da classe
    public Lance(Usuario lParticipante, double lValor)
    {
        this.valor = lValor;
        this.participante = lParticipante;
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
            
}
