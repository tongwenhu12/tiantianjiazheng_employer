package com.tiantianjiazheng.tiantianjiazheng_employer;

import com.google.firebase.firestore.Exclude;


public class Note {
    private String documentId;

    private String location;
    private String pet;

    public Note() {
        //public no-arg constructor needed
    }

    @Exclude
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Note(String location,String pet) {
        this.pet = pet;
        this.location = location;
    }

    public String getName() {
        return pet;
    }

    public String getLocation() {
        return location;
    }
}
