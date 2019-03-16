package hu.lamsoft.experiment.springmvc.taskman.dao;

import java.util.List;

import hu.lamsoft.experiment.springmvc.taskman.dao.impl.BaseEntity;
import hu.lamsoft.experiment.springmvc.taskman.dao.impl.exception.RecordDoesNotExistDaoException;

public interface BaseDao<T extends BaseEntity> {

	T create(T t);

	void update(T t) throws RecordDoesNotExistDaoException;

	void delete(int id) throws RecordDoesNotExistDaoException;

	T get(int id);

	List<T> getAll();
	
}
