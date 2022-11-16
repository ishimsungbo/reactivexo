package com.spr.reactivexo.spt;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class Thread_Edu01 extends Thread {

    @Override
    public void run() {
        log.info(LocalDateTime.now() + " Thread is started");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info(LocalDateTime.now() + " Thread is exiting");
    }

    public static void main(String[] args) throws InterruptedException{

        Thread_Edu01 t = new Thread_Edu01();
        log.info(LocalDateTime.now() + " Starting is thread");
        t.start();

        //log.info(LocalDateTime.now() + " Waiting is thread");
        //t.join();
        log.info(LocalDateTime.now() + " alive:" + t.isAlive());    // join 사용하면 main 쓰레드가 기다리고 Thread_Edu01 가 끝날때 까지 기다림 false

        /**
         *  다음과 같이 Thread_Edu01 를 생성하고 start()로 실행하면 main 과 Thread_Edu01 라는 두개의 쓰레드가 동시에 실행되게 된다.
         *  main 쓰레드에서 thread.join()을 호출하면 Thread_Edu01 가 종료될 때까지 기다리게 된다.
         *
         *  만약 주석을 하고 join를 사용하지 않게 되면 메인은 실행 종료가 되고
         *  main Thread 는 Thread_Edu01 가 종료되는 것을 무시하고 다음 작업을 수행하게 됩니다.
         */

    }
}
