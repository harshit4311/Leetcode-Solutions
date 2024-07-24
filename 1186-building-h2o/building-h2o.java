class H2O {
    Semaphore hydrogen_semaphore;
    Semaphore oxygen_semaphore;

    public H2O() {
        hydrogen_semaphore = new Semaphore(2);
        oxygen_semaphore = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hydrogen_semaphore.acquire();

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();

        oxygen_semaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen_semaphore.acquire(2);

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();

        hydrogen_semaphore.release(2);
    }
}