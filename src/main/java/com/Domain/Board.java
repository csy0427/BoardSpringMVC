package com.Domain;

public class Board {

    private String boardnumber;
    private String title;
    private String id;
    private String content;
    private String views;

    public String getBoardnumber() {
        return boardnumber;
    }

    public void setBoardnumber(String boardnumber) {
        this.boardnumber = boardnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    @Override
    public String toString(){
        return "Board [boardnumber=" + getBoardnumber() + ", title=" + getTitle() +", content="+getContent() + ", id= "+ getId()+"]";
    }
}
