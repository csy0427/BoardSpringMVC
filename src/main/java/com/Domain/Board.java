package com.Domain;

import javax.persistence.*;

@Entity
@Table(name="board")
public class Board {

    @Id
    @GeneratedValue
    @Column(name="boardnumber")
    private String boardnumber;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="id", nullable=false)
    private String id;

    @Column(name="content", nullable=false)
    private String content;

    @Column(name="views", nullable=false)
    private String views;


    /*@OneToMany(mappedBy="boardnumber")
    @Column
    private Collection<File> files;
*/

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
