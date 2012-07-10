/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.jupi.javagyak.messageboard.ws;

import hu.jupi.javagyak.messageboard.api.MessageBoardService;
import hu.jupi.javagyak.messageboard.entity.Comment;
import hu.jupi.javagyak.messageboard.entity.MessageBoard;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author jupi
 */
@WebService(serviceName = "MessageBoardWS")
public class MessageBoardWS {
    @EJB
    private MessageBoardService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createMessageBoard")
    public MessageBoard createMessageBoard(@WebParam(name = "topic") String topic) {
        return ejbRef.createMessageBoard(topic);
    }

    @WebMethod(operationName = "addComment")
    public Comment addComment(@WebParam(name = "messageBoardId") int messageBoardId, @WebParam(name = "userId") String userId, @WebParam(name = "text") String text) {
        return ejbRef.addComment(messageBoardId, userId, text);
    }

    @WebMethod(operationName = "findMessageBoard")
    public MessageBoard findMessageBoard(@WebParam(name = "id") int id) {
        return ejbRef.findMessageBoard(id);
    }

    @WebMethod(operationName = "findComments")
    public List<Comment> findComments(@WebParam(name = "messageBoardId") int messageBoardId) {
        return ejbRef.findComments(messageBoardId);
    }

    @WebMethod(operationName = "findAllMessageBoards")
    public List<MessageBoard> findAllMessageBoards() {
        return ejbRef.findAllMessageBoards();
    }
    
}
