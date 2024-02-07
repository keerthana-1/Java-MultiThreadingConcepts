package edu.umb.cs681.hw16.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer3 {

    public static FileSystem createFS() {
        FileSystem fs2 = FileSystem.getFileSystem();
        Directory prjRoot2 = new Directory(null, "prjRoot", 0, LocalDateTime.now());
        Directory src2 = new Directory(prjRoot2, "src", 0, LocalDateTime.now());
        Directory lib2 = new Directory(prjRoot2, "lib", 0, LocalDateTime.now());
        Directory test2 = new Directory(prjRoot2, "test", 0, LocalDateTime.now());
        Directory test_src2 = new Directory(test2, "test_src", 0, LocalDateTime.now());
        File x2 = new File(prjRoot2, "x2", 5, LocalDateTime.now());
        File a2 = new File(src2, "a2", 5, LocalDateTime.now());
        File b2= new File(src2, "b2", 5, LocalDateTime.now());

        fs2.appendRoot(prjRoot2);

        prjRoot2.appendChild(src2);
        prjRoot2.appendChild(lib2);
        prjRoot2.appendChild(test2);
        prjRoot2.appendChild(x2);
        src2.appendChild(a2);
        src2.appendChild(b2);
        test2.appendChild(test_src2);

        Link y2 = new Link(prjRoot2, "y", 10, LocalDateTime.now(), test_src2);
        prjRoot2.appendChild(y2);
        return fs2;
    }
}
