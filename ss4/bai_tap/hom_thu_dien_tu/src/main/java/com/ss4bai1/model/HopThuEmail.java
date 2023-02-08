package com.ss4bai1.model;

public class HopThuEmail {
    private int id;
    private String languages;
    private int pageSize;
    private boolean spam;
    private String content;

    public HopThuEmail() {
    }

    public HopThuEmail(int id, String languages, int pageSize, boolean spam, String content) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.spam = spam;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
