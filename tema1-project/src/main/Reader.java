package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Reader {
    String filename;
    public FileReader fr;
    public BufferedReader br;

    public Reader(String filename) throws FileNotFoundException {
        this.filename = filename;
        fr = new FileReader(filename);
        br = new BufferedReader(fr);
    }

    public void readHeader() throws IOException {
        String line;
        String[] words;
        int i;

        line = br.readLine();
        words = line.split("###");
        for (i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
    }

    public HashMap<Integer, Book> readBooks() throws IOException, ParseException {
        String line;
        String[] words;
        int i;
        HashMap<Integer, Book> books = new HashMap<Integer, Book>();

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int ID = Integer.parseInt(words[0]);
            String name = words[1];
            String subtitle = words[2];
            String ISBN = words[3];
            int pageCount = Integer.parseInt(words[4]);
            String keywords = words[5];
            int languageID = Integer.parseInt(words[6]);
            Date createdOn = new SimpleDateFormat("dd.MM.yyyy' 'hh:mm:ss").parse(words[7]);

            Book newBook = new Book(ID, name, subtitle, ISBN, pageCount, keywords, languageID, createdOn, null);
            books.put(ID, newBook);
        }
        return books;
    }

    public HashMap<Integer, Language> readLanguages() throws IOException {
        String line;
        String[] words;
        int i;
        HashMap<Integer, Language> languages = new HashMap<Integer, Language>();

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int ID = Integer.parseInt(words[0]);
            String code = words[1];
            String name = words[2];
            Language newLanguage = new Language(ID, code, name);
            languages.put(ID, newLanguage);
        }
        return languages;
    }

    public HashMap<Integer, Author> readAuthors() throws IOException {
        String line;
        String[] words;
        int i;
        HashMap<Integer, Author> authors = new HashMap<Integer, Author>();

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int ID = Integer.parseInt(words[0]);
            String firstName = words[1];
            String lastName = words[2];
            Author newAuthor = new Author(ID, firstName, lastName);
            authors.put(ID, newAuthor);
        }
        return authors;
    }

    public void readBooksAuthors(HashMap<Integer, Book> books, HashMap<Integer, Author> authors) throws IOException {
        String line;
        String[] words;
        int i;

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int bookID = Integer.parseInt(words[0]);
            int authorID = Integer.parseInt(words[1]);
            Author author = authors.get(authorID);

            books.get(bookID).getAuthors().put(authorID, author);
        }
    }

    public HashMap<Integer, EditorialGroup> readEditorialGroups() throws IOException {
        String line;
        String[] words;
        int i;
        HashMap<Integer, EditorialGroup> editorialGroups = new HashMap<Integer, EditorialGroup>();

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int ID = Integer.parseInt(words[0]);
            String name = words[1];
            HashMap<Integer, Book> books = null;
            EditorialGroup newEditorialGroup = new EditorialGroup(ID, name, books);
            editorialGroups.put(ID, newEditorialGroup);
        }
        return editorialGroups;
    }

    public HashMap<Integer, PublishingBrand> readPublishingBrands() throws IOException {
        String line;
        String[] words;
        int i;
        HashMap<Integer, PublishingBrand> publishingBrands = new HashMap<Integer, PublishingBrand>();

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int ID = Integer.parseInt(words[0]);
            String name = words[1];
            HashMap<Integer, Book> books = null;
            PublishingBrand newPublishingBrand = new PublishingBrand(ID, name, books);
            publishingBrands.put(ID, newPublishingBrand);
        }
        return publishingBrands;
    }

    public void readEditorialGroupsBooks(HashMap<Integer, EditorialGroup> editorialGroups,
                                         HashMap<Integer, Book> books) throws IOException {
        String line;
        String[] words;
        int i;

        this.readHeader();

        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int groupID = Integer.parseInt(words[0]);
            int bookID = Integer.parseInt(words[1]);
            Book book = books.get(bookID);


            // if a group has more books, we'll add each book in its own key
            editorialGroups.get(groupID).getBooks().put(bookID, book);
        }
    }

    public void readPublishingBrandsBooks(HashMap<Integer, PublishingBrand> publishingBrands,
                                          HashMap<Integer, Book> books) throws IOException {
        String line;
        String[] words;
        int i;

        this.readHeader();

        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int publisherID = Integer.parseInt(words[0]);
            int bookID = Integer.parseInt(words[1]);
            Book book = books.get(bookID);

            // if a group has more books, we'll add each book in its own key
            publishingBrands.get(publisherID).getBooks().put(bookID, book);
        }
    }

    public HashMap<Integer, PublishingRetailer> readPublishingRetailers() throws IOException {
        String line;
        String[] words;
        int i;
        HashMap<Integer, PublishingRetailer> publishingRetailers = new HashMap<Integer, PublishingRetailer>();

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int ID = Integer.parseInt(words[0]);
            String name = words[1];
            PublishingRetailer newPublishingRetailer = new PublishingRetailer(ID, name, null, null);
            publishingRetailers.put(ID, newPublishingRetailer);
        }
        return publishingRetailers;
    }

    public HashMap<Integer, Country> readCountries() throws IOException {
        String line;
        String[] words;
        int i;
        HashMap<Integer, Country> countries = new HashMap<Integer, Country>();

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int ID = Integer.parseInt(words[0]);
            String countryCode = words[1];
            Country newCountry = new Country(ID, countryCode);
            countries.put(ID, newCountry);
        }
        return countries;
    }

    public void readPublishingRetailersCountries(HashMap<Integer, PublishingRetailer> publishingRetailers,
                                                 HashMap<Integer, Country> countries) throws IOException {
        String line;
        String[] words;
        int i;

        this.readHeader();
        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int retailerID = Integer.parseInt(words[0]);
            int countryID = Integer.parseInt(words[1]);
            Country country = countries.get(countryID);

            // if a group has more books, we'll add each book in its own key
            publishingRetailers.get(retailerID).getCoutries().put(countryID, country);
        }
    }

    public void readPublishingRetailersBooks(HashMap<Integer, PublishingRetailer> publishingRetailers,
                                             HashMap<Integer, Book> books) throws IOException {
        String line;
        String[] words;
        int i;

        this.readHeader();

        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int retailerID = Integer.parseInt(words[0]);
            int bookID = Integer.parseInt(words[1]);
            Book book = books.get(bookID);
            //System.out.println(book.Publish());

        }
    }

    public void readPublishingRetailersEditorialGroups(HashMap<Integer, PublishingRetailer> publishingRetailers,
                                                       HashMap<Integer, EditorialGroup> editorialGroups) throws IOException {
        String line;
        String[] words;
        int i;

        this.readHeader();

        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int retailerID = Integer.parseInt(words[0]);
            int groupID = Integer.parseInt(words[1]);
            EditorialGroup editorialGroup = editorialGroups.get(groupID);

            //System.out.println(editorialGroup.Publish());
        }
    }

    public void readPublishingRetailersPublishingBrands(HashMap<Integer, PublishingRetailer> publishingRetailers,
                                                        HashMap<Integer, PublishingBrand> publishingBrands) throws IOException {
        String line;
        String[] words;
        int i;
        this.readHeader();

        while (((line = br.readLine())) != null) {
            words = line.split("###");
            int retailerID = Integer.parseInt(words[0]);
            int publisherID = Integer.parseInt(words[1]);
            PublishingBrand publisherBrand = publishingBrands.get(publisherID);

            System.out.println(publisherBrand.Publish());
        }
    }
}
