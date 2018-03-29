package com.Type;

/**
 * Created by Administrator on 2018\3\19 0019.
 */

public class Bookdirectory {
    private String BookName;
    private String DirectoryName;

    public Bookdirectory(String bookName, String directoryName) {
        BookName = bookName;
        DirectoryName = directoryName;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getDirectoryName() {
        return DirectoryName;
    }

    public void setDirectoryName(String directoryName) {
        DirectoryName = directoryName;
    }
}
