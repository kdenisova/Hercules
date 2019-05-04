public class mySiege {
    //private myStatistics stat;
    public static void main (String [] args) {
        long start1;
        long elapsed;

        myStatistics s = new myStatistics();

        System.out.print("The server is now under siege...");
        start1 = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            Thread object = new Thread(new myRunnable());
            object.start();
        }
        elapsed = System.currentTimeMillis() - start1;
        System.out.println("done");
        s.summary(s);
        System.out.println("Transactions: " + s.tried + " hits");
//        System.out.println("Elapsed time = " +  Math.round((elapsed * 0.001) * 100.0)/100.0 + " sec");
//        System.out.println("Data transferred: " + s.size + " bytes");
//        System.out.println("Response time: " + Math.round((s.time / s.tried * 0.001) * 100.0)/100.0 + " sec");
//        System.out.println("Transaction rate: " + Math.round((s.tried / (elapsed * 0.001)) * 100.0)/100.0 + " trans/sec");
//        System.out.println("Throughput: " + Math.round((s.size / (elapsed * 0.001)) * 100.0)/100.0 + " bytes/sec");
//        System.out.println("Status code 200: " + s.success);
//        System.out.println("Successful transactions: " + s.success);
//        System.out.println("Failed transactions: " + s.failed);


    }


}
