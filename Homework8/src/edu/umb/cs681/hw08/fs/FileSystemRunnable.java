package edu.umb.cs681.hw08.fs;

public class FileSystemRunnable implements Runnable{
    @Override
    public void run() {
        FileSystem fileSystem = FileSystem.getFileSystem();
        System.out.println(fileSystem.hashCode());
    }
}

