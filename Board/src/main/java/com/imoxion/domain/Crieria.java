package com.imoxion.domain;

public class Crieria {
	private int totalRow; // 총 게시글 수
	private int rowPerPage; // 페이지당 개수
	private int totalPage; // 전체 체이지수
	private int startRow; // 시작 글번호
	private int endRow; // 마지막 글 번호
	private int cpage; // 현제 페이지
	private int blockNum = 5;
	private int startBlock;
	private int endBlock;

	public void calPaging() {
		this.totalPage = (totalRow / rowPerPage) + ((totalRow % rowPerPage) == 0 ? 0 : 1);
		this.startRow = (cpage - 1) * rowPerPage;
		this.endRow = rowPerPage;



			if (cpage - 2 > 0) {
			startBlock = cpage - 2;

			if (cpage + 2  < totalPage) {
				endBlock = cpage + 2;
			} else {
				endBlock = totalPage;
			}

		} else {
			startBlock = 1;

			if (cpage + 2  < totalPage) {
				endBlock = cpage + 2;
			} else {
				endBlock = totalPage;
			}
		}

	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public int getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(int blockNum) {
		this.blockNum = blockNum;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	@Override
	public String toString() {
		return "Crieria [totalRow=" + totalRow + ", rowPerPage=" + rowPerPage + ", totalPage=" + totalPage
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", cpage=" + cpage + "]";
	}

}
