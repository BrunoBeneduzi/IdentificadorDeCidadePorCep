package main.dominio;

public class Cidade {
	private String cidade;
	private Long cepInicial, cepFinal;
	
	public Cidade() {}
	
	public Cidade(String cidade, Long cepInicial, Long cepFinal) {
		this.cidade = cidade;
		this.cepInicial = cepInicial;
		this.cepFinal = cepFinal;
	}

	public String getCidade() {return cidade;}
	
	public void setCidade(String cidade) {this.cidade = cidade;}
	
	public Long getCepInicial() {return cepInicial;}
	
	public void setCepInicial(Long cepInicial) {this.cepInicial = cepInicial;}
	
	public Long getCepFinal() {return cepFinal;}
	
	public void setCepFinal(Long cepFinal) {this.cepFinal = cepFinal;}
	
	@Override
	public String toString() {
		return "Cidade [cidade=" + cidade + ", cepInicial=" + cepInicial + ", cepFinal=" + cepFinal + "]";
	}
	
	
}