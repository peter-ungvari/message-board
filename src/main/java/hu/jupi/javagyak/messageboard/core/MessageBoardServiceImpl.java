/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.jupi.javagyak.messageboard.core;

import hu.jupi.javagyak.messageboard.api.MessageBoardService;
import hu.jupi.javagyak.messageboard.entity.Comment;
import hu.jupi.javagyak.messageboard.entity.MessageBoard;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of {@link MessageBoardService}.
 *
 * @author jupi
 */
@Singleton
@LocalBean
public class MessageBoardServiceImpl implements MessageBoardService {

    /**
     * JPA entity manager.
     */
    @PersistenceContext
    EntityManager em;
    
    @Override
    public MessageBoard createMessageBoard(String topic) {
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setTopic(topic);
        em.persist(messageBoard);
        em.flush();
        return messageBoard;
    }

    @Override
    public MessageBoard findMessageBoard(int id) {
        return em.find(MessageBoard.class, id);
    }

    @Override
    public List<Comment> findComments(int messageBoardId) {
        MessageBoard mb = em.find(MessageBoard.class, messageBoardId);
        List<Comment> comments = mb.getComments();
        comments.size(); //initializes the lazily fetched comments.
        return comments;
    }

    @Override
    public List<MessageBoard> findAllMessageBoards() {
        List<MessageBoard> resultList = em.createQuery("from MessageBoard m", MessageBoard.class).getResultList();
        for(MessageBoard mb : resultList) {
            mb.setComments(null);
        }
        return resultList;
    }

    @Override
    public Comment addComment(int messageBoardId, String userId, String text) {
        Comment comment = new Comment();
        comment.setMessageBoard(em.find(MessageBoard.class, messageBoardId));
        comment.setTimestamp(new Date());
        comment.setUserId(userId);
        comment.setCommentText(text);
        em.persist(comment);
        em.flush();
        return comment;
    }
}
