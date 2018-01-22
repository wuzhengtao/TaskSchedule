package schedule;

import java.util.List;
import core.*;

public interface ISchedule {
    public Answers taskSchedule (List<Task> tasks, Resource[] res);
}
