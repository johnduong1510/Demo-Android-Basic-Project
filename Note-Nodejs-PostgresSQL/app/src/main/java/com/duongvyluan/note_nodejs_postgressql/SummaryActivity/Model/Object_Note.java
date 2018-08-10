package com.duongvyluan.note_nodejs_postgressql.SummaryActivity.Model;

/**
 * Created by JohnDuong on 21-Sep-17.
 */

public class Object_Note {
    private String titleNote;
    private int ID;
    private String contentNote;


    public Object_Note() {
        this.titleNote="";
        this.contentNote="";
        this.ID=0;
    }

    public Object_Note(int ID, String titleNote,  String contentNote) {

        this.titleNote = titleNote;
        this.ID = ID;
        this.contentNote = contentNote;
    }

    public String getTitleNote() {

        return titleNote;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContentNote() {
        return contentNote;
    }

    public void setContentNote(String contentNote) {
        this.contentNote = contentNote;
    }


}
