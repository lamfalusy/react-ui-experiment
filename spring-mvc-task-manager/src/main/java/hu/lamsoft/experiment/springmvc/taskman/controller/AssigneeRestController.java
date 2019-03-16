package hu.lamsoft.experiment.springmvc.taskman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.experiment.springmvc.taskman.model.assignee.Assignee;
import hu.lamsoft.experiment.springmvc.taskman.model.assignee.Role;
import hu.lamsoft.experiment.springmvc.taskman.service.AssigneeService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AssigneeRestController {

	@Autowired
	private AssigneeService assigneeService;
	
	@GetMapping(path = "/role")
	public List<Role> getRoles() {
		return Arrays.asList(Role.values());
	}

	@PostMapping(path = "/assignee")
	public Assignee createAssignee(@RequestBody Assignee assignee) {
		return assigneeService.createAssignee(assignee);
	}
	
	@GetMapping(path = "/assignee")
	public List<Assignee> listAssignee() {
		return assigneeService.getAssignees();
	}

	@GetMapping(path = "/assignee/{assigneeId}")
	public Assignee getAssignee(@PathVariable("assigneeId") int id) {
		return assigneeService.getAssignee(id);
	}

}
