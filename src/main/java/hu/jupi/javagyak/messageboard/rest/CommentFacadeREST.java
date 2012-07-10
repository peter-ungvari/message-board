/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.jupi.javagyak.messageboard.rest;

import hu.jupi.javagyak.messageboard.entity.Comment;
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
@Path("comment")
public class CommentFacadeREST extends AbstractFacade<Comment> {
    @PersistenceContext(unitName = "message-board-pu")
    private EntityManager em;

    public CommentFacadeREST() {
        super(Comment.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Comment entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Comment entity) {
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
    public Comment find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Comment> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Comment> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @java.lang.Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
