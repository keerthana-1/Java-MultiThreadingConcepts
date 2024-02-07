package edu.umb.cs681.hw11.fs;

import java.time.LocalDateTime;

public class Link extends FSElement{

    FSElement target;
    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target){
        super(parent,name,size,creationTime);
        this.target=target;
    }

    public FSElement getTarget(){
        lock.lock();
        try {
            return this.target;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        lock.lock();
        try {
            v.visit(this);
        }
        finally {
            lock.unlock();
        }
    }
}
