package com.connect4.service;

public class TableBoard {
	private String[][] board = new String[7][7];

	public static Integer[][] myBoard = new Integer[7][7];

	public boolean checkWin(Integer[][] board, int i, int j) {
		if ((i - 3 >= 0) && (board[i][j] == board[i - 1][j] && board[i][j] == board[i - 2][j]
				&& board[i][j] == board[i - 3][j])) {
			return true;
		} else if ((i - 3 >= 0 && j+3 <= 6) && (board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2]
				&& board[i][j] == board[i - 3][j + 3])) {
			return true;
		} else if ((i + 3 <= 6 && j-3 >= 0) && (board[i][j] == board[i + 1][j - 1] && board[i][j] == board[i + 2][j - 2]
				&& board[i][j] == board[i + 3][j - 3])) {
			return true;
		}else if ((i - 3 >= 0 && j+3 <= 6) && (board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2]
				&& board[i][j] == board[i - 3][j + 3])) {
			return true;
		}else if ((i - 3 >= 0 && j-3 >= 0) && (board[i][j] == board[i - 1][j - 1] && board[i][j] == board[i - 2][j - 2]
				&& board[i][j] == board[i - 3][j - 3])) {
			return true;
		}else if ((i + 3 <= 6 && j+3 <= 6) && (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2]
				&& board[i][j] == board[i + 3][j + 3])) {
			return true;
		}else if ((j - 3 >= 0) && (board[i][j] == board[i][j - 1] && board[i][j] == board[i][j - 2]
				&& board[i][j] == board[i][j - 3])) {
			return true;
		}else if ((j + 3 <= 6) && (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2]
				&& board[i][j] == board[i][j + 3])) {
			return true;
		}else if ((i + 3 <= 6) && (board[i][j] == board[i + 1][j]) && (board[i][j] == board[i + 2][j])
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
