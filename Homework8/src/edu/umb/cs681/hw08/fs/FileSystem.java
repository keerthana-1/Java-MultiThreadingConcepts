package edu.umb.cs681.hw08.fs;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystem {

    LinkedList<Directory> rootdirs=new LinkedList<Directory>();

    static ReentrantLock lock=new ReentrantLock();
    private static FileSystem instance=null;
    private FileSystem(){
    }

    public static FileSystem getFileSystem(){
        lock.lock();
        try {
            if (instance == null) {
                instance = new FileSystem();
            }
            return instance;
        }
        finally{
            lock.unlock();
        }
    }

    public LinkedList<Directory> getRootDirs(){
        return rootdirs;
    }

    public void appendRoot(Directory root){
        if(root.parent==null)
            rootdirs.add(root);
    }


}
