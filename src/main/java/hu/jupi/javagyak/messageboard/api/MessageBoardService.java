package hu.jupi.javagyak.messageboard.api;

import hu.jupi.javagyak.messageboard.entity.Comment;
import hu.jupi.javagyak.messageboard.entity.MessageBoard;
import java.util.List;
import javax.ejb.Local;

/**
 * Service of message boards.
 *
 * @author jupi
 */
@Local
public interface MessageBoardService {

    /**
     * Create an empty message board.
     *
     * @param topic Topic of the message board. Topic neither can be null, nor
     * empty. Leading and trailing whitespaces will be automatically removed.
     * Must be unique.
     * @return GUID (generated unique identifier) of the message board.
     * @throws IllegalArgumentException If the topic is invalid or already
     * exists.
     */
    MessageBoard createMessageBoard(String topic);
    
    /**
     * Add a comment to a message board.
     * @param messageBoardId GUID of a message board.
     * @param userId ID of the user who submits the comment.
     * @param text Text of the comment.
     * @return The comment.
     */
    Comment addComment(int messageBoardId, String userId, String text);

    /**
     * Find a message board by ID.
     *
     * @param id ID of the message board.
     * @return A message board or null if no message board found.
     */
    MessageBoard findMessageBoard(int id);

    /**
     * Get all comments of a message board.
     *
     * @param messageBoardId ID of the message board.
     * @return List of comments.
     */
    List<Comment> findComments(int messageBoardId);

    /**
     * Find all message boards.
     *
     * @return List of message boards.
     */
    List<MessageBoard> findAllMessageBoards();
}
