import entities.Comments;
import entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comments c1 = new Comments("Wow Awesome!");
        Comments c2 = new Comments("Welcome!");

        Post p1 = new Post(
                sdf.parse("21/06/2018 13:05:44"),
                "My first Post",
                "give me welcome!",
                3);
        p1.addComment(c1);
        p1.addComment(c2);

        Comments c3 = new Comments("me too!");
        Comments c4 = new Comments("Just Study!");

        Post p2 = new Post(
                sdf.parse("22/07/2018 10:02:00"),
                "I need Money!",
                "any tips?",
                9);
        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p1);
    }
}