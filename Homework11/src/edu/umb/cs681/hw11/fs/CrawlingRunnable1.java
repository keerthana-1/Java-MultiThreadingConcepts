package edu.umb.cs681.hw11.fs;

import edu.umb.cs681.hw11.fs.util.FileCrawlingVisitor;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class CrawlingRunnable1 implements Runnable {
    private AtomicBoolean done = new AtomicBoolean(false);
    public void setDone(){
        done.set(true);
    }

    private ReentrantLock lock;
    private List<File> sharedFiles;
    public CrawlingRunnable1( List<File> sharedFiles){
        this.sharedFiles = sharedFiles;
        lock=new ReentrantLock();
    }

    @Override
    public void run() {
        while (true) {
                if (done.get()) {
                    System.out.println("Stopping....");
                    break;
                }
                FileCrawlingVisitor crawl = FileCrawlingVisitor.getInstance();
                FileSystem fs1 = TestFixtureInitializer1.createFS();
                Directory prjRoot = fs1.getRootDirs().get(0);
                prjRoot.accept(crawl);
                lock.lock();
                try {
                sharedFiles.addAll(crawl.getFiles());
            try{
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
            finally {
                lock.unlock();
            }
        }
    }
}
