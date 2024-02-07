package edu.umb.cs681.hw16.fs;

import edu.umb.cs681.hw16.fs.CrawlingRunnable1;
import edu.umb.cs681.hw16.fs.CrawlingRunnable2;
import edu.umb.cs681.hw16.fs.CrawlingRunnable3;
import edu.umb.cs681.hw16.fs.File;
import edu.umb.cs681.hw16.fs.util.FileCrawlingVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    private static AtomicBoolean done = new AtomicBoolean(false);
   // private static List<File> sharedFiles = new ArrayList<>();

    private static ConcurrentLinkedQueue<File> sharedFiles = new ConcurrentLinkedQueue<>();
    public void setDone(){
        done.getAndSet(true);
    }

    public static void main(String[] args){
        CrawlingRunnable1 crawlingRunnable1 = new CrawlingRunnable1(sharedFiles);
        CrawlingRunnable2 crawlingRunnable2 = new CrawlingRunnable2(sharedFiles);
        CrawlingRunnable3 crawlingRunnable3 = new CrawlingRunnable3(sharedFiles);

        Thread crawl1 = new Thread(crawlingRunnable1);
        Thread crawl2 = new Thread(crawlingRunnable2);
        Thread crawl3 = new Thread(crawlingRunnable3);


        crawl1.start();
        crawl2.start();
        crawl3.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        crawlingRunnable1.setDone();
        crawl1.interrupt();
        crawlingRunnable2.setDone();
        crawl2.interrupt();
        crawlingRunnable3.setDone();
        crawl3.interrupt();

        for(File f:sharedFiles){
            System.out.println(f.getName());
        }


    }


}
