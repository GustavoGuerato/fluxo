package fluxoCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {

  public static void main(String[] args) {
    Scanner terminal = new Scanner(System.in);
    boolean continuar = true;

    while (continuar) {
      try {
        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = lerParametro(terminal);

        System.out.println("Digite o segundo parâmetro:");
        int parametroDois = lerParametro(terminal);

        // Chamando o método contendo a lógica de contagem
        contar(parametroUm, parametroDois);

        // Perguntar ao usuário se deseja continuar
        System.out.println("Deseja inserir outro par de parâmetros? (s/n)");
        String resposta = terminal.next();
        if (!resposta.equalsIgnoreCase("s")) {
          continuar = false;
        }
      } catch (ParametrosInvalidosException e) {
        System.out.println(e.getMessage());
      } catch (InputMismatchException e) {
        System.out.println(
          "Entrada inválida. Por favor, insira um número inteiro."
        );
        terminal.next(); // Limpar o buffer do scanner
      }
    }

    terminal.close();
  }

  static int lerParametro(Scanner terminal) {
    while (true) {
      try {
        return terminal.nextInt();
      } catch (InputMismatchException e) {
        System.out.println(
          "Entrada inválida. Por favor, insira um número inteiro."
        );
        terminal.next(); // Limpar o buffer do scanner
      }
    }
  }

  static void contar(int parametroUm, int parametroDois)
    throws ParametrosInvalidosException {
    // Validar se parametroUm é MAIOR que parametroDois e lançar a exceção
    if (parametroUm > parametroDois) {
      throw new ParametrosInvalidosException(
        "O segundo parâmetro deve ser maior que o primeiro"
      );
    }

    // Calcular a quantidade de interações
    int contagem = parametroDois - parametroUm;

    // Realizar o for para imprimir os números com base na variável contagem
    for (int i = 1; i <= contagem; i++) {
      System.out.println("Imprimindo o número " + i);
    }
  }
}
