
package com.imoxion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imoxion.domain.BoardVO;
import com.imoxion.domain.Crieria;
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
		board.setB_step(1);
		int b_num = boardService.insertBoardService(board);
		return "redirect:/board/ReadBoard?b_num="+b_num+"";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(Model model, @RequestParam("cpage") int cpage) {
		
		System.out.println(cpage);
		
		int rowPerPage =3;
		List<BoardVO> list = null;
		Crieria crieria = boardService.getPaging(rowPerPage,cpage);
		try {
			list = boardService.getListService(crieria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("page", crieria);
		model.addAttribute("list", list);
		return "/listBoard";
	}

	@RequestMapping(value = "/ReadBoard", method = RequestMethod.GET)
	public String ReadBoard(Model model, @RequestParam("b_num") int b_num) {

		BoardVO board = null;
		List<ReplyVO> reply = null;
		board = boardService.getBoardService(b_num);// 해당 번호의 board 정보를 가져온다.
	/*	reply = boardService.getreplyService(b_num);// 해당 번호의 reply 정보를 가져온다.
*/
		int boardCount = board.getB_count() + 1;
		board.setB_count(boardCount);
		boardService.updateCountService(board);

		model.addAttribute("board", board);
		/*model.addAttribute("reply", reply);*/
		return "/ReadBoard";
	}

	@RequestMapping(value = "/delBoard", method = RequestMethod.GET)
	public String delBoard(Model model, @RequestParam("b_num") int b_num) {

		boardService.delBoardService(b_num);

		return "redirect:/board/listAll?cpage=1";
	}

	@RequestMapping(value = "/ModifyBoard", method = RequestMethod.GET)
	public String getModifyBoard(Model model, @RequestParam("b_num") int b_num) {

		BoardVO board = null;

		board = boardService.getBoardService(b_num);

		model.addAttribute("board", board);

		return "/modifyBoard";
	}

	@RequestMapping(value = "/answerBoard", method = RequestMethod.GET)
	public String getAnswer(Model model, @RequestParam("b_num") int b_num) {

		BoardVO board = null;

		board = boardService.getBoardService(b_num);

		model.addAttribute("board", board);
		System.out.println(b_num);
		return "/answerBoard";
	}

	@RequestMapping(value = "/answerBoard", method = RequestMethod.POST)
	public String postAnswer(Model model, BoardVO board) {

		BoardVO parentBoard = boardService.getBoardService(board.getB_num());
		board.setB_group(parentBoard.getB_group());
		board.setB_depth(parentBoard.getB_depth() + 1);
		board.setB_step(parentBoard.getB_step()+1);
		
		//상위의 목록 가져오기
		List<BoardVO> OverList = boardService.getOverListService(parentBoard);
		
		for(int i=0; i<OverList.size(); i++){
		 OverList.get(i).setB_step(OverList.get(i).getB_step()+1);
		 boardService.updateStepService(OverList.get(i));
		}

		boardService.insertBoardService(board);
		System.out.println(OverList.size());
		

		return "redirect:/board/ReadBoard?b_num="+board.getB_num()+"";
	}

	@RequestMapping(value = "/ModifyBoard", method = RequestMethod.POST)
	public String postModifyBoard(Model model, BoardVO board) {
		boardService.boardUpdateService(board);

		int b_num = board.getB_num();
		return "redirect:/board/ReadBoard?b_num=" + b_num + "";

	}

	@RequestMapping(value = "/insertReply", method = RequestMethod.POST)
	public String insertReply(Model model, ReplyVO reply) {

		boardService.insertReplyService(reply);

		System.out.println("성공!!");

		int b_num = reply.getB_num();
		return "redirect:/board/ReadBoard?b_num=" + b_num + "";

	}
}
