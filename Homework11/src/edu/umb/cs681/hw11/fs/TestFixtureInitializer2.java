package edu.umb.cs681.hw11.fs;

import java.time.LocalDateTime;

public class TestFixtureInitializer2 {
    public static FileSystem createFS() {
        FileSystem fs1 = FileSystem.getFileSystem();
        Directory prjRoot1 = new Directory(null, "prjRoot", 0, LocalDateTime.now());
        Directory src1 = new Directory(prjRoot1, "src", 0, LocalDateTime.now());
        Directory lib1 = new Directory(prjRoot1, "lib", 0, LocalDateTime.now());
        Directory test1 = new Directory(prjRoot1, "test", 0, LocalDateTime.now());
        Directory test_src1 = new Directory(test1, "test_src", 0, LocalDateTime.now());
        File x1 = new File(prjRoot1, "x1", 5, LocalDateTime.now());
        File a1 = new File(src1, "a1", 5, LocalDateTime.now());
        File b1 = new File(src1, "b1", 5, LocalDateTime.now());

        fs1.appendRoot(prjRoot1);

        prjRoot1.appendChild(src1);
        prjRoot1.appendChild(lib1);
        prjRoot1.appendChild(test1);
        prjRoot1.appendChild(x1);
        src1.appendChild(a1);
        src1.appendChild(b1);
        test1.appendChild(test_src1);

        Link y1 = new Link(prjRoot1, "y", 10, LocalDateTime.now(), test_src1);
        prjRoot1.appendChild(y1);

        return fs1;
    }
}
