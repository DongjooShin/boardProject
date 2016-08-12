
package com.imoxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imoxion.domain.BoardVO;
import com.imoxion.domain.ReplyVO;
import com.imoxion.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardConroller {

	private BoardService boardService;

	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String getInsertBoard() {

		return "/insertBoard";
	}

	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String postInsertBoard(Model model, BoardVO board) {

		boardService.insertBoardService(board);

		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(Model model) {

		List<BoardVO> list = null;

		try {
			list = boardService.getListService();
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("list", list);
		return "/listBoard";
	}

	@RequestMapping(value = "/ReadBoard", method = RequestMethod.GET)
	public String ReadBoard(Model model, @RequestParam("b_num") int b_num) {

		BoardVO board = null;
		List<ReplyVO> reply = null;
		board = boardService.getBoardService(b_num);//해당 번호의 board 정보를 가져온다.
		reply = boardService.getreplyService(b_num);//해당 번호의 reply 정보를 가져온다.
		
		int boardCount = board.getB_count()+1;
		board.setB_count(boardCount);
		boardService.updateCountService(board);
		
		
		
		
		model.addAttribute("board", board);
		model.addAttribute("reply", reply);
		return "/ReadBoard";
	}

	@RequestMapping(value = "/delBoard", method = RequestMethod.GET)
	public String delBoard(Model model, @RequestParam("b_num") int b_num) {

		boardService.delBoardService(b_num);

		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/ModifyBoard", method = RequestMethod.GET)
	public String getModifyBoard(Model model, @RequestParam("b_num") int b_num) {

		BoardVO board = null;

		board = boardService.getBoardService(b_num);

		model.addAttribute("board", board);

		return "/modifyBoard";
	}
	
	@RequestMapping(value = "/ModifyBoard", method = RequestMethod.POST)
	public String postModifyBoard(Model model, BoardVO board) {
		boardService.boardUpdateService(board);
		
		int b_num = board.getB_num(); 
		return "redirect:/board/ReadBoard?b_num="+b_num+"";
		
	}
	
	

	
	@RequestMapping(value = "/insertReply", method = RequestMethod.POST)
	public String insertReply(Model model, ReplyVO reply) {
		
		
		boardService.insertReplyService(reply);
		
		System.out.println("성공!!");
		
		int b_num = reply.getB_num(); 
		return "redirect:/board/ReadBoard?b_num="+b_num+"";
		
	}
}
