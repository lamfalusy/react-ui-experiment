package hu.lamsoft.experiment.springmvc.taskman.service;

import java.util.List;

import hu.lamsoft.experiment.springmvc.taskman.model.assignee.Assignee;

public interface AssigneeService {

	Assignee createAssignee(Assignee assignee);
	
	List<Assignee> getAssignees();

	Assignee getAssignee(int id);
	
}
