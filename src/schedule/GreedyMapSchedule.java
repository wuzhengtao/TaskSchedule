package schedule;

import core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心算法做任务调度
 * @ProjectName: Task Schedule
 * @Author wuzht
 * @CreateDate: 2018/1/23 上午11:52
 * @UpdateUser: wuzht
 * @UpdateDate: 2018/1/23 上午11:52
 */

public class GreedyMapSchedule implements ISchedule{
    private List<Task> taskPool = new ArrayList<>();
    private AnswerMap answerMap = new AnswerMap();

    @Override
    public AnswerMap taskSchedule(List<Task> tasks, Resource[] res) {
        init(tasks);
        for (Resource resource : res) {
            answerMap.put(resource, new Answer(resource));
        }

        while (!taskPool.isEmpty()) {
            Task task4Schedule;
            int i;
            for (i = 0; i < taskPool.size(); ++i) {
                Answer tempAnswer = answerMap.get(taskPool.get(i).getRes()[0]);
                if (taskPool.get(i).getFirstStartTime() <= tempAnswer.getCostTime()) {
                    break;
                }
            }
            if (i == taskPool.size()) {
                i = 0;
                answerMap.get(taskPool.get(0).getRes()[0]).getRes().setFinalTime(taskPool.get(0).getFirstStartTime());
            }

            task4Schedule = taskPool.remove(i);

            updateTask2finish(task4Schedule, answerMap.get(task4Schedule.getRes()[0]));
        }

        return answerMap;
    }
    /**
     * 任务的初始化，没有父任务的任务将率先加入到任务池
     */
    private void init (List<Task> tasks) {
        //对任务初始化，没有父任务的任务直接激活并放入任务池
        for (Task task : tasks) {
            if (task.getFatherTask().size() == 0) {
                task.setStatus(1);//状态1为激活状态
                add2Pool(task);
            }

        }
    }

    /**
        将已激活任务加入到任务池，等待调度。
     */
    private void add2Pool(Task task) {
        //将任务按顺序放入任务池
        if (taskPool.size() == 0) {
            taskPool.add(task);
            return;
        }
        for (int k = 0; k < taskPool.size(); ++k) {
            //先判断任务长短，短任务优先，任务长短一样时，判断开始时间
            if (task.getTime() < taskPool.get(k).getTime()) {
                taskPool.add(k, task);
                break;
            } else if (task.getTime() == taskPool.get(k).getTime()) {
                if (task.getFirstStartTime() < taskPool.get(k).getFirstStartTime()) {
                    taskPool.add(k, task);
                    break;
                }
            }
        }
    }

    /**
     *  将调度完成的任务更新状态以及完成时间
     */
    private void updateTask2finish(Task task, Answer answer) {
        task.setStatus(2);
        answer.addTask(task);
        long finishTime = answer.getCostTime();
        answer.getRes().setFinalTime(finishTime + task.getTime());
        task.setFinishTime(finishTime + task.getTime());
        updateChildTask(task);
    }

    /**
     *  更新子任务，检查所有父任务已调度完成，则更新成激活状态
     */
    private void updateChildTask(Task task) {
        for (Task childTask : task.getChildTask()) {
            boolean flag = true;
            long firstStartTime = 0;
            for (Task fatherTask : childTask.getFatherTask()) {
                flag = (fatherTask.getStatus() == 2);
                firstStartTime =
                        firstStartTime > fatherTask.getFinishTime() ?
                                firstStartTime : fatherTask.getFinishTime();
                if (!flag)break;
            }
            if (flag) {
                childTask.setFirstStartTime(firstStartTime);
                childTask.setStatus(1);
                add2Pool(childTask);
            }
        }
    }
}
