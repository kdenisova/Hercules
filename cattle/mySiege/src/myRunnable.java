import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.lang.*;

public class myRunnable implements Runnable {
    private myStatistics stat;
    public void run(){
        int temp;
        myStatistics s = new myStatistics();
        s.tried = 10;
        s.size = 0;
        s.success = 0;
        s.failed = 0;

        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        for (int i = 0; i < s.tried; i++) {
            s.start = System.currentTimeMillis();
            try {
                temp = Request();
                if (temp > 0) {
                    s.size = s.size + temp;
                    s.success++;
                } else {
                    s.failed++;
                }
            } catch (IOException e) {
                System.out.println("Exception: " + e);
            }
            s.time = s.time + System.currentTimeMillis() - s.start;
        }
        stat = s;
        stat.summary(s);
        //System.out.println("Transactions: " + stat.tried + " hits");
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
}
