import core.Answers;
import core.Resource;
import core.Task;

import java.util.List;

public abstract class ASchedule {
    protected boolean[][] childTable;
    public abstract Answers taskSchedule(List<Task> tasks, Resource[] res);

//    protected
}
