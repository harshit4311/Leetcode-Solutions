class Foo {

    public CountDownLatch latch_after_first;
    public CountDownLatch latch_after_second;

    public Foo() {
        latch_after_first = new CountDownLatch(1);
        latch_after_second = new CountDownLatch(1);

    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        latch_after_first.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch_after_first.await();

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        latch_after_second.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch_after_second.await();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}