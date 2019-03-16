package hu.lamsoft.experiment.springmvc.taskman.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import hu.lamsoft.experiment.springmvc.taskman.dao.BaseDao;
import hu.lamsoft.experiment.springmvc.taskman.dao.impl.exception.RecordDoesNotExistDaoException;

public class InMemoryDao<T extends BaseEntity> implements BaseDao<T> {

	protected Map<Integer, T> map = new ConcurrentHashMap<>();
	protected AtomicInteger idSequence = new AtomicInteger(0);
	
	@Override
	public T create(T t) {
		t.id = idSequence.incrementAndGet();
		map.put(t.id, t);
		return t;
	}

	@Override
	public void update(T t) throws RecordDoesNotExistDaoException {
		if(!map.keySet().contains(t.getId())) {
			throw new RecordDoesNotExistDaoException("Record does not exist with id: " + t.getId());
		}
		map.put(t.getId(), t);
	}

	@Override
	public void delete(int id) throws RecordDoesNotExistDaoException {
		if(map.remove(id) == null) {
			throw new RecordDoesNotExistDaoException("Record does not exist with id: " + id);
		}
	}

	@Override
	public T get(int id) {
		return map.get(id);
	}

	@Override
	public List<T> getAll() {
		return new ArrayList<>(map.values());
	}
	
}
