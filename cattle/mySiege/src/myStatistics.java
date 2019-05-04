public class myStatistics {
    int success;
    int failed;
    int tried;
    long size;
    long start;
    long time;

    public void summary(myStatistics other) {
        success = success + other.success;
        failed = failed + other.failed;
        tried = tried + other.tried;
        size = size + other.size;
        start = start + other.start;
        time = time + other.time;
    }
}

