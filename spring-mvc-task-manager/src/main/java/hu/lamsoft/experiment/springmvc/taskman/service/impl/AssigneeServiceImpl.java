package hu.lamsoft.experiment.springmvc.taskman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.experiment.springmvc.taskman.dao.AssigneeDao;
import hu.lamsoft.experiment.springmvc.taskman.model.assignee.Assignee;
import hu.lamsoft.experiment.springmvc.taskman.service.AssigneeService;

@Service
public class AssigneeServiceImpl implements AssigneeService {

	@Autowired
	private AssigneeDao assigneeDao;
	
	@Override
	public Assignee createAssignee(Assignee assignee) {
		if(assignee.getName() == null || assignee.getName().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		return assigneeDao.create(assignee);
	}

	@Override
	public List<Assignee> getAssignees() {
		return assigneeDao.getAll();
	}

	@Override
	public Assignee getAssignee(int id) {
		return assigneeDao.get(id);
	}

}
