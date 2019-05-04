public final class Statistics {
    private int Successful;
    private int Failed;
    private long Sent;

    int getSuccessful() {
        return Successful;
    }

    int getFailed() {
        return Failed;
    }

    long getSent() {
        return Sent;
    }

    void setSuccessful(int successful) {
        Successful = successful;
    }

    void setFailed(int failed) {
        Failed = failed;
    }

    void setSent(long sent) {
        Sent = sent;
    }

    void absord(Statistics other) {
        Successful += other.Successful;
        Failed += other.Failed;
        Sent += other.Sent;
    }

    @Override
    public String toString() {
        return "Successful: " + this.getSuccessful() + " Failed: " + this.getFailed() + " Sent: " + this.getSent();
    }
}
