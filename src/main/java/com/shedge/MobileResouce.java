package com.shedge;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/mobile")
public class MobileResouce {

    List<Mobile> mobileList = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mobile> getMobileList() {
        return mobileList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setMobileList(Mobile newMobile) {
        mobileList.add(newMobile);
        return Response.ok(mobileList).build();
    }

    /*
    * http://localhost:8080/mobile/AAA
    * body
    * {
    *  "new": "YYY"
    * }
    * */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{old}")
    public Response set2MobileList(@PathParam("old") String owner, Mobile newMobile) {
        mobileList.replaceAll(e -> {
            if (e.getOwner().equalsIgnoreCase(owner)) {
                return newMobile;
            } else {
                return e;
            }
        });
        return Response.ok(mobileList).build();
    }
}
