package edu.umb.cs681.hw11.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> children;
    public static int size=0;
    public Directory(Directory parent, String name, int size,LocalDateTime creationTime){
        super(parent,name,size,creationTime);
        children = new LinkedList<>();
    }

    public LinkedList<FSElement> getChildren(){

        lock.lock();
        try {
            return this.children;        }
        finally {
            lock.unlock();
        }
    }

    public int countChildren(){

        lock.lock();
        try {
            return this.children.size();
        }
        finally {
            lock.unlock();
        }
    }

    public void appendChild(FSElement child){

        lock.lock();
        try {
            this.children.add(child);
            child.setParent(this);
        }
        finally {
            lock.unlock();
        }
    }

    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subdirlist=new LinkedList<Directory>();
        int cnt=0;
        for(FSElement fs:getChildren()){
            if(fs.isDirectory()) {
                subdirlist.add((Directory) fs);
                //System.out.println(subdirlist.get(cnt).name);
                cnt++;
            }
        }
        return subdirlist;
    }

    public LinkedList<FSElement> getFiles(){
        lock.lock();
        try{
        LinkedList<FSElement> fileslist=new LinkedList<FSElement>();
        int cnt=0;
        for(FSElement fs:getChildren()){
            if(!fs.isDirectory()) {
                fileslist.add(fs);
               // System.out.println(fileslist.get(cnt).name);
                cnt++;
            }
        }
        return fileslist;
    }finally {
            lock.unlock();
        }
        }

    public int getTotalSize(){
        int total_size=0;
        for(FSElement f:getChildren()){
            if(f instanceof Directory) {
                total_size = total_size + ((Directory)f).getTotalSize();
            }
            else{
                total_size = total_size +f.getSize();
            }
        }
        return total_size;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public void accept(FSVisitor v) {
        lock.lock();
        try {
            v.visit(this);
            for (FSElement e : children) {
                e.accept(v);
            }
        }
        finally {
            lock.unlock();
        }
    }

}
