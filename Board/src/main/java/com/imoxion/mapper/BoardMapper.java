package com.imoxion.mapper;

import java.util.List;

import com.imoxion.domain.BoardVO;
import com.imoxion.domain.Crieria;
import com.imoxion.domain.ReplyVO;

public interface BoardMapper {

	
	public int insertBoard(BoardVO board);
	public int getGroupNum();
	public void insertGroupNumBoard(int getGroupNum);
	public List<BoardVO> getList(Crieria crieria);
	public BoardVO getBoard(int b_num);
	public void delBoard(int b_num);
	public void boardUpdate(BoardVO board);
	public void updateCount(BoardVO board);
	public void insertReply(ReplyVO reply);
/*	public List<ReplyVO> getreply(int b_num);*/
	public Integer getMaxGroup(int b_num);
	public List<BoardVO> getOverList(BoardVO board);
	public void updateStep(BoardVO board);
	public Integer listTotalCount();
	
}
