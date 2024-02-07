package edu.umb.cs681.hw08.fs;

import edu.umb.cs681.hw08.fs.*;
import edu.umb.cs681.hw08.fs.util.FileSearchVisitor;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            FileSystemRunnable fileSystemRunnable = new FileSystemRunnable();
            Thread thread = new Thread(fileSystemRunnable);
            thread.start();
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Since all the Hash codes are same, same object has been created every time");
    }
}