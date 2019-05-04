import java.util.ArrayList;

public class mySiege {
    private static final Object sync = new Object();
    private static int left;

    public static void main (String [] args) {
        final int executions = 3;
        int hits = executions * executions;
        long start1;
        long elapsed;
        left = executions;

        myStatistics totals = new myStatistics();
        ArrayList<myRunnable> jobs = new ArrayList<>();

        System.out.println("The server is now under siege...");
        start1 = System.currentTimeMillis();
        for (int i = 0; i < executions; i++) {
            myRunnable r = new myRunnable(executions);
            jobs.add(r);

            Thread t = new Thread(r);
            t.start();
        }
        waitJobs();
        elapsed = System.currentTimeMillis() - start1;

        for (myRunnable r : jobs) {
            myStatistics stat = r.getStatistics();
            totals.summary(stat);
        }
        System.out.println("Transactions: " + hits + " hits");
        System.out.println(String.format("Elapsed time = %.2f sec", elapsed * 0.001));
        System.out.println("Data transferred: " + totals.getSize() + " bytes");
        System.out.println(String.format("Response time: %.2f sec", totals.getTime() / (hits * 0.001)));
        System.out.println(String.format("Transaction rate: %.2f trans/sec", hits / (elapsed * 0.001)));
        System.out.println(String.format("Throughput: %.2f bytes/sec", totals.getSize() / (elapsed * 0.001)));
        System.out.println("Status code 200: " + totals.getSuccessful());
        System.out.println("Successful transactions: " + totals.getSuccessful());
        System.out.println("Failed transactions: " + totals.getFailed());
    }

    private static void waitJobs() throws InterruptedException {
        synchronized (sync) {
            do {
                sync.wait();
            } while (--left != 0);
        }
    }

    static void jobFinished() {
        synchronized (sync) {
            sync.notify();
        }
    }
}
