package com.teodora.blog.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "articles")
@EntityListeners(AuditingEntityListener.class)
public class Article implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "tag")
    private String tag;

    @Column(name = "author")
    private String author;

    @Column(name = "date")
    private String date;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "content")
    private String content;

    @Column(name = "date_timestamp")
    private Timestamp dateTimestamp;


    public Article() {
    }

    public Article(Integer id, String title, String tag, String author, String date, String imgUrl, String content, Timestamp dateTimestamp) {
        this.id = id;
        this.title = title;
        this.tag = tag;
        this.author = author;
        this.date = date;
        this.imgUrl = imgUrl;
        this.content = content;
        this.dateTimestamp = dateTimestamp;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDateTimestamp() {
        return dateTimestamp;
    }

    public void setDateTimestamp(Timestamp dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", content='" + content + '\'' +
                ", dateTimestamp=" + dateTimestamp +
                '}';
    }
}
