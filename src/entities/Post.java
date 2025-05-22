package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private String title;
    private String content;
    private Integer likes;

    public Post(Date moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    List<Comments> comments = new ArrayList<>();

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void addComment(Comments cParament){
        comments.add(cParament);
    }
    public void removeComment(Comments cParament){
        comments.remove(cParament);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        sb.append( title + "\n");
        sb.append( content + "\n");
        sb.append( likes + " Likes - ");
        sb.append( sdf.format(moment) + "\n");
        sb.append("Comments: " + "\n");
        for (Comments c : comments) {
            sb.append(c + "\n");
        }
        return sb.toString();
    }
}

