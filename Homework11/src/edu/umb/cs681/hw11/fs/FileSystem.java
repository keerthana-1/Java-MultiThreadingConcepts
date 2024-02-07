package edu.umb.cs681.hw11.fs;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystem {

    LinkedList<Directory> rootdirs=new LinkedList<Directory>();

    private static ReentrantLock lock=new ReentrantLock();
   // private static FileSystem instance=null;

    private static AtomicReference<FileSystem> instance = new AtomicReference<>(null);;

    private FileSystem(){

    }

    public static FileSystem getFileSystem(){
            if (instance.get() == null) {
                instance.getAndSet(new FileSystem());
            }
            return instance.get();

    }

    public LinkedList<Directory> getRootDirs(){
        lock.lock();
        try {
            return rootdirs;
        }
        finally {
            lock.unlock();
        }
    }

    public void appendRoot(Directory root){
        lock.lock();
        try {
            if (root.parent == null)
                rootdirs.add(root);
        }
        finally {
            lock.unlock();
        }
    }


}
