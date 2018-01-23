import core.Answer;
import core.Answers;
import core.Resource;
import core.Task;
import schedule.GreedySchedule;
import schedule.ISchedule;
import util.MathUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static MathUtil mathUtil= new MathUtil();
    public static void main(String[] args) {
        Resource xiaoming = new Resource(1, "xiaoming");
        Resource nil = new Resource(2, "nil");
        Resource[] res = {xiaoming, nil};
        Resource[] resXiaoming = {xiaoming};
        Resource[] resNil = {nil};
        int id = 0;
        String [] nameString = {
                "烧水", "收拾书包", "叠被子", "冲牛奶", "刷牙洗脸", "吃早饭", "洗碗"
        };
        int [] times = {10, 2, 3, 1, 4, 7, 1};
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(++id, nameString[0], times[0], resNil));
        for (int i = 1; i < 7; ++i) {
            tasks.add(new Task(++id, nameString[i], times[i], resXiaoming));
        }
        tasks.get(3).addFatherTask(tasks.get(0));
        tasks.get(0).addChildTask(tasks.get(3));

        tasks.get(5).addFatherTask(tasks.get(3));
        tasks.get(3).addChildTask(tasks.get(5));

        tasks.get(5).addFatherTask(tasks.get(4));
        tasks.get(4).addChildTask(tasks.get(5));

        tasks.get(6).addFatherTask(tasks.get(5));
        tasks.get(5).addChildTask(tasks.get(6));
        ISchedule schedule = new GreedySchedule();

        Answers answers = schedule.taskSchedule(tasks, res);

        mathUtil.printAnswers(answers);
    }
}
