package edu.umb.cs681.hw11.fs.util;

import edu.umb.cs681.hw11.fs.*;
import edu.umb.cs681.hw11.fs.Directory;
import edu.umb.cs681.hw11.fs.FSVisitor;
import edu.umb.cs681.hw11.fs.File;
import edu.umb.cs681.hw11.fs.Link;

public class CountingVisitor implements FSVisitor {

    private int dirNum=0;
    private int fileNum=0;
    private int linkNum=0;

    @Override
    public void visit(Link link) {
        linkNum++;
    }

    @Override
    public void visit(Directory dir) {
        dirNum++;
    }

    @Override
    public void visit(File file) {
        fileNum++;
    }

    public int getDirNum(){
        return dirNum;
    }
    public int getFileNum(){
        return fileNum;
    }
    public int getLinkNum(){
        return linkNum;
    }
}
