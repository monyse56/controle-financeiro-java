package models;

import java.util.List;

public class Relatorio {

    public static void gerarResumo(List<Transacao> transacoes) {
        double totalReceitas = 0;
        double totalDespesas = 0;

        System.out.println("\n=== RELATÓRIO DE TRANSAÇÕES ===");
        for (Transacao t : transacoes) {
            if (t.getTipo().equalsIgnoreCase("Receita")) {
                totalReceitas += t.getValor();
            } else if (t.getTipo().equalsIgnoreCase("Despesa")) {
                totalDespesas += t.getValor();
            }
        }

        double saldoFinal = totalReceitas - totalDespesas;

        System.out.printf("Total de Receitas: R$ %.2f\n", totalReceitas);
        System.out.printf("Total de Despesas: R$ %.2f\n", totalDespesas);
        System.out.printf("Saldo Final: R$ %.2f\n", saldoFinal);
        System.out.println("===============================\n");
    }
}
