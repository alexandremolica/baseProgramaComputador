package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.dao.BaseProgramaComputadoresDao;
import model.dao.DaoFactory;
import model.entities.BaseProgramaComputadores;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		List<BaseProgramaComputadores> list = new ArrayList<>();
		List<BaseProgramaComputadores> list2 = new ArrayList<>();
		List<BaseProgramaComputadores> list3 = new ArrayList<>();

		System.out.println("==== Inicio ====");

		try {
			System.out.println("==== Cria conexao banco -  1 ====");
			BaseProgramaComputadoresDao baseProgramaComputadoresDao = new DaoFactory().createBaseProgramaComputadoresDao();
			
			
			System.out.println("====  baseProgramaComputadoresDao findAll - lista 1 ====");
			list = baseProgramaComputadoresDao.findAll("2018-01-01 00:00:00" , "2018-04-15 23:59:59");
	
			System.out.println("==== Cria conexao banco -  2 ====");
			BaseProgramaComputadoresDao baseProgramaComputadoresDao2 = new DaoFactory().createBaseProgramaComputadoresDao();
			
			System.out.println("====  baseProgramaComputadoresDao findAll - lista 2 ====");
			list2 = baseProgramaComputadoresDao2.findAll("2018-04-16 00:00:00" , "2018-08-15 23:59:59");
	
			System.out.println("==== Cria conexao banco -  3 ====");
			BaseProgramaComputadoresDao baseProgramaComputadoresDao3 = new DaoFactory().createBaseProgramaComputadoresDao();
			
			System.out.println("====  baseProgramaComputadoresDao findAll - lista 3 ====");
			list3 = baseProgramaComputadoresDao3.findAll("2018-08-16 00:00:00" , "2018-12-31 23:59:59");
	
			
		}
		
		finally {
			System.out.println("====  Fecha conexão com o banco====");
			DB.closeConnection();
			
		}
		
		System.out.println("====  Concatena listas ====");
		list.addAll(list2);
		list.addAll(list3);

		//////////////////////
		// Gerar arquivo CSV
		//////////////////////
		System.out.println();
		System.out.println("== GERAR ARQUIVO CSV ==");
		
		String path2 = "c:\\temp\\csv-baseProgramaComputadores.csv";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path2))){
			//Linha de titulos do arquivo
			bw.write(
							"NumeroDoRegistro |"
							+ "DataDoDeposito |" 
							+ "Linguagem |"
							+ "CampoDeAplicacao |"
							//+ "DescricaoDoCampoDeAplicacao |"
							+ "TituloDoPrograma |"
							+ "TipoDePrograma |"
							//+ "DescricaoDoTipoDePrograma |"
							+ "NomeDoTitular |"
							+ "NomeDoAutor |"
							+ "NomeProcurador |"
							+ "NumeroDaRPI |"
							+ "DataDaPublicacaoRPI |"
							+ "NumeroDoDespacho |"
							+ "DescricaoDoDespacho |"
							+ "ComplementoDoDespacho |"
							+ "DataDeLancamento |"
							+ "DataProtocoloExterno |"
							+ "CodigoSigiloDoPrograma"
					);
			bw.newLine();
			
			//Linha de dados
			for(BaseProgramaComputadores obj : list) {
				bw.write(setDetailFileLine(obj));
				bw.newLine();
			}

			
		}
		catch(IOException e) {
			e.printStackTrace();
			sc.close();
		}
		
		sc.close();
		System.out.println("==== SUCESSO ====");

	}
	
	public static String setDetailFileLine (BaseProgramaComputadores base){
		String line;
		line =  base.getNumeroDoRegistro()+" |"
				+ base.getDataDoDeposito()+" |" 
				+ base.getLinguagem()+"|"
				+ base.getCampoDeAplicacao()+" |"
				//+ base.getDescricaoDoCampoDeAplicacao()+"|"
				+ base.getTituloDoPrograma()+" |"
				+ base.getTipoDePrograma()+" |"
				//+ base.getDescricaoDoTipoDePrograma()+"|"
				+ base.getNomeDoTitular()+" |"
				+ base.getNomeDoAutor()+" |"
				+ base.getNomeProcurador()+" |"
				+ base.getNumeroDaRPI()+" |"
				+ base.getDataDaPublicacaoRPI()+" |"
				+ base.getNumeroDoDespacho()+" |"
				+ base.getDescricaoDoDespacho()+" |"
				+ base.getComplementoDoDespacho()+" |"
				+ base.getDataDeLancamento()+" |"
				+ base.getDataProtocoloExterno()+" |"
				+ base.getCodigoSigiloDoPrograma();
		
		line = line.replaceAll("\r", "");
		line = line.replaceAll("\t", "");
		line = line.replaceAll("\n", "");
				
		return line;
	}
	

}
