import java.util.Random;

public class Runner implements Runnable {
    private Statistics statistics;

    private final int executions;
    private final Random random = new Random();

    Runner(int executions) {
        this.executions = executions;
    }

    public void run() {
        int failed = 0;
        int successful = 0;
        long sent = 0;

        for (int i = 0; i < executions; i++) {
            System.out.println(String.format("Calling: #%d on Thread: %d", i, Thread.currentThread().getId()));
            try {
                Thread.sleep(100 * (i % 2) * random.nextInt((i + 1)  * 10));

                failed += i % 2;
                successful += i % 3;
                sent += i * (i % 2) * 1000;


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.statistics = new Statistics();

        this.statistics.setFailed(failed);
        this.statistics.setSuccessful(successful);
        this.statistics.setSent(sent);

        Startup.jobFinished();
    }

    Statistics getStatistics() {
        return statistics;
    }
}
