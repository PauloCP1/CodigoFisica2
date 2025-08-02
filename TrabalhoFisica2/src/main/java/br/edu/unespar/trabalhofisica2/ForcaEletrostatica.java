package br.edu.unespar.trabalhofisica2;

import java.util.List;

public class ForcaEletrostatica {
    public static final double k = 8.99e9; // Constante eletrostática

    public static double calcularForcaResultante(List<Particula> particulas, int indiceAlvo) {
        Particula alvo = particulas.get(indiceAlvo);
        double forcaTotal = 0.0;

        for (int i = 0; i < particulas.size(); i++) {
            if (i == indiceAlvo) continue;

            Particula outra = particulas.get(i);
            double distancia = alvo.getPosicao() - outra.getPosicao();

            // Verifica se há partículas na mesma posição
            if (distancia == 0) {
                throw new IllegalArgumentException("Duas partículas não podem ocupar a mesma posição.");
            }

            // Calcula o módulo da força
            double modulo = k * alvo.getCarga() * outra.getCarga() / (distancia * distancia);

            // Determina a direção da força (repulsiva ou atrativa)
            double direcao = Math.signum(distancia);
            forcaTotal += -modulo * direcao;
        }

        return forcaTotal;
    }

    // Função auxiliar para verificar se alguma posição se repete
    public static boolean temParticulasSobrepostas(List<Particula> particulas) {
        for (int i = 0; i < particulas.size(); i++) {
            for (int j = i + 1; j < particulas.size(); j++) {
                if (particulas.get(i).getPosicao() == particulas.get(j).getPosicao()) {
                    return true;
                }
            }
        }
        return false;
    }
}
