package problem115;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean isFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(!isFoo) {
                Thread.sleep(1);
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            isFoo = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(isFoo) {
                Thread.sleep(1);
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            isFoo = true;
        }
    }
}