class FooBar {
    private int n;
    
    public CountDownLatch[] latches_after_foo;
    public CountDownLatch[] latches_after_bar;

    public FooBar(int n) {
        this.n = n;

        this.latches_after_foo = new CountDownLatch[n];
        this.latches_after_bar = new CountDownLatch[n];

        for(int i = 0; i < n; i++) {
            latches_after_foo[i] = new CountDownLatch(1);
            latches_after_bar[i] = new CountDownLatch(1);
        }

    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            if(i > 0) {
                latches_after_bar[i - 1].await(); 
            }

        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();

            latches_after_foo[i].countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            latches_after_foo[i].await();

            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();

            latches_after_bar[i].countDown();
        }
    }
}