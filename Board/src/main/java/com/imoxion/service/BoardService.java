package com.imoxion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imoxion.domain.BoardVO;
import com.imoxion.domain.Crieria;
import com.imoxion.domain.ReplyVO;
import com.imoxion.mapper.BoardMapper;
import com.imoxion.persistence.BoardDao;

@Service
public class BoardService {

	private BoardDao boardDao;

	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	public int insertBoardService(BoardVO board) {
		return boardDao.insertBoard(board);
	}

	public List<BoardVO> getListService(Crieria crieria) {
		
		
		return boardDao.getList(crieria);
	}

	public BoardVO getBoardService(int b_num) {

		return boardDao.getBoard(b_num);
	}

	public void delBoardService(int b_num) {
		boardDao.delBoard(b_num);

	}

	public void boardUpdateService(BoardVO board) {
		boardDao.boardUpdate(board);

	}

	public void updateCountService(BoardVO board) {
		boardDao.updateCount(board);

	}

	public void insertReplyService(ReplyVO reply) {
		
		int maxGroupNum = boardDao.getMaxGroup(reply.getB_num());
		reply.setR_group(maxGroupNum+1);
		reply.setR_step(1);
		boardDao.insertReply(reply);
	}

/*	public List<ReplyVO> getreplyService(int b_num) {

		return boardDao.getreply(b_num);
	}*/

	public List<BoardVO> getOverListService(BoardVO board) {
		
		return boardDao.getOverList(board);
	}

	public void updateStepService(BoardVO board) {
		boardDao.updateStep(board);
		
	}

	public Crieria getPaging(int rowPerPage,int cpage) {
		int totalCount = boardDao.listTotalCount();
		Crieria crieria = new Crieria();
		crieria.setTotalRow(totalCount);
		crieria.setRowPerPage(rowPerPage);
		crieria.setCpage(cpage);
		crieria.calPaging();
		
		System.out.println(crieria.toString());
		
		
		
		return crieria;
	}

}
