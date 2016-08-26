package com.connect4.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.connect4.Util.DatabaseConn;

@Path("/api")
public class Services {
	DatabaseConn conn = new DatabaseConn();

	@GET
	@Path("/restart")
	@Produces(MediaType.TEXT_PLAIN)
	public Response restart(@QueryParam("gameId") Integer gameId) {
		conn.deleteByGameId(gameId);
		return startSession();
	}

	@GET
	@Path("/startSession")
	@Produces(MediaType.TEXT_PLAIN)
	public Response startSession() {
		int gameId = conn.insertGame();
		Response response = Response.status(200).entity(gameId).header("Access-Control-Allow-Origin", "*").build();
		return response;
	}

	@GET
	@Path("/addColor")
	@Produces(MediaType.TEXT_PLAIN)
	public Response addColor(@QueryParam("gameId") Integer gameId, @QueryParam("player") Integer player, @QueryParam("i") int i, @QueryParam("j") int j) {
		TableBoard tb = new TableBoard();
		String check = "false";
		Integer[][] board = conn.getByGameId(gameId);
		if (board[i][j] == 0) {

			conn.insertAt(gameId, i, j, player);
			board[i][j] = player;
			
			if (tb.checkWin(board, i, j)) {
				check = "true";
			} else {
				check = "false";
			}
		} else {
			check = "false";
		}

		Response response = Response.status(200).entity(check).header("Access-Control-Allow-Origin", "*").build();
		return response;
	}

}
