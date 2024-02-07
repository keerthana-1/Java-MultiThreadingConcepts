package edu.umb.cs681.hw10.fs;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileSystemRunnable implements Runnable{

    private AtomicBoolean done=new AtomicBoolean(false);

    public void setDone(){
        done.getAndSet(true);
    }

    @Override
    public void run() {
        while(true) {

            if (done.get()) {
                break;
            }
            try {

                FileSystem fs = FileSystem.getFileSystem();
                Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now());
                Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now());
                Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now());
                Directory test = new Directory(prjRoot, "test", 0, LocalDateTime.now());
                Directory test_src = new Directory(test, "test_src", 0, LocalDateTime.now());
                File x = new File(prjRoot, "x", 5, LocalDateTime.now());
                File a = new File(src, "a", 5, LocalDateTime.now());
                File b = new File(src, "b", 5, LocalDateTime.now());
                File c = new File(lib, "c", 5, LocalDateTime.now());
                File d = new File(test_src, "d", 10, LocalDateTime.now());

                fs.appendRoot(prjRoot);

                prjRoot.appendChild(src);
                prjRoot.appendChild(lib);
                prjRoot.appendChild(test);
                prjRoot.appendChild(x);
                src.appendChild(a);
                src.appendChild(b);
                lib.appendChild(c);
                test.appendChild(test_src);
                test_src.appendChild(d);

                Link y = new Link(prjRoot, "y", 10, LocalDateTime.now(), test_src);
                prjRoot.appendChild(y);

                Directory rootdir = fs.getRootDirs().get(0);
                int i = 0;
                for (FSElement f : rootdir.getChildren()) {
                    System.out.println(f.getName());
                    i++;
                }

                System.out.println(rootdir.getTotalSize());

                Directory rootdir1 = fs.getRootDirs().get(0).getSubDirectories().get(2);
                System.out.println(rootdir1.countChildren());
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Interrupted Exception");
            }
            }


    }
}
