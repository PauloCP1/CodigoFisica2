package br.edu.unespar.trabalhofisica2;

public class Particula {
    private double carga;    // Em Coulombs
    private double posicao;  // Em metros

    public Particula(double carga, double posicao) {
        this.carga = carga;
        this.posicao = posicao;
    }

    public double getCarga() {
        return carga;
    }

    public double getPosicao() {
        return posicao;
    }
}
