package main;

import java.util.HashMap;

public class EditorialGroup implements IPublishingArtifact{
    private int ID;
    private String name;
    private HashMap<Integer, Book> books;

    public EditorialGroup() {
    }

    public EditorialGroup(int ID, String name, HashMap<Integer, Book> books) {
        this.ID = ID;
        this.name = name;
        if (this.books == null) {
            this.books = new HashMap<Integer, Book>();
        } else {
            this.books = books;
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

    public HashMap<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(HashMap<Integer, Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "EditorialGroup{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public String Publish() {
        String s = "<xml>\n";
            s = s + "\t<editorialGroup>\n";
                s = s + "\t\t<ID>" + ID + "</ID>\n";
                s = s + "\t\t<Name>" + name + "</Name>\n";
            s = s + "\t</editorialGroup>\n";
            s = s + "\t<books>\n";
                var ref = new Object() {
                    String booksString = "";
                };
                books.entrySet().forEach(entry -> {
                    ref.booksString = ref.booksString + entry.getValue().bookInfo();
                });
                Main.addNTabsToEachLine(ref.booksString, 2);
                s = s + ref.booksString;
            s = s + "\t</books>\n";
        s = s + "</xml>\n";

        return s;
    }
}
