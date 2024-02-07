package edu.umb.cs681.hw08.fs;

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
        return this.children;
    }

    public int countChildren(){
        return this.children.size();
    }

    public void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
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
        v.visit(this);
        for(FSElement e:children){
            e.accept(v);
        }
    }

}
