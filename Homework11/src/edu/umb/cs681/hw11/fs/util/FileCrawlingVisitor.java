package edu.umb.cs681.hw11.fs.util;

import edu.umb.cs681.hw11.fs.Directory;
import edu.umb.cs681.hw11.fs.FSVisitor;
import edu.umb.cs681.hw11.fs.File;
import edu.umb.cs681.hw11.fs.Link;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files=new LinkedList<File>();

    private static ReentrantLock lock=new ReentrantLock();
    private static ThreadLocal<FileCrawlingVisitor> threadLocal = new ThreadLocal<>();
    private FileCrawlingVisitor(){}
    public static FileCrawlingVisitor getInstance(){
        FileCrawlingVisitor crawlingVisitor = threadLocal.get();
        if(crawlingVisitor == null){
            crawlingVisitor = new FileCrawlingVisitor();
            threadLocal.set(crawlingVisitor);
        }
        return crawlingVisitor;
    }
    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        lock.lock();
        try{
            files.add(file);
        }finally {
            lock.unlock();
        }
    }

    public LinkedList<File> getFiles(){
        lock.lock();
        try{
             return files;
        }finally {
            lock.unlock();
        }
    }
}
