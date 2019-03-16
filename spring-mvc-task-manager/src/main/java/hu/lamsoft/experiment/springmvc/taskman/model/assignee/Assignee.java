package hu.lamsoft.experiment.springmvc.taskman.model.assignee;

import hu.lamsoft.experiment.springmvc.taskman.dao.impl.BaseEntity;

public class Assignee extends BaseEntity {

    private String name;
    private Role role;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
    public String toString() {
        return name + "(" + role + ")";
    }

}
