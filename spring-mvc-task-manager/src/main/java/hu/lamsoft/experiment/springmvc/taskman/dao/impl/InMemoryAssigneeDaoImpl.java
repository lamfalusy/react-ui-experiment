package hu.lamsoft.experiment.springmvc.taskman.dao.impl;

import hu.lamsoft.experiment.springmvc.taskman.dao.AssigneeDao;
import hu.lamsoft.experiment.springmvc.taskman.model.assignee.Assignee;
import org.springframework.stereotype.Component;

@Component
public class InMemoryAssigneeDaoImpl extends InMemoryDao<Assignee> implements AssigneeDao {

}
