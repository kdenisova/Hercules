public final class myStatistics {
    private int Successful;
    private int Failed;
    private float Size;
    private long Time;

    int getSuccessful() {
        return Successful;
    }

    int getFailed() {
        return Failed;
    }

    float getSize() {
        return Size;
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

    void setSize(float size) {
        Size = size;
    }

    void setTime(long time) {
        Time = time;
    }

    void summary(myStatistics other) {
        Successful += other.Successful;
        Failed += other.Failed;
        Size += other.Size;
        Time += other.Time;
    }
}

