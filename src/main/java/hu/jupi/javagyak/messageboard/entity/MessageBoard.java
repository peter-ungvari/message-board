package hu.jupi.javagyak.messageboard.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Message board entity class.
 *
 * @author jupi
 */
@Entity
@Table(name="MESSAGE_BOARD")
@XmlRootElement
public class MessageBoard implements Serializable {

    /**
     * GUID, primary key.
     */
    @GeneratedValue
    @Id
    @Column(name = "ID")
    private int id;
    
    /**
     * Topic of the message board.
     */
    @Column(name = "TOPIC", unique=true, nullable=false)
    private String topic;
    
    /**
     * Comments on the message board.
     */
    @OneToMany(mappedBy="messageBoard", targetEntity=Comment.class)
    private List<Comment> comments;

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
}
