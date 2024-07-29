package com.zyd.shiro.test;


public class Test01 implements Runnable{

    public static String lock = "lock";

    @Override
    public void run() {
//        synchronized (lock){
//        try {
//            Thread.sleep(30000);
////                lock.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
            System.out.println("当前线程："+Thread.currentThread().getName()+"    -初次获得对象锁，调用共享对象的wait   "+"1");


            System.out.println("当前线程："+Thread.currentThread().getName()+"    -再次获得共享对象锁，执行结束   "+"1");
//        }
    }

//    static class Test02 extends Thread{
//        @Override
//        public void run() {
//           synchronized (lock){
//               lock.notifyAll();
//               System.out.println("当前线程："+Thread.currentThread().getName()+"    -获得了对象锁，调用了共享对象的notify   "+"1");
//           }
//        }
//    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        Thread thread01 = new Thread(test01, "线程1");
        Thread thread02 = new Thread(test01, "线程2");
        thread01.start();
        thread02.start();

        try {
            thread01.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程1等待线程2执行完成再执行");
//        Test02 test02 = new Test02();
//        test02.setName("线程3");
//        test02.start();
    }
}
