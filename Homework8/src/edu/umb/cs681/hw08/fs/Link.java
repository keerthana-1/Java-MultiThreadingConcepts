package edu.umb.cs681.hw08.fs;

import java.time.LocalDateTime;

public class Link extends FSElement{

    FSElement target;
    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target){
        super(parent,name,size,creationTime);
        this.target=target;
    }

    public FSElement getTarget(){
        return this.target;
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
