package ru.test;

public class Worker3 {

    private final Worker4 worker4;

    public Worker3(Worker4 worker4) {
        this.worker4 = worker4;
    }

    public void work() {
        worker4.work();
    }

}
