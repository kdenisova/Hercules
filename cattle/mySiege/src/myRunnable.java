import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.lang.*;
import java.util.Random;

public class myRunnable implements Runnable {
    private myStatistics stat;
    private final int executions;
    private final Random random = new Random();

    myRunnable(int executions) {
        this.executions = executions;
    }

    public void run() {
        int temp;
        int successful = 0;
        int failed = 0;
        long size = 0;
        long start = 0;
        long time = 0;

        for (int i = 0; i < executions; i++) {
            System.out.printf(String.format("Calling #%d on Thread #%d", i, Thread.currentThread().getId()));
            start = System.currentTimeMillis();
            try {
                temp = Request();
                if (temp > 0) {
                    size = size + temp;
                    successful++;
                } else {
                    failed++;
                }
            } catch (IOException e) {
                System.out.println("Exception: " + e);
            }
            time = time + System.currentTimeMillis() - start;
        }

        this.stat = new myStatistics();
        this.stat.setSuccessful(successful);
        this.stat.setFailed(failed);
        this.stat.setSize(size);
        this.stat.setStart(start);
        this.stat.setTime(time);

        mySiege.jobFinished();
    }

    private static int Request() throws IOException {
        int size = 0;
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://fancycoder.net");
        try {
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                size = response.getAllHeaders().length;
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
        return (size);
    }

    myStatistics getStatistics() {
        return stat;
    }
}
