package com.duongvyluan.newnote.Schedule.model.Data;

/**
 * Created by JohnDuong on 28-Aug-17.
 */

public class Schedule {
    private String DateTime;
    private String Content;
    private Boolean Alarm;
    private Boolean Important;

    public Schedule(){}
    public Schedule(String DateTime,String Content,Boolean Alarm, Boolean Important){
        this.DateTime=DateTime;
        this.Content=Content;
        this.Alarm=Alarm;
        this.Important=Important;
    }
    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Boolean getAlarm() {
        return Alarm;
    }

    public void setAlarm(Boolean alarm) {
        Alarm = alarm;
    }

    public Boolean getImportant() {
        return Important;
    }

    public void setImportant(Boolean important) {
        Important = important;
    }
}
