package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Book implements IPublishingArtifact {
    private int ID;
    private String name;
    private String subtitle;
    private String ISBN;
    private int pageCount;
    private String keywords;
    private int languageID;
    private Date createdOn;
    private HashMap<Integer, Author> authors;

    public Book() {
    }

    public Book(int ID, String name, String subtitle, String ISBN, int pageCount, String keywords, int languageID,
                Date createdOn, HashMap<Integer, Author> authors) {
        this.ID = ID;
        this.name = name;
        this.subtitle = subtitle;
        this.ISBN = ISBN;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;

        if (this.authors == null) {
            this.authors = new HashMap<Integer, Author>();
        } else {
            this.authors = authors;
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLanguageID() {
        return languageID;
    }

    public void setLanguageID(int languageID) {
        this.languageID = languageID;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public HashMap<Integer, Author> getAuthors() {
        return authors;
    }

    public void setAuthors(HashMap<Integer, Author> author) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", pageCount=" + pageCount +
                ", keywords='" + keywords + '\'' +
                ", languageID=" + languageID +
                ", createdOn=" + new SimpleDateFormat("dd.MM.yyyy' 'hh:mm:ss").format(createdOn) +
                ", author=" + authors +
                '}';
    }

    @Override
    public String Publish() {
        String s = "<xml>\n";
        s = s + "\t<title>" + name + "</title>\n";
        s = s + "\t<subtitle>" + subtitle + "</subtitle>\n";
        s = s + "\t<isbn>" + ISBN + "</isbn>\n";
        s = s + "\t<pageCount>" + pageCount + "</pageCount>\n";
        s = s + "\t<keywords>" + keywords + "</keywords>\n";
        s = s + "\t<languageID>" + languageID + "</languageID>\n";
        s = s + "\t<createdOn>" + createdOn + "<createdOn>\n";
        s = s + "\t<authors>" + authors + "<authors>\n";
        s = s + "</xml";

        return s;
    }

    public String bookInfo() {
        String s = "<book>\n";
        s = s + "\t<title>" + name + "</title>\n";
        s = s + "\t<subtitle>" + subtitle + "</subtitle>\n";
        s = s + "\t<isbn>" + ISBN + "</isbn>\n";
        s = s + "\t<pageCount>" + pageCount + "</pageCount>\n";
        s = s + "\t<keywords>" + keywords + "</keywords>\n";
        s = s + "\t<languageID>" + languageID + "</languageID>\n";
        s = s + "\t<createdOn>" + createdOn + "<createdOn>\n";
        s = s + "\t<authors>" + authors + "<authors>\n";
        s = s + "<book>\n";
        return s;
    }
}
