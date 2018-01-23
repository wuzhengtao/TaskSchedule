package schedule;

import java.util.List;
import core.*;

/**
 * 调度方法接口，所有调度方法实现这个接口
 *
 * @author wuzht
 * @version 2018.01.22
 * @date 2018.01.22
 *
 */

public interface ISchedule {
    AnswerMap taskSchedule(List<Task> tasks, Resource[] res);
}
