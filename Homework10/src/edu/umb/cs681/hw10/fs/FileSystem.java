package edu.umb.cs681.hw10.fs;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;

public class FileSystem {

    LinkedList<Directory> rootdirs=new LinkedList<Directory>();

    //static ReentrantLock lock=new ReentrantLock();
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
        return rootdirs;
    }

    public void appendRoot(Directory root){
        if(root.parent==null)
            rootdirs.add(root);
    }


}
