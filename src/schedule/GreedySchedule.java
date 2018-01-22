package schedule;

import core.Answer;
import core.Answers;
import core.Resource;
import core.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心算法做任务调度
 *
 * @author wuzht
 * @version 2018.01.22
 * @date 2018.01.22
 *
 */

public class GreedySchedule implements ISchedule{
    private List<Task> taskPool = new ArrayList<>();//任务池
    private List<Answer> answerList = new ArrayList<>();//结果列表
    private Answers answers;
    /*
        贪心算法调度，短作业优先
     */
    @Override
    public Answers taskSchedule(List<Task> tasks, Resource[] res) {
        init(tasks);
        //初始化Answers 和 Answer
        for (Resource resource : res) {
            answerList.add(new Answer(resource));
        }
        answers = new Answers(answerList);
        while (!taskPool.isEmpty()) {
            //从任务池取出一个任务，并且判断，循环
            Task task4Schedule;
            int i = 0;//获取对应任务
            int j = 0;//获取对应answer
            for (; i < taskPool.size(); ++i) {
                //遍历Answers里的Answer，看看有没有符合条件的，如果有，就跳出循环，继续往下。
                boolean flag = false;
                List<Answer> tempAnswer = answers.getAnswer();
                for (j = 0; j < tempAnswer.size(); ++j) {
                    if (tempAnswer.get(j).getRes() == taskPool.get(i).getRes()[0]) {
                        if (taskPool.get(i).getFirstStartTime() <= tempAnswer.get(j).getRes().getFinalTime()) {
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag) break;
            }
            if (i == taskPool.size()) {
                i = 0;
                for (j = 0; j < answers.getAnswer().size(); ++j) {
                    if (answers.getAnswer().get(j).getRes() == taskPool.get(i).getRes()[0]) {
                        break;
                    }
                }
                System.out.println(taskPool.get(i).getFirstStartTime());
                answers.getAnswer().get(j).getRes().setFinalTime(taskPool.get(i).getFirstStartTime());
            }
            //取出任务，将任务从任务池中清除
            task4Schedule = taskPool.remove(i);//获取待分配任务

            //更新任务及资源
            updateTask2finish(task4Schedule, answers.getAnswer().get(j));
        }

        return answers;
    }

    /*
        将调度完成的任务更新状态以及完成时间
     */
    private void updateTask2finish(Task task, Answer answer) {
        task.setStatus(2);
        answer.addTask(task);
        long finishTime = answer.getRes().getFinalTime();
        answer.getRes().setFinalTime(finishTime + task.getTime());
        task.setFinishTime(finishTime + task.getTime());
        updateChildTask(task);
    }

    /*
        更新子任务，检查所有父任务已调度完成，则更新成激活状态
     */
    private void updateChildTask(Task task) {
        for (Task childTask : task.getChildTask()) {
            boolean flag = true;
            long firstStartTime = 0;
            for (Task fatherTask : childTask.getFatherTask()) {
                flag = flag & (fatherTask.getStatus() == 2);
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

    /*
        任务的初始化，没有父任务的任务将率先加入到任务池
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

    /*
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


}
