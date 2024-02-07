package edu.umb.cs681.hw11.fs;

import edu.umb.cs681.hw11.fs.util.FileCrawlingVisitor;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class CrawlingRunnable3 implements Runnable {
    private AtomicBoolean done = new AtomicBoolean(false);
    public void setDone(){
        done.set(true);
    }
    private List<File> sharedFiles;
    private ReentrantLock lock;
    public CrawlingRunnable3(List<File> sharedFiles){
        this.sharedFiles = sharedFiles;
        lock=new ReentrantLock();
    }

    @Override
    public void run() {
        while (true){

                if (done.get()) {
                    System.out.println("Stopping...");
                    break;
                }
                FileCrawlingVisitor crawl = FileCrawlingVisitor.getInstance();
                FileSystem fs3 = TestFixtureInitializer3.createFS();
                Directory prjRoot = fs3.getRootDirs().get(0);
                prjRoot.accept(crawl);
                lock.lock();
                try {
                sharedFiles.addAll(crawl.getFiles());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            finally{
                lock.unlock();
            }
        }
    }
}
