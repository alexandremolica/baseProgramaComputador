package model.dao;

import db.DB;
import model.dao.impl.BaseProgramaComputadoresDaoJDBC;

public class DaoFactory {
	
	 public static BaseProgramaComputadoresDao createBaseProgramaComputadoresDao() {
		return new BaseProgramaComputadoresDaoJDBC(DB.getConnection());
	}

	 
}
