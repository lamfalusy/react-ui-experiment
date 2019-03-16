package hu.lamsoft.experiment.springmvc.taskman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.lamsoft.experiment.springmvc.taskman.model.assignee.Assignee;
import hu.lamsoft.experiment.springmvc.taskman.model.assignee.Role;
import hu.lamsoft.experiment.springmvc.taskman.service.AssigneeService;

@Controller
public class AssigneeController {

	@Autowired
	private AssigneeService assigneeService;
	
	@RequestMapping(path = "/assignee/create", method = RequestMethod.GET)
	public ModelAndView getCreateAssigneePage(Assignee assignee) {
		ModelAndView modelAndView = new ModelAndView("createAssignee");
		modelAndView.addObject("allRole", Role.values());
		modelAndView.addObject("assignee", new Assignee());
		return modelAndView;
	}
	
	@RequestMapping(path = "/assignee/create", method = RequestMethod.POST)
	public ModelAndView createAssignee(Assignee assignee) {
		assigneeService.createAssignee(assignee);
		return listAssignee();
	}
	
	@RequestMapping(path = {"/", "/assignee"}, method = RequestMethod.GET)
	public ModelAndView listAssignee() {
		ModelAndView modelAndView = new ModelAndView("listAssignee");
		modelAndView.addObject("allAssignee", assigneeService.getAssignees());
		return modelAndView;
	}
	
}
