package edu.umb.cs681.hw08.fs;

import edu.umb.cs681.hw08.fs.Directory;
import edu.umb.cs681.hw08.fs.File;
import edu.umb.cs681.hw08.fs.Link;

public interface FSVisitor {
    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);
}
