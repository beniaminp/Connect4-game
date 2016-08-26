package com.connect4.service;

public class TableBoard {
	private String[][] board = new String[7][7];

	public static Integer[][] myBoard = new Integer[7][7];

	public boolean checkWin(Integer[][] board, int i, int j) {

		return checkVBack(board, i, j) || checkDiagonalRBack(board, i, j) || checkDiagonalLForward(board, i, j)
				|| checkDiagonalLBack(board, i, j) || checkDiagonalRForward(board, i, j) || checkHBack(board, i, j)
				|| checkHForward(board, i, j) || checkVForward(board, i, j);
	}

	private boolean checkVBack(Integer[][] board, int i, int j) {
		if ((i - 3 >= 0) && (board[i][j] == board[i - 1][j] && board[i][j] == board[i - 2][j]
				&& board[i][j] == board[i - 3][j])) {
			return true;
		}
		return false;
	}

	private boolean checkDiagonalRBack(Integer[][] board, int i, int j) {
		if ((i - 3 >= 0 && j + 3 <= 6) && (board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2]
				&& board[i][j] == board[i - 3][j + 3])) {
			return true;
		}
		return false;
	}

	private boolean checkDiagonalLForward(Integer[][] board, int i, int j) {
		if ((i + 3 <= 6 && j - 3 >= 0) && (board[i][j] == board[i + 1][j - 1] && board[i][j] == board[i + 2][j - 2]
				&& board[i][j] == board[i + 3][j - 3])) {
			return true;
		}
		return false;
	}

	private boolean checkDiagonalLBack(Integer[][] board, int i, int j) {
		if ((i - 3 >= 0 && j - 3 >= 0) && (board[i][j] == board[i - 1][j - 1] && board[i][j] == board[i - 2][j - 2]
				&& board[i][j] == board[i - 3][j - 3])) {
			return true;
		}
		return false;
	}

	private boolean checkDiagonalRForward(Integer[][] board, int i, int j) {
		if ((i + 3 <= 6 && j + 3 <= 6) && (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2]
				&& board[i][j] == board[i + 3][j + 3])) {
			return true;
		}
		return false;
	}

	private boolean checkHBack(Integer[][] board, int i, int j) {
		if ((j - 3 >= 0) && (board[i][j] == board[i][j - 1] && board[i][j] == board[i][j - 2]
				&& board[i][j] == board[i][j - 3])) {
			return true;
		}
		return false;
	}

	private boolean checkHForward(Integer[][] board, int i, int j) {
		if ((j + 3 <= 6) && (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2]
				&& board[i][j] == board[i][j + 3])) {
			return true;
		}
		return false;
	}

	private boolean checkVForward(Integer[][] board, int i, int j) {
		if ((i + 3 <= 6) && (board[i][j] == board[i + 1][j]) && (board[i][j] == board[i + 2][j])
				&& (board[i][j] == board[i + 3][j])) {
			return true;
		}
		return false;
	}

	public String[][] getBoard() {
		return board;
	}

	public void setBoard(String[][] board) {
		this.board = board;
	}
}
