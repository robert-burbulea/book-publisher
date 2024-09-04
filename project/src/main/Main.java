package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class Main {
    public static String addNTabsToEachLine(String s, int N) {
        String[] lines = s.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < N; j++) {
                lines[i] = "\t" + lines[i];
            }
        }
        String newString = "";
        for (int i = 0; i < lines.length; i++) {
            newString += lines[i];
        }
        return newString;
    }

    public static void main(String[] args) {
        try {

            String filename;
            int i;
            Reader reader;
            HashMap<Integer, Book> books;
            HashMap<Integer, Language> languages;
            HashMap<Integer, Author> authors;
            HashMap<Integer, EditorialGroup> editorialGroups;
            HashMap<Integer, PublishingBrand> publishingBrands;
            HashMap<Integer, PublishingRetailer> publishingRetailers;
            HashMap<Integer, Country> countries;

            // reading book.in
            filename = "init\\books.in";
            books = new Reader(filename).readBooks();
            books.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            //reading languages
            filename = "init\\languages.in";
            languages = new Reader(filename).readLanguages();
            languages.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            //reading authors
            filename = "init\\authors.in";
            authors = new Reader(filename).readAuthors();
            authors.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            // reading books-authors
            filename = "init\\books-authors.in";
            reader = new Reader(filename);
            reader.readBooksAuthors(books, authors);
            books.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            //editorial-groups.in
            filename = "init\\editorial-groups.in";
            editorialGroups = new Reader(filename).readEditorialGroups();
            editorialGroups.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            //publishing-brands.in
            filename = "init\\publishing-brands.in";
            publishingBrands = new Reader(filename).readPublishingBrands();
            publishingBrands.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            //editorial-groups-books.in
            filename = "init\\editorial-groups-books.in";
            reader = new Reader(filename);
            reader.readEditorialGroupsBooks(editorialGroups, books);
            editorialGroups.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            //publishing-brands-books.in
            filename = "init\\publishing-brands-books.in";
            reader = new Reader(filename);
            reader.readPublishingBrandsBooks(publishingBrands, books);
            publishingBrands.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            //publishing-retailers.in
            filename = "init\\publishing-retailers.in";
            publishingRetailers = new Reader(filename).readPublishingRetailers();
            publishingRetailers.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            // countries.in
            filename = "init\\countries.in";
            countries = new Reader(filename).readCountries();
            countries.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            // publishing-retailers-countries.in
            filename = "init\\publishing-retailers-countries.in";
            reader = new Reader(filename);
            reader.readPublishingRetailersCountries(publishingRetailers, countries);
            publishingRetailers.entrySet().forEach(entry -> {
                System.out.println(entry.getKey() + " " + entry.getValue());
            });

            //publishing-retailers-books.in
            filename = "init\\publishing-retailers-books.in";
            reader = new Reader(filename);
            reader.readPublishingRetailersBooks(publishingRetailers, books);

            //publishing-retailers-editorial-groups.in
            filename = "init\\publishing-retailers-editorial-groups.in";
            reader = new Reader(filename);
            reader.readPublishingRetailersEditorialGroups(publishingRetailers, editorialGroups);

            // publishing-retailers-publishing-brands.in
            filename = "init\\publishing-retailers-publishing-brands.in";
            reader = new Reader(filename);
            reader.readPublishingRetailersPublishingBrands(publishingRetailers, publishingBrands);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
