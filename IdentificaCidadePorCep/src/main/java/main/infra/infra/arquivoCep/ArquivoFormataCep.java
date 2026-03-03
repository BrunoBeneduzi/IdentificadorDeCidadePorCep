package main.infra.infra.arquivoCep;

import java.util.ArrayList;
import java.util.List;

import main.dominio.Cidade;

public class ArquivoFormataCep {
	private Long cepBuscado;
	
	public List<Cidade> devolveCepFormatado(List<String> arquivoCep) {
		List<Cidade> cidade = new ArrayList<>();
		
		for(String c : arquivoCep) {
			
			if(!c.equals("--")) {
				String retiraVirgula[] = c.split(",");
				
				try {
					cidade.add(new Cidade(retiraVirgula[0], Long.parseLong(retiraVirgula[1]), Long.parseLong(retiraVirgula[2])));
				}catch(ArrayIndexOutOfBoundsException e) {
					this.cepBuscado = Long.parseLong(retiraVirgula[0]);
				}
			
			}
		}
		return cidade;
	}

	public Long getCepBuscado() {
		return cepBuscado;
	}
	
	
	
	
}