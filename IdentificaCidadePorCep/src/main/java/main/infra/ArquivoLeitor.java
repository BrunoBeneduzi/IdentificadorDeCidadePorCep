package main.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoLeitor {
	
	public List<String> devolveArquivoLido() {
        String caminho = "ceps.txt";
        List<String> linhas = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
        return linhas;
    }
	
}