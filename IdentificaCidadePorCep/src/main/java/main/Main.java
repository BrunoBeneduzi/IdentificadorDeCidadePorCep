package main;

import main.dominio.Cidade;
import main.infra.ArquivoLeitor;
import main.infra.VerificaMemoria;
import main.infra.infra.arquivoCep.ArquivoFormataCep;
import main.service.CepVerificador;

public class Main {

	public static void main(String[] args) {
		VerificaMemoria verificadorDeMemoria = new VerificaMemoria();
		
		ArquivoLeitor arquivoLeitor = new ArquivoLeitor();//faz a leitura do arquivo 1 vez
		ArquivoFormataCep cep = new ArquivoFormataCep();//faz a formatação do arquivo
		CepVerificador verifica = new CepVerificador();//faz a verificação de qual cidade pertence o cep
		
		cep.devolveCepFormatado(arquivoLeitor.devolveArquivoLido());
	
		Cidade c = verifica.verificaCep(cep.devolveCepFormatado(arquivoLeitor.devolveArquivoLido()), cep.getCepBuscado());
	
		
		System.out.println("O cep buscado -> " + cep.getCepBuscado() + " Pertence a cidade:  " + c.getCidade() );
		System.out.println("-----------------------------------------------");
		verificadorDeMemoria.verificaMemoria();
	}

}


/*	Etapa 1: Lê os arquivos
 *	
 *	Etapa 2: envia o arquivo lido para uma classe que pega o arquivo e formata ele para o formato de cep e 
 *	guarda o cep que vai procurado.
 *
 *	Etapa 3: envia o arquivo para classe que vai validar as cidades e ver a qual cidade pertence aquele cep
 *	obs:(caso o cep esteja entre digamos 0 - 10 e tenha duas cidades nesse intervalo, ele vai captar essas cidades e 
 *	verificar qual cidade está entre o cep buscado, por exemplo, 0 - 10 | 3 - 5 | o cep é 4, ele vai 
 *	entender que para ser da cidade A, o cep precisa estar entre 0 - 2, e 6 - 10, e para cidade B 3 - 5).
 *	
 *	Etapa 4: ele verifica se existem duas cidades cadastradas, se tiver, ele envia para um método que verifica 
 *	o intervalo dos ceps com o cep e devolve a cidade correta.
 */

