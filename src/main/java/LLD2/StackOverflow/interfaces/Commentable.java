package LLD2.StackOverflow.interfaces;

import LLD2.StackOverflow.Comment;

import java.util.List;

public interface Commentable {
        void addComments(Comment comment);
        List<Comment> getComments();
}
