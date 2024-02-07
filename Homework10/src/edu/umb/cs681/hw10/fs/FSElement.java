package edu.umb.cs681.hw10.fs;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
    protected Directory parent;

    protected ReentrantLock lock;

    public FSElement(Directory parent, String name, int size,LocalDateTime creationTime ){
        this.name=name;
        this.size=size;
        this.creationTime=creationTime;
        this.parent =parent;
        this.lock = new ReentrantLock();
    }

    public Directory getParent(){
        lock.lock();
        try {
            return this.parent;
        }
        finally {
            lock.unlock();
        }
    }
    public void setParent(Directory d){

        lock.lock();
        try {
            this.parent=d;
        }
        finally {
            lock.unlock();
        }
    }
    public int getSize(){
        lock.lock();
        try {
            return this.size;
        }
        finally {
            lock.unlock();
        }
    }
    public String getName(){
        lock.lock();
        try {
            return this.name;
        }
        finally {
            lock.unlock();
        }
    }
    public LocalDateTime getCreationTime(){
        lock.lock();
        try {
            return this.creationTime;
        }
        finally {
            lock.unlock();
        }
    }
    public abstract boolean isDirectory();
    public abstract void accept(FSVisitor v);

}
