package schedule;

import core.Answers;
import core.Resource;
import core.Task;
import util.MathUtil;

import java.util.ArrayList;
import java.util.List;

public class GreedySchedule implements ISchedule{
    private boolean[][] childTable;
    private MathUtil mathUtil = new MathUtil();
    private List<Task> taskPool = new ArrayList<>();
    @Override
    public Answers taskSchedule(List<Task> tasks, Resource[] res) {
        childTable = mathUtil.getTaskTable(tasks);
        init(tasks);

        return null;
    }

    private void init (List<Task> tasks) {
        for (int i = 0; i < childTable.length;  ++i) {
            boolean flag = false;
            for (int j = 0; j < childTable.length; ++j) {
                flag |= childTable[j][i];
            }
            if (!flag) tasks.get(i).setStatus(1);//状态1为激活状态
            add2Pool(tasks.get(i));
        }
    }

    private void add2Pool(Task task) {
        for (int k = 0; k < taskPool.size(); ++k) {
            //先判断任务长短，短任务优先，任务长短一样时，判断开始时间，开始时间一样时，有子任务的优先
            if (task.getTime() < taskPool.get(k).getTime()) {
                taskPool.add(k, task);
                break;
            } else if (task.getTime() == taskPool.get(k).getTime()) {
                if (task.getFirstStartTime() < taskPool.get(k).getFirstStartTime()) {
                    taskPool.add(k, task);
                    break;
                }
            } else {
                continue;
            }
        }
    }


}
