package com.cin.interview;

import java.util.concurrent.Semaphore;

/**
 * 写一个多线程程序，有5个线程，每个线程打印a-z，希望打印的结果为aaaaabbbbb….zzzzz
 */
public class XinYeInterview {

        private static final int N = 5;

        private static Semaphore[] semaphores = new Semaphore[N];

        public static void main(String[] args) {
            try {
                new XinYeInterview().test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void test() throws InterruptedException {
            for (int i = 0; i < N; i++) {
                semaphores[i] = new Semaphore(1);
                if (i > 0) semaphores[i].acquire();
            }
            for (int i = 0; i < N; i++) {
                Semaphore cur = semaphores[i];
                Semaphore next = i == N - 1 ? semaphores[0] : semaphores[i + 1];
                new Thread(new task(cur, next), "Thread-" + i + "：").start();
            }
        }


        static class task implements Runnable {

            private final Semaphore current;
            private final Semaphore next;
            private int count = 0;
            private char a = 'a';

            public task(Semaphore curSemaphore, Semaphore nextSemaphore) {
                this.current = curSemaphore;
                this.next = nextSemaphore;
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        current.acquire();
                        if (count >= 26) break;
                        System.out.println(Thread.currentThread().getName() + (char) (a + count++));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        next.release();
                    }
                }
            }
        }

}
