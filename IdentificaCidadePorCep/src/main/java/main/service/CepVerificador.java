package main.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import main.dominio.Cidade;

public class CepVerificador {
	
	public Cidade verificaCep(List<Cidade> cidades, Long cepBuscado) {
		List<Cidade> cepsEncontrados = new ArrayList<>();
		
		for(Cidade c : cidades) {//separa as cidades que estão entre o cep buscado
			
			if(separaCidadesQueEstaoEntreCep(c, cepBuscado)) {
				cepsEncontrados.add(c);
				
			}
		}
	
		if(cepsEncontrados.size() >= 2) {//se o cep estiver entre duas cidades, ele entra aqui para verificar qual das cidades o cep está realmente vinculado
			cepsEncontrados.sort(Comparator.comparing(Cidade::getCepInicial));//aqui ele coloca em ordem crescente os ceps iniciais, se o arquivo trouxe os ceps fora de ordem, ele ordena com base no cep inicial da cidade

			return decideQualCidadePertenceAoCep(cepsEncontrados, cepBuscado);
			
			}else {
					if(cepsEncontrados.size() != 0) {//verifica se a lista não está zerada
						return cepsEncontrados.get(0);
					}
					System.out.println("O cep não existe ou foi digitado errado, tenta novamente");
					return null;	
		}
		
	}
	
	private Boolean separaCidadesQueEstaoEntreCep(Cidade cid,Long cepBuscado) {//verifica se o cep está entre mais de uma cidade
		
		if(cepBuscado >= cid.getCepInicial() && cepBuscado <= cid.getCepFinal()) {
		
			return true;
		}
		return false;
	}
	
	private Cidade decideQualCidadePertenceAoCep(List<Cidade> cidade, Long cepBuscado) {
		Cidade cidadeEncontrada;
		
		cidadeEncontrada = verificaCidadeInicial(cidade, cepBuscado);
		
		if(cidadeEncontrada != null) {
			return cidadeEncontrada;
		}
		
		cidadeEncontrada = verificaCidadeInicialEfinal(cidade, cepBuscado);
		
		if(cidadeEncontrada != null) {
			return cidadeEncontrada;
		}
		
		return null;
	}
	
	private Cidade verificaCidadeInicial(List<Cidade> cidade, Long cepBuscado) {
		
		for(int i = 0; i < cidade.size() - 1; i++) {
			
			/*
			aqui ele pega o cep buscado, digamos 350 e verifica se o cep inicial da cidade que foi encontrado é maior ou igual a 350, e se 
			a outra cidade tem o cep menor que 350, assim verificando se o cep buscado pertence a uma das cidades iniciais
			
			*/
			if(cepBuscado >= cidade.get(i).getCepInicial() && cepBuscado < cidade.get(i+1).getCepInicial()) {
				return cidade.get(i);
			}
		}
		return null;
	}

	private Cidade verificaCidadeInicialEfinal(List<Cidade> cidade, Long cepBuscado) {
		
		if(cidade.size() == 2) {//se a lista que contem os ceps tiverem duas cidades, vai entrar aqui
			if(cepBuscado >= cidade.get(cidade.size()/2).getCepInicial() && cepBuscado <= cidade.get(cidade.size()/2).getCepFinal() ) {
				return cidade.get(cidade.size()/2);
			}
		}else {//caso tenho mais de duas cidades,digamos A,B,C a lista teria o tamanho de 3
			if(cepBuscado >= cidade.get(cidade.size()/2 + 1).getCepInicial() && cepBuscado <= cidade.get(cidade.size()/2 + 1).getCepFinal() ) {
				return cidade.get(cidade.size()/2 + 1);
			}
		}
	
		return null;
	}

}
