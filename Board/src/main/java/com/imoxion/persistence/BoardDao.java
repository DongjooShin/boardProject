package com.imoxion.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.imoxion.domain.BoardVO;
import com.imoxion.domain.Crieria;
import com.imoxion.domain.ReplyVO;
import com.imoxion.mapper.BoardMapper;

@Repository
public class BoardDao {

	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int insertBoard(BoardVO board) {
		sqlSession.getMapper(BoardMapper.class).insertBoard(board);
		int getGroupNum = sqlSession.getMapper(BoardMapper.class).getGroupNum();
		System.out.println(getGroupNum);
		sqlSession.getMapper(BoardMapper.class).insertGroupNumBoard(getGroupNum);
		return getGroupNum;
		
	}

	public List<BoardVO> getList(Crieria crieria) {

		return sqlSession.getMapper(BoardMapper.class).getList(crieria);
	}

	public BoardVO getBoard(int b_num) {

		return sqlSession.getMapper(BoardMapper.class).getBoard(b_num);

	}

	public void delBoard(int b_num) {
		sqlSession.getMapper(BoardMapper.class).delBoard(b_num);

	}

	public void boardUpdate(BoardVO board) {

		sqlSession.getMapper(BoardMapper.class).boardUpdate(board);

	}

	public void updateCount(BoardVO board) {
		sqlSession.getMapper(BoardMapper.class).updateCount(board);

	}

	public void insertReply(ReplyVO reply) {

		sqlSession.getMapper(BoardMapper.class).insertReply(reply);
	}

	/*public List<ReplyVO> getreply(int b_num) {

		return sqlSession.getMapper(BoardMapper.class).getreply(b_num);
	}
*/
	public int getMaxGroup(int b_num) {

		Integer getMaxNum = sqlSession.getMapper(BoardMapper.class).getMaxGroup(b_num);

		if (getMaxNum != null) {
			System.out.println(getMaxNum);
			return getMaxNum;
		} else {
			return 0;
		}
	}

	public List<BoardVO> getOverList(BoardVO board) {
		
		return sqlSession.getMapper(BoardMapper.class).getOverList(board);
	}

	public void updateStep(BoardVO board) {
		sqlSession.getMapper(BoardMapper.class).updateStep(board);
		
	}

	public int listTotalCount() {
		Integer totalCount = sqlSession.getMapper(BoardMapper.class).listTotalCount();
		if(totalCount == null){
			return 0;
		}
		else{
			return totalCount;
		}
		
		
	}

}
