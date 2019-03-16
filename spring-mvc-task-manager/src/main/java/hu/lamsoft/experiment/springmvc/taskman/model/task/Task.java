package hu.lamsoft.experiment.springmvc.taskman.model.task;

import hu.lamsoft.experiment.springmvc.taskman.dao.impl.BaseEntity;
import hu.lamsoft.experiment.springmvc.taskman.model.assignee.Assignee;

public class Task extends BaseEntity {

    private static final String TASK_INFO_PATTERN = "%s [%s, %s, assigned to %s]";

    private Priority priority;
    private boolean isDisposed;
    private Assignee assignee;

    public void dispose() {
        this.isDisposed = true;
    }

    @Override
    public String toString() {
        return String.format(TASK_INFO_PATTERN, id, priority, getStatus(), assignee.toString());
    }

    private String getStatus() {
        return isDisposed
                ? "disposed"
                : "active";
    }
}
