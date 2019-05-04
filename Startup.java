import java.util.ArrayList;

public class Startup {
    private static final Object sync = new Object();
    private static int executionsLeft;

    public static void main(String[] args) throws InterruptedException {
        final int executions = 2;
        executionsLeft = executions;

        ArrayList<Runner> jobs = new ArrayList<>();

        for (int i = 0; i < executions; i++) {
            Runner r = new Runner(executions);
            jobs.add(r);

            Thread t = new Thread(r);
            t.start();
        }

        waitJobsFinished();

        Statistics totals = new Statistics();
        for (Runner r : jobs) {
            Statistics s = r.getStatistics();

            totals.absord(s);
        }

        System.out.println("----------TOTALS----------");
        System.out.println(totals);
    }

    private static void waitJobsFinished() throws InterruptedException {
        synchronized (sync) {
            do {
                sync.wait();
            } while (--executionsLeft != 0);
        }
    }

    static void jobFinished() {
        synchronized (sync) {
            sync.notify();
        }
    }
}
