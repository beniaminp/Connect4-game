package com.connect4.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class Services {
	TableBoard tb = new TableBoard();
	
	@GET
	@Path("/restart")
	@Produces(MediaType.APPLICATION_JSON)
	public Response restart() {
		TableBoard.myBoard = new Integer[7][7];
		Response response = Response.status(200).
                entity("reloaded").
                header("Access-Control-Allow-Origin", "*").build();
		System.out.println("reloaded");
		return response;
	}
	
	@GET
	@Path("/startSession")
	@Produces(MediaType.APPLICATION_JSON)
	public String startSession() {
		return "started";
	}
	
	@GET
	@Path("/addColor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addColor(@QueryParam("player") Integer player, @QueryParam("i") int i, @QueryParam("j") int j) {
		String check = "false";
		if(TableBoard.myBoard[i][j] == null){
			TableBoard.myBoard[i][j] = player;
			 
			if(tb.checkWin(TableBoard.myBoard, i, j)){
				check = "true";
			}
			else{
				check = "false";
			}
		}else{
			check = "false"	;
		}
		
        Response response = Response.status(200).
                entity(check).
                header("Access-Control-Allow-Origin", "*").build();
        return response;
	}	
	
}
