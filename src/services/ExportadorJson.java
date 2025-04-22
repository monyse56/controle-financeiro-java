package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Transacao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorJson {
    public static void exportar(List<Transacao> transacoes, String nomeArquivo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(nomeArquivo);
        gson.toJson(transacoes, writer);
        writer.close();
    }
}

