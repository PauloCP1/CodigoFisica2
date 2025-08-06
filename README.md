[README.md](https://github.com/user-attachments/files/21562090/README.md)
# Calculadora de Força Eletrostática
![Interface da Calculadora](https://github.com/PauloCP1/CodigoFisica2/blob/main/image.png?raw=true)

Este projeto em Java implementa uma calculadora de força eletrostática entre três partículas dispostas ao longo de um eixo x. Ele permite ao usuário inserir posições e cargas das partículas para calcular a força resultante sobre a terceira partícula.

## 📘 Conceito Físico

A força eletrostática entre duas cargas é dada pela Lei de Coulomb:

```
F = k * |q1 * q2| / r²
```

- `F` é a força entre as cargas.
- `k` é a constante eletrostática (9 × 10⁹ N·m²/C²).
- `q1` e `q2` são as cargas em Coulombs.
- `r` é a distância entre as cargas.

Neste projeto, a força sobre a carga `q3` é calculada como a soma vetorial das forças causadas por `q1` e `q2`.

## 💻 Como usar

### Requisitos

- Java 8 ou superior
- IDE como IntelliJ ou Eclipse (opcional)

### Execução

1. Compile o projeto com:
   ```
   javac -d bin src/br/edu/unespar/trabalhofisica2/*.java
   ```

2. Execute com:
   ```
   java -cp bin br.edu.unespar.trabalhofisica2.TrabalhoFisica2
   ```

3. A interface gráfica abrirá. Preencha:
   - As posições (x₁, x₂, x₃) em metros.
   - As cargas (q₁, q₂, q₃) em microcoulombs (μC).
   - Clique em **Calcular** para ver a força resultante.

## 🛑 Limitações

- Não é permitido inserir duas partículas na mesma posição (r = 0).
- Não há suporte para múltiplas dimensões (somente eixo x).
- Cargas e posições devem ser valores numéricos válidos.

## 📁 Estrutura

```
src/
└── br/edu/unespar/trabalhofisica2/
    ├── TrabalhoFisica2.java       # Classe principal (main)
    ├── JanelaPrincipal.java       # Interface gráfica
    ├── CalculadoraEletrostatica.java  # Lógica de cálculo da força
    └── CalculadoraRazao.java      # (Opcional) Cálculo da razão entre q1 e q2 para força nula
```

## ✍️ Autor

- Nome: Paulo Eduardo Martins de Carvalho Surek
- Universidade Estadual do Paraná (UNESPAR)
- Projeto para a disciplina de Física
