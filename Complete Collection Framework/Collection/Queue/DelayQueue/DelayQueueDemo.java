package Collection.Queue.DelayQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    //Thread safe unbounded blocking queue of delayed elements
    //Element can only be taken from the queue when their delay has expired
    //useful for scheduling tasks to be executed after a certain delay
    //uses priority queue to manage its elements
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();
        DelayedTask task1 = new DelayedTask("task1", 2, TimeUnit.SECONDS);
        DelayedTask task2 = new DelayedTask("task2", 5, TimeUnit.SECONDS);
        DelayedTask task3 = new DelayedTask("task3", 1, TimeUnit.SECONDS);

        delayQueue.put(task1);
        delayQueue.put(task2);
        delayQueue.put(task3);

        while (!delayQueue.isEmpty()) {
                DelayedTask task = delayQueue.take(); // blocks until a delayed element can be taken
                System.out.println(task.getTaskName() + " is removed from the queue");
        }

    }


}
class DelayedTask implements Delayed {
    private final String taskName;
    private final long delay;

    DelayedTask(String taskName, long delay, TimeUnit unit) {
        this.taskName = taskName;
        this.delay = System.currentTimeMillis() + unit.toMillis(delay);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //time left for the task to be executed
        long timeleft = delay - System.currentTimeMillis();
        return unit.convert(timeleft, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        //compare the tasks based on their start time
        //If the delay of this task is less than the delay of the other task, then this task should be executed
        if (this.delay < ((DelayedTask) o).delay) {
            return -1;
        }
        if (this.delay >((DelayedTask)o).delay){
            return 1;
        }
        return 0;
    }

    public String getTaskName() {
        return taskName;
    }
}