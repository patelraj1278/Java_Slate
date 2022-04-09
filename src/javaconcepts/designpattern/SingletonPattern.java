package javaconcepts.designpattern;

/*
Please refer concept Note.
 */
class SingletonPattern {
    private volatile static SingletonPattern _instance;

    private SingletonPattern() {
        // preventing SingletonPattern object instantiation from outside
    }

    /* * 1st version: creates multiple instance if two thread access * this method simultaneously */
    public static SingletonPattern getInstance() {
        if (_instance == null) {
            _instance = new SingletonPattern();
            System.out.println("SingletonPattern Created - Not Thread Safe");
        } return _instance;
    }

    /* * 2nd version : this definitely thread-safe and only * creates one instance of SingletonPattern on concurrent environment * but unnecessarily expensive due to cost of synchronization * at every call. */
    public static synchronized SingletonPattern getInstanceTS() {
        if (_instance == null) {
            _instance = new SingletonPattern();
            System.out.println("SingletonPattern Created - Not Thread Safe But Costly Operation");
        } return _instance;
    }

    /* * 3rd version : An implementation of double checked locking of SingletonPattern. * Intention is to minimize cost of synchronization and improve performance, * by only locking critical section of code, the code which creates instance of SingletonPattern class. * By the way this is still broken, if we don't make _instance volatile, as another thread can * see a half initialized instance of SingletonPattern. */
    public static SingletonPattern getInstanceDC() {
        if (_instance == null) {
            synchronized (SingletonPattern.class) {
                if (_instance == null) {
                    _instance = new SingletonPattern();
                    System.out.println("SingletonPattern Created - Not Thread Safe But NON Costly Operation");
                }
            }
        } return _instance;
    }

    public static void main(String [] args){
        SingletonPattern.getInstanceTS();
        SingletonPattern.getInstance();
        SingletonPattern.getInstanceDC();
    }
}

