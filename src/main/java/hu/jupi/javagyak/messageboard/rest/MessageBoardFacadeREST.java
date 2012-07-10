package hu.jupi.javagyak.messageboard.rest;

import hu.jupi.javagyak.messageboard.entity.MessageBoard;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;

/**
 *
 * @author jupi
 */
@Stateless
@Path("messageboard")
public class MessageBoardFacadeREST extends AbstractFacade<MessageBoard> {
    @PersistenceContext(unitName = "message-board-pu")
    private EntityManager em;

    public MessageBoardFacadeREST() {
        super(MessageBoard.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(MessageBoard entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(MessageBoard entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public MessageBoard find(@PathParam("id") Integer id) {
        MessageBoard mb = super.find(id);
        mb.getComments().size();
        return mb;
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<MessageBoard> findAll() {
        final List<MessageBoard> mbList = super.findAll();
        for(MessageBoard mb : mbList) {
            mb.setComments(null);
        }
        return mbList;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<MessageBoard> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        final List<MessageBoard> mbList = super.findRange(new int[]{from, to});
        for(MessageBoard mb : mbList) {
            mb.setComments(null);
        }
        return mbList;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
