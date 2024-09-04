package main;

import java.util.Arrays;
import java.util.HashMap;

public class PublishingRetailer {
    private int ID;
    private String name;
    private IPublishingArtifact[] publishingArtifacts;
    private HashMap<Integer, Country> countries;

    public PublishingRetailer() {
    }

    public PublishingRetailer(int ID, String name, IPublishingArtifact[] publishingArtifacts, HashMap<Integer, Country> countries) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = publishingArtifacts;
        if (this.countries == null) {
            this.countries = new HashMap<Integer, Country>();
        } else {
            this.countries = countries;
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

    public IPublishingArtifact[] getPublishingArtifacts() {
        return publishingArtifacts;
    }

    public void setPublishingArtifacts(IPublishingArtifact[] publishingArtifacts) {
        this.publishingArtifacts = publishingArtifacts;
    }

    public HashMap<Integer, Country> getCoutries() {
        return countries;
    }

    public void setCoutries(HashMap<Integer, Country> coutries) {
        this.countries = coutries;
    }

    @Override
    public String toString() {
        return "PublishingRetailer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", publishingArtifacts=" + Arrays.toString(publishingArtifacts) +
                ", coutries=" + countries +
                '}';
    }
}
