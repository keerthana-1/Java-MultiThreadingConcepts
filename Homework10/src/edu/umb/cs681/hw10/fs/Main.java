package edu.umb.cs681.hw10.fs;

import edu.umb.cs681.hw10.fs.*;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {

        FileSystemRunnable fsr1=new FileSystemRunnable();
        FileSystemRunnable fsr2=new FileSystemRunnable();
        FileSystemRunnable fsr3=new FileSystemRunnable();
        FileSystemRunnable fsr4=new FileSystemRunnable();
        FileSystemRunnable fsr5=new FileSystemRunnable();
        FileSystemRunnable fsr6=new FileSystemRunnable();
        FileSystemRunnable fsr7=new FileSystemRunnable();
        FileSystemRunnable fsr8=new FileSystemRunnable();
        FileSystemRunnable fsr9=new FileSystemRunnable();
        FileSystemRunnable fsr10=new FileSystemRunnable();
        FileSystemRunnable fsr11=new FileSystemRunnable();

        Thread t1=new Thread(fsr1);
        Thread t2=new Thread(fsr2);
        Thread t3=new Thread(fsr3);
        Thread t4=new Thread(fsr4);
        Thread t5=new Thread(fsr5);
        Thread t6=new Thread(fsr6);
        Thread t7=new Thread(fsr7);
        Thread t8=new Thread(fsr8);
        Thread t9=new Thread(fsr9);
        Thread t10=new Thread(fsr10);
        Thread t11=new Thread(fsr11);

        t1.start();
        try {
            t1.sleep(1000);
        }
        catch (Exception e){

        }
        fsr1.setDone();
        t1.interrupt();


        t2.start();
        try {
            t2.sleep(1000);
        }
        catch (Exception e){

        }
        fsr2.setDone();
        t2.interrupt();



        t3.start();
        try {
            t3.sleep(1000);
        }
        catch (Exception e){

        }
        fsr3.setDone();
        t3.interrupt();


        t4.start();
        try {
            t4.sleep(1000);
        }
        catch (Exception e){

        }
        fsr4.setDone();
        t4.interrupt();


        t5.start();
        try {
            t5.sleep(1000);
        }
        catch (Exception e){

        }
        fsr5.setDone();
        t5.interrupt();


        t6.start();
        try {
            t6.sleep(1000);
        }
        catch (Exception e){

        }
        fsr6.setDone();
        t6.interrupt();


        t7.start();
        try {
            t7.sleep(1000);
        }
        catch (Exception e){

        }
        fsr7.setDone();
        t7.interrupt();


        t8.start();
        try {
            t8.sleep(1000);
        }
        catch (Exception e){

        }
        fsr8.setDone();
        t8.interrupt();


        t9.start();
        try {
            t9.sleep(1000);
        }
        catch (Exception e){

        }
        fsr9.setDone();
        t9.interrupt();


        t10.start();
        try {
            t10.sleep(1000);
        }
        catch (Exception e){

        }
        fsr10.setDone();
        t10.interrupt();


        t11.start();
        try {
            t11.sleep(1000);
        }
        catch (Exception e){

        }
        fsr11.setDone();
        t11.interrupt();






    }
}