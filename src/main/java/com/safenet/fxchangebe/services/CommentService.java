package com.safenet.fxchangebe.services;

import com.safenet.fxchangebe.entities.Comment;
import com.safenet.fxchangebe.repositories.CommentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment findCommentByStuff(ObjectId stuffId) {
        return commentRepository.findByStuffId(stuffId);
    }

    public Comment updateComment(Comment comment) {
        Comment existComment = commentRepository.findByStuffId(comment.getStuffId());
        existComment.setContent(comment.getContent());
        existComment.setAuthor(comment.getAuthor());
        existComment.setUpdateAt(comment.getUpdateAt());
        return commentRepository.save(existComment);
    }
}
