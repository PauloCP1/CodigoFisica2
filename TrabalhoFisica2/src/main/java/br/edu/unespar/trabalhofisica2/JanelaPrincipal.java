package br.edu.unespar.trabalhofisica2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class JanelaPrincipal extends JFrame {
    private JTextField carga1Field, pos1Field;
    private JTextField carga2Field, pos2Field;
    private JTextField carga3Field, pos3Field;
    private JComboBox<String> comboParticula;
    private JLabel resultadoLabel;

    public JanelaPrincipal() {
    setTitle("Cálculo de Força Eletrostática");
    setSize(400, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null); // centraliza a janela

    // Layout com 8 linhas e 2 colunas
    setLayout(new GridLayout(8, 2));

    // Entradas da carga e posição da partícula 1
    add(new JLabel("Carga 1 (C):"));
    carga1Field = new JTextField();
    add(carga1Field);

    add(new JLabel("Posição 1 (m):"));
    pos1Field = new JTextField();
    add(pos1Field);

    // Entradas da partícula 2
    add(new JLabel("Carga 2 (C):"));
    carga2Field = new JTextField();
    add(carga2Field);

    add(new JLabel("Posição 2 (m):"));
    pos2Field = new JTextField();
    add(pos2Field);

    // Entradas da partícula 3
    add(new JLabel("Carga 3 (C):"));
    carga3Field = new JTextField();
    add(carga3Field);

    add(new JLabel("Posição 3 (m):"));
    pos3Field = new JTextField();
    add(pos3Field);

    // ComboBox para escolher qual partícula será analisada
    add(new JLabel("Partícula alvo:"));
    comboParticula = new JComboBox<>(new String[] { "1", "2", "3" });
    add(comboParticula);

    // Botão de cálculo
    JButton calcularButton = new JButton("Calcular Força");
    add(calcularButton);

    // Label que mostra o resultado
    resultadoLabel = new JLabel("Resultado: ");
    add(resultadoLabel);

    // Ação do botão
    calcularButton.addActionListener(this::calcularForca);

    // ❗ MOSTRA A JANELA
    setVisible(true);
}


    // Lógica de cálculo com validações
    private void calcularForca(ActionEvent e) {
        try {
            double carga1 = Double.parseDouble(carga1Field.getText());
            double pos1 = Double.parseDouble(pos1Field.getText());
            double carga2 = Double.parseDouble(carga2Field.getText());
            double pos2 = Double.parseDouble(pos2Field.getText());
            double carga3 = Double.parseDouble(carga3Field.getText());
            double pos3 = Double.parseDouble(pos3Field.getText());

            // Limites de cargas (entre -1 C e +1 C)
            if (Math.abs(carga1) > 1 || Math.abs(carga2) > 1 || Math.abs(carga3) > 1) {
                resultadoLabel.setText("Erro: cargas devem estar entre -1C e +1C.");
                return;
            }

            // Limites de posições (entre -100 m e +100 m)
            if (pos1 < -100 || pos1 > 100 ||
                pos2 < -100 || pos2 > 100 ||
                pos3 < -100 || pos3 > 100) {
                resultadoLabel.setText("Erro: posições devem estar entre -100m e +100m.");
                return;
            }

            List<Particula> particulas = new ArrayList<>();
            particulas.add(new Particula(carga1, pos1));
            particulas.add(new Particula(carga2, pos2));
            particulas.add(new Particula(carga3, pos3));

            // Verifica se há sobreposição de partículas
            if (ForcaEletrostatica.temParticulasSobrepostas(particulas)) {
                resultadoLabel.setText("Erro: partículas não podem ocupar a mesma posição.");
                return;
            }

            int indice = comboParticula.getSelectedIndex();
            double forca = ForcaEletrostatica.calcularForcaResultante(particulas, indice);

            resultadoLabel.setText(String.format("Força resultante: %.3e N", forca));
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Erro: insira números válidos.");
        } catch (IllegalArgumentException ex) {
            resultadoLabel.setText("Erro: " + ex.getMessage());
        }
    }   
}