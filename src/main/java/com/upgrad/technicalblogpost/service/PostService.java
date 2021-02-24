package com.upgrad.technicalblogpost.service;

import com.upgrad.technicalblogpost.model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
//   private static ArrayList<Post> POSTS=new ArrayList<Post>();
//    static {
//        Post post1= new Post();
//        post1.setTitle("Mirzapur");
//        post1.setBody("Kalin Bhaia ki sarkar");
//        post1.setDate(new Date());
//
//        Post post2= new Post();
//        post2.setTitle("Gangs of Wassepur");
//        post2.setBody("Keh ke lenege");
//        post2.setDate(new Date());
//
//        Post post3= new Post();
//        post3.setTitle("Kissan");
//        post3.setBody("Modi ke sarkar");
//        post3.setDate(new Date());
//
//        POSTS.add(post1);
//        POSTS.add(post2);
//        POSTS.add(post3);
//    }

    private final String url= "jdbc:postgresql://localhost:5432/technicalblog";
    private final String username="postgres";
    private final String password="postgres";
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public ArrayList<Post> getAllPosts(){
        ArrayList<Post> posts=new ArrayList<Post>();
        // select * from posts;
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = connect();
            Statement statement= connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from posts");
            while(rs.next()){
                Post post= new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

        return posts;
    }
    public void  createPost(Post newPost){
       String insertIntoPosts = "INSERT INTO posts(title, body, date) VALUES(?,?,?)";
       try(
               Connection connection=connect();
               PreparedStatement pstmt=connection.prepareStatement(insertIntoPosts, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1,newPost.getTitle());
           pstmt.setString(2,newPost.getBody());
           pstmt.setDate(3,new java.sql.Date(newPost.getDate().getTime()));
           int affectedRows= pstmt.executeUpdate();
           if(affectedRows>0){
               System.out.println("We are able to execute our query :"+affectedRows);
           }

       }catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }
}
