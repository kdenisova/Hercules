public final class myStatistics {
    private int Successful;
    private int Failed;
    private long Size;
    private long Start;
    private long Time;

    int getSuccessful() {
        return Successful;
    }

    int getFailed() {
        return Failed;
    }

    long getSize() {
        return Size;
    }

    long getStart() {
        return Start;
    }

    long getTime() {
        return Time;
    }

    void setSuccessful(int successful) {
        Successful = successful;
    }

    void setFailed(int failed) {
      Failed = failed;
    }

    void setSize(long size) {
        Size = size;
    }

    void setStart(long start) {
        Start = start;
    }

    void setTime(long time) {
        Time = time;
    }

    void summary(myStatistics other) {
        Successful += other.Successful;
        Failed += other.Failed;
        Size += other.Size;
        Start += other.Start;
        Time += other.Time;
    }
}

