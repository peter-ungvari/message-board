/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.jupi.javagyak.messageboard.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Comment entity class.
 *
 * @author jupi
 */
@Entity
@Table(name = "COMMENT")
@XmlRootElement
public class Comment implements Serializable {

    /**
     * GUID, primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    /**
     * Message bord that holds the comment.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "MESSAGE_BOARD_ID", nullable = false)
    private MessageBoard messageBoard;
    /**
     * Timestamp of the submission of the comment.
     */
    @Column(name = "SUBMIT_TIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    /**
     * ID of the user who submitted the comment.
     */
    @Column(name = "USER_ID", nullable = false)
    private String userId;
    
    /**
     * Text of the comment.
     */
    @Column(name = "COMMENT_TEXT", nullable = false)
    private String commentText;

    public int getId() {
        return id;
    }

    public MessageBoard getMessageBoard() {
        return messageBoard;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setMessageBoard(MessageBoard messageBoard) {
        this.messageBoard = messageBoard;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    
}
