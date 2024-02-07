package edu.umb.cs681.hw16.fs;

import edu.umb.cs681.hw16.fs.util.FileCrawlingVisitor;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrawlingRunnable1 implements Runnable {
    private AtomicBoolean done = new AtomicBoolean(false);
    public void setDone(){
        done.getAndSet(true);
    }
    private ConcurrentLinkedQueue<File> sharedFiles;
    public CrawlingRunnable1( ConcurrentLinkedQueue<File> sharedFiles){
        this.sharedFiles = sharedFiles;
    }

    @Override
    public void run() {
        while (true){
            if(done.get()){
                System.out.println("Stopping....");
                break;
            }
            FileCrawlingVisitor crawl = FileCrawlingVisitor.getInstance();
            FileSystem fs1 = TestFixtureInitializer1.createFS();
            Directory prjRoot = fs1.getRootDirs().get(0);
            prjRoot.accept(crawl);
            List<File> files = crawl.getFiles();
            sharedFiles.addAll(files);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
