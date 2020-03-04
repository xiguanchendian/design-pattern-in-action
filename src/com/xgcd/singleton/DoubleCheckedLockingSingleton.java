package com.xgcd.singleton;

/**
 * 双重锁/双检锁/双重校验锁
 * <p>
 * 也是懒加载的方式
 * 线程安全
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class DoubleCheckedLockingSingleton {
    // 必须使用 volatile 关键字修饰单例变量
    // 作用: 1.保证可见性。使用 volatile 定义的变量，将会保证对所有线程的可见性。
    //      2.禁止指令重排序优化。
    // 由于 volatile 禁止对象创建时指令之间重排序，所以其他线程不会访问到一个未初始化的对象，从而保证安全性。
    // 注意，volatile禁止指令重排序在 JDK 5 之后才被修复
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {

    }

    public static DoubleCheckedLockingSingleton getInstance() {
        // 多线程程序中,不用让每个线程每次都加锁,而只是在实例未被创建的时候再加锁处理.同时也能保证多线程的安全.这种做法被称为 double-checked locking(双重锁定)
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                // 对于instance情况,直接返回instance
                // 当instance为null并且同时有两个线程调用getInstance方法时,他们将都可以通过第一重instance==null的判断
                // 然后由于lock机制,这两个线程则只有一个进入,另一个在外排队等候,必须要其中的一个进入并出来后,另一个才能进入
                // 而此时如果没有了第二重的instance==null的判断,则第一个线程创建了实例,而第二个线程还是可以继续再创建新的实例,这就没有达到单例的目的
                // 所以采用两次instance==null的判断
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
