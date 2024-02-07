package edu.umb.cs681.hw11.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer1 {

    public static FileSystem createFS(){


        FileSystem fs = FileSystem.getFileSystem();
        Directory prjRoot = new Directory(null, "prjRoot", 0, LocalDateTime.now());
        Directory src = new Directory(prjRoot, "src", 0, LocalDateTime.now());
        Directory lib = new Directory(prjRoot, "lib", 0, LocalDateTime.now());
        Directory test = new Directory(prjRoot, "test", 0, LocalDateTime.now());
        Directory test_src = new Directory(test, "test_src", 0, LocalDateTime.now());
        File x = new File(prjRoot, "x", 5, LocalDateTime.now());
        File a = new File(src, "a", 5, LocalDateTime.now());
        File c = new File(src, "c", 5, LocalDateTime.now());

        fs.appendRoot(prjRoot);

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(x);
        src.appendChild(a);
        src.appendChild(c);
        test.appendChild(test_src);

        Link y = new Link(prjRoot, "y", 10, LocalDateTime.now(), test_src);
        prjRoot.appendChild(y);

        return fs;
    }
}
