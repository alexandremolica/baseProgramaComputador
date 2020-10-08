package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DB;
import db.DbException;
import model.dao.BaseProgramaComputadoresDao;
import model.entities.BaseProgramaComputadores;

public class BaseProgramaComputadoresDaoJDBC implements BaseProgramaComputadoresDao {
	Scanner sc = new Scanner(System.in);
	private Connection conn;

	private String sqlPrincipal = 		
			"SELECT  prg_regist_program.no_regist\r\n" + 
			"       ,prg_regist_program.dt_entrad_dimapro\r\n" + 
			"       ,substr(prg_regist_program.tx_titulo_program,1,200) tx_titulo_program\r\n" + 
			"       ,prg_regist_program.dt_lanc_program\r\n" + 
			"       ,prg_regist_program.dt_protoc_externo\r\n" + 
			"       ,prg_regist_program.cd_sigilo_program\r\n" + 
			"       ,substr(prg_pfpj_procurador.nm_pfpj_compl,1,200) Nome_procurador\r\n" + 
			"       ,crp_programa_rpi.no_rpi Numero_da_RPI\r\n" + 
			"       ,crp_programa_rpi.dt_publica_ptn Data_da_publicacao_RPI\r\n" + 
			"       ,prg_despach.cd_despach Numero_do_despacho\r\n" + 
			"       ,substr(prg_despach.tx_despach,1,450) Descricao_do_despacho\r\n" + 
			"       ,prg_despach.ds_despach[1,450] Complemento_do_despacho\r\n" + 
			"       ,prg_regist_program.cd_regist_program \r\n" + 
			"FROM prg_regist_program\r\n" + 
			"-- procurador\r\n" + 
			"LEFT JOIN prg_procura_regist\r\n" + 
			"        ON prg_regist_program.cd_regist_program = prg_procura_regist.cd_regist_program\r\n" + 
			"LEFT JOIN prg_pfpj prg_pfpj_procurador\r\n" + 
			"        ON prg_procura_regist.cd_pfpj_program = prg_pfpj_procurador.cd_pfpj\r\n" + 
			"--RPI\r\n" + 
			"INNER JOIN prg_histor_regist\r\n" + 
			"        ON prg_regist_program.cd_regist_program = prg_histor_regist.cd_regist_program\r\n" + 
			"INNER JOIN crp_programa_rpi\r\n" + 
			"        ON prg_histor_regist.no_rpi= crp_programa_rpi.no_rpi\r\n" + 
			"--Despacho prg_histor_regist\r\n" + 
			"INNER JOIN prg_despach\r\n" + 
			"        ON prg_histor_regist.cd_despach = prg_despach.cd_despach\r\n" + 
			"WHERE prg_regist_program.dt_entrad_dimapro BETWEEN ? AND ?  \r\n" + 
			"--WHERE prg_regist_program.dt_entrad_dimapro BETWEEN '2018-01-01 00:00:00' AND '2018-6-30 23:59:59'\r\n" + 
			"--WHERE prg_regist_program.no_regist = '512018000824'  \r\n"  ;
	

	private String sqlLinguagem = 		
			"SELECT trim(substr(prg_linguag_progra.nm_linguag_program,1,50)) Linguagem \r\n" + 
			"		FROM prg_linguag_regist\r\n" + 
			"		INNER JOIN prg_linguag_progra\r\n" + 
			"		        ON prg_linguag_regist.cd_linguag_program = prg_linguag_progra.cd_linguag_program\r\n" + 
			"		WHERE prg_linguag_regist.cd_regist_program = ?  ";


	private String sqlAplicacao = 				
			"SELECT  substr(prg_campo_aplic.cd_campo_aplic,1,10) Campo_de_aplicacao \r\n" + 
			"    --   ,prg_campo_aplic.ds_campo_aplic[1,50] Descricao_do_campo_de_aplicacao\r\n" + 
			"FROM prg_aplic_regist\r\n" + 
			"INNER JOIN prg_campo_aplic\r\n" + 
			"        ON prg_aplic_regist.cd_campo_aplic = prg_campo_aplic.cd_campo_aplic\r\n" + 
			"WHERE prg_aplic_regist.cd_regist_program = ?  ";
	
	private String sqlPrograma =
			"SELECT  substr(prg_tipo_program.cd_tipo_program,1,10) Tipo_de_programa \r\n" + 
			"     --  ,substr(prg_tipo_program.ds_tipo_program,1,200) Descricao_do_tipo_de_programa\r\n" + 
			"FROM prg_tipo_regist\r\n" + 
			"INNER JOIN prg_tipo_program\r\n" + 
			"        ON prg_tipo_regist.cd_tipo_program = prg_tipo_program.cd_tipo_program\r\n" + 
			"WHERE prg_tipo_regist.cd_regist_program = ? ";  
    
	private String sqlAutor =
			"SELECT   trim(substr(prg_pfpj_autor.nm_pfpj_compl,1,200))  Nome_do_autor \r\n" + 
			"FROM prg_autor_regist\r\n" + 
			"INNER JOIN prg_pfpj prg_pfpj_autor\r\n" + 
			"        ON prg_autor_regist.cd_pfpj_program = prg_pfpj_autor.cd_pfpj\r\n" + 
			"WHERE prg_autor_regist.cd_regist_program = ? ";  
		
	private String sqlTitular =
			"	SELECT  substr(prg_pfpj_titular.nm_pfpj_compl,1,200) Nome_do_titular\r\n" + 
			"	FROM prg_titular_regist\r\n" + 
			"	INNER JOIN prg_pfpj prg_pfpj_titular\r\n" + 
			"	        ON prg_titular_regist.cd_pfpj_program = prg_pfpj_titular.cd_pfpj\r\n" + 
			"	WHERE prg_titular_regist.cd_regist_program = ?  ";

	

	public BaseProgramaComputadoresDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<BaseProgramaComputadores> findAll(String dataTimeInicio, String dataTimeFim){
		List<BaseProgramaComputadores> list = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
 		
		
		try {
	
			pst = conn.prepareStatement(sqlPrincipal);
			pst.setString(1, dataTimeInicio);
			pst.setString(2, dataTimeFim);

			rs = pst.executeQuery();
						
			/*-------------------------------------------*
			 * Configura Principal                       *
			 *-------------------------------------------*/ 
			while (rs.next()) {
				
				BaseProgramaComputadores obj = instanciaBaseProgramaComputadores(rs);	
				list.add(obj);
			}
			
			DB.closePrepareStatement(pst);
			DB.closeResultSet(rs);

			/*-------------------------------------------*
			 * Configura Detalhes                        *
			 *-------------------------------------------*/ 
			for(BaseProgramaComputadores obj : list) {
				
				// Linguagem
				obj.setLinguagem( getDetalhesEmUmaLinha(obj.getCdRegistProgram(),sqlLinguagem, "Linguagem"));
			
				//Aplicacao
				obj.setCampoDeAplicacao( getDetalhesEmUmaLinha(obj.getCdRegistProgram(),sqlAplicacao, "Campo_de_aplicacao"));
				
				//Programa
				obj.setTipoDePrograma( getDetalhesEmUmaLinha(obj.getCdRegistProgram(),sqlPrograma, "Tipo_de_programa"));
				
				//Autor
				obj.setNomeDoAutor ( getDetalhesEmUmaLinha(obj.getCdRegistProgram(),sqlAutor, "Nome_do_autor"));
	
				//Titular
				obj.setNomeDoTitular( getDetalhesEmUmaLinha(obj.getCdRegistProgram(),sqlTitular, "Nome_do_titular"));
	
			}
			
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closePrepareStatement(pst);
			//DB.closeConnection();
		}
		
	}	

	private BaseProgramaComputadores instanciaBaseProgramaComputadores(ResultSet rs) throws SQLException {
		BaseProgramaComputadores obj = new BaseProgramaComputadores();
		String tituloPrograma="";

		tituloPrograma = rs.getString("tx_titulo_program");
		tituloPrograma = tituloPrograma.replaceAll("[^a-zZ-Z1-9 ]", "");
		
		obj.setNumeroDoRegistro(rs.getString("no_regist"));
		obj.setDataDoDeposito(rs.getString("dt_entrad_dimapro"));
		obj.setTituloDoPrograma(tituloPrograma); 
		obj.setDataDeLancamento(rs.getString("dt_lanc_program")); 
		obj.setDataProtocoloExterno(rs.getString("dt_protoc_externo"));
		obj.setCodigoSigiloDoPrograma(rs.getString("cd_sigilo_program"));
		//obj.setNomeDoTitular(rs.getString("Nome_do_titular")); 
		obj.setNomeProcurador(rs.getString("Nome_procurador"));
		obj.setNumeroDaRPI(rs.getString("Numero_da_RPI"));
		obj.setDataDaPublicacaoRPI(rs.getString("Data_da_publicacao_RPI")); 
		obj.setNumeroDoDespacho(rs.getString("Numero_do_despacho")); 
		obj.setDescricaoDoDespacho(rs.getString("Descricao_do_despacho"));
		obj.setComplementoDoDespacho(rs.getString("Complemento_do_despacho"));
		obj.setCdRegistProgram(rs.getString("cd_regist_program"));
		return obj;
		
	}
	
	private String getDetalhesEmUmaLinha(String cdRegistProgram, String sql, String sqlColuna) {
		String resultado = "";
 		ResultSet rsDet = null;
 		
		PreparedStatement stDet = null;
		
		try {
			
			stDet = conn.prepareStatement(sql);
			stDet.setString(1, cdRegistProgram);

			rsDet = stDet.executeQuery();

			while (rsDet.next()) {
				if (resultado.equals("")) {
					resultado = rsDet.getString(sqlColuna);
				}
				else {
					resultado += " / "+ rsDet.getString(sqlColuna);
				}
			}
			
			if(resultado == null) {
				resultado = "";
			}
			if(resultado.length() > 450){            
				 resultado = resultado.substring(0, 450) + "...";
		     }
		    
			resultado = resultado.replaceAll("\r", "");
			resultado = resultado.replaceAll("\t", "");
			resultado = resultado.replaceAll("\n", "");
			resultado =	resultado.replaceAll("|", " ");
			
			return resultado;
		               
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rsDet);
			DB.closePrepareStatement(stDet);
		}
	}

}
