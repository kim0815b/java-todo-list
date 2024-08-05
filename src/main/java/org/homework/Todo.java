package org.homework;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Todo {
    private int id;
    private String content;
    private boolean status;
    private LocalDate endDate;

    public Todo() {
    }

    public Todo(String content) {
        this.content = content;
    }

    public Todo(String content, LocalDate endDate) {
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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("%-6d%-12s%-6s%tF", id,content,status ? "완료" : "미완료",endDate);
    }
}
