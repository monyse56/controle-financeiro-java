import models.Transacao;
import services.ExportadorJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transacao> transacoes = new ArrayList<>();

        System.out.println("Bem-vindo ao Sistema de Controle de Despesas!");
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite o tipo (Receita ou Despesa):");
            String tipo = scanner.nextLine();

            System.out.println("Digite a descrição:");
            String descricao = scanner.nextLine();

            System.out.println("Digite o valor:");
            double valor = Double.parseDouble(scanner.nextLine());

            double data = 0;
            transacoes.add(new Transacao(tipo, descricao, valor, data));

            System.out.println("Deseja adicionar outra transação? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        System.out.println("Transações registradas:");
        for (Transacao t : transacoes) {
            System.out.printf("Tipo: %s | Descrição: %s | Valor: R$%.2f\n", t.getTipo(), t.getDescricao(), t.getValor());
        }

        try {
            ExportadorJson.exportar(transacoes, "transacoes.json");
            System.out.println("Transações exportadas para transacoes.json com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao exportar arquivo JSON: " + e.getMessage());
        }
    }
}
