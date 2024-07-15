package org.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
    private int id;
    private String content;
    private boolean status;
    private Date endDate;

    public Todo() {
    }

    public Todo(String content) {
        this.content = content;
    }

    public Todo(String content, Date endDate) {
        this.content = content;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return  id + "\t\t"+
                content + "\t\t\t" +
                (status?"완료":"미완료") + "\t\t"+
                new SimpleDateFormat("yyyy/MM/dd").format(endDate);
    }
}
