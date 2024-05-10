package br.uefs.ecomp.bazar.model;

public class Lance
{
    private double valor;
    private Usuario participante;
    
    // Construtor padrão da classe
    public Lance(Usuario lParticipante, double lValor)
    {
        this.valor = lValor;
        this.participante = lParticipante;
    }
    
    // métodos que retornam atributos do Lance
    public double getValor()
    {
        return valor;
    }
    
    public Usuario getParticipante()
    {
        return participante;
    }
            
}
