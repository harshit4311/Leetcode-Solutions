class FizzBuzz {
    private int n;
    public Semaphore number, fizz, buzz, fizzBuzz;

    public FizzBuzz(int n) {
        this.n = n;
        number = new Semaphore(1);
        fizz = new Semaphore(0);
        buzz = new Semaphore(0);
        fizzBuzz = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 3; i <= n; i += 3) {
            if(i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                number.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                buzz.acquire();
                printBuzz.run();
                number.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i = 15; i <= n; i += 15) {
            fizzBuzz.acquire();
            printFizzBuzz.run();
            number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n ; i++){
            number.acquire();

            if(i % 15 == 0) {
                fizzBuzz.release();
            }
                
            else if(i % 5 == 0) {
                buzz.release();
            }

            else if(i %3 == 0 ) {
                fizz.release();
            }

            else {
                printNumber.accept(i);
                number.release();
            }
        }
    }
}