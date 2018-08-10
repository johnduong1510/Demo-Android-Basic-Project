package com.example.admin.class_student_bai3;

/**
 * Created by Admin on 1/7/2016.
 */
public class SinhVien {
    private String studentName;
    private int studentID;
    static int N;
    SinhVien()
    {
        studentID=0;
        studentName="";
    }
    SinhVien(int studentID,String studentName)
    {
        this.studentID=studentID;
        this.studentName=studentName;
    }

    public int getStudent_id()
    {
        return studentID;
    }
    public String getStudent_name()
    {
        return studentName;
    }

    public void setStudentid(int new_id)
    {
        studentID=new_id;
    }
    public void setStudentName(String new_name)
    {
        studentName=new_name;
    }
    public String getInfo(int student_id)
    {
        return ("ID: "+student_id+" - Ten: "+studentName);
    }
}
