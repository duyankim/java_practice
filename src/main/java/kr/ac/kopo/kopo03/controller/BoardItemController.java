package kr.ac.kopo.kopo03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.kopo.kopo03.domain.Board;
import kr.ac.kopo.kopo03.domain.BoardItem;
import kr.ac.kopo.kopo03.service.BoardItemService;
import kr.ac.kopo.kopo03.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/post")
public class BoardItemController {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BoardItemController.class);

	@Autowired
	private BoardItemService boardItemService;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String postlist(Model model, @RequestParam("boardid") int boardId) {
		List<BoardItem> shortenContentList = boardItemService.viewAll();
		for (BoardItem item : shortenContentList) {
			int end;
			String preview;
			
			if (item.getContent() != null) {
				end =  item.getContent().length() > 80 ? 80 : item.getContent().length();
        		preview = item.getContent().substring(0, end) + "...";
        	} else {
        		preview = "";
        	}
			item.setContent(preview);
		}
		
		Board board = boardService.viewOne(boardId).get();
	    model.addAttribute("postlist", shortenContentList);
	    model.addAttribute("board", board);
	    return "postlist";
	}
	
	@GetMapping("/view")
	public String postview(Model model, @RequestParam("postid") int postId) {
	    BoardItem post = boardItemService.viewOne(postId).get();
	    model.addAttribute("boarditem", post);
	    return "postview";
	}
	
	@GetMapping("/write")
	public String writeForm(Model model, Board board) {
		Board b = boardService.viewOne(board.getId()).get();
		model.addAttribute("board", b);
		return "postwrite";
	}

}