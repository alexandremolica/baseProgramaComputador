package model.dao;

import java.util.List;

import model.entities.BaseProgramaComputadores;

public interface BaseProgramaComputadoresDao {

	List<BaseProgramaComputadores> findAll(String dataTimeInicio, String dataTimeFim);
}
