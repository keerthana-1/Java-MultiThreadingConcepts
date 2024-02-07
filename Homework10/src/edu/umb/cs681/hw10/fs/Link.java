package edu.umb.cs681.hw10.fs;

import java.time.LocalDateTime;

public class Link extends FSElement{

    private FSElement target;
    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target){
        super(parent,name,size,creationTime);
        this.target=target;
    }

    public FSElement getTarget(){
        lock.lock();
        try {
            return this.target;
        }finally {
            lock.unlock();
        }

    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }
}
