import models.Relatorio;
import models.Transacao;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SistemaFinanceiro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transacao> transacoes = new ArrayList<>();
        boolean executando = true;

        System.out.println("=== SISTEMA DE CONTROLE FINANCEIRO ===");

        while (executando) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Adicionar Receita");
                System.out.println("2. Adicionar Despesa");
                System.out.println("3. Ver Relatório");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        adicionarTransacao("Receita", scanner, transacoes);
                        break;
                    case 2:
                        adicionarTransacao("Despesa", scanner, transacoes);
                        break;
                    case 3:
                        Relatorio.gerarResumo(transacoes);
                        break;
                    case 4:
                        executando = false;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: você deve digitar um número válido.");
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada. Tente novamente.");
                scanner.nextLine(); // limpa buffer
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void adicionarTransacao(String tipo, Scanner scanner, List<Transacao> transacoes) {
        try {
            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();

            System.out.print("Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());

            System.out.print("Data (YYYY-MM-DD): ");
            String data = scanner.nextLine();

            Transacao t = new Transacao(tipo, descricao, valor, data);
            transacoes.add(t);
            System.out.println(tipo + " adicionada com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: o valor deve ser um número decimal válido.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar transação: " + e.getMessage());
        }
    }
}

