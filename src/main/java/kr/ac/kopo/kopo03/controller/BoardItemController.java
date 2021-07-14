package kr.ac.kopo.kopo03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Board> boards = boardService.viewAll();
	    model.addAttribute("menu", boards);
	    model.addAttribute("postlist", shortenContentList);
	    model.addAttribute("board", board);
	    return "postlist";
	}
	
	@GetMapping("/view")
	public String postview(Model model, @RequestParam("postid") int postid) {
	    BoardItem post = boardItemService.viewOne(postid).get();
		List<Board> boards = boardService.viewAll();
	    model.addAttribute("menu", boards);
	    model.addAttribute("boarditem", post);
	    return "postview";
	}
	
	@GetMapping("/write")
	public String writeForm(@ModelAttribute Board board, Model model) {
		List<Board> boards = boardService.viewAll();
	    model.addAttribute("menu", boards);
	    model.addAttribute("boarditem", new BoardItem());
		board.setTitle(boardService.viewOne(board.getId()).get().getTitle());
		return "postwrite";
	}
	
	@PostMapping("/create/{idx}")
	public String createPost(@ModelAttribute BoardItem boarditem, @PathVariable("idx") int boardid) {
		Board b = boardService.viewOne(boardid).get();
		boarditem.setBoard(b);
		boardItemService.create(boarditem);
		return "redirect:/post/view?postid=" + boarditem.getId();
	}
	
	@GetMapping("/update")
	public String updateForm(Model model, @RequestParam("postid") int postid) {
	    BoardItem post = boardItemService.viewOne(postid).get();
		List<Board> boards = boardService.viewAll();
		int boardid = post.getBoard().getId();
	    model.addAttribute("menu", boards);
	    model.addAttribute("boarditem", post);
	    model.addAttribute("boardid", boardid);
	    return "postupdate";
	}
	
	@PostMapping("/update/{idx}")
	public String updatePost(@ModelAttribute BoardItem boarditem, @PathVariable("idx") int postid) {
		Board b = boardService.viewOne(postid).get();
		boarditem.setBoard(b);
		boarditem.setDate(boardItemService.viewOne(postid).get().getDate());
		boardItemService.create(boarditem);
		return "redirect:/post/view?postid=" + boarditem.getId();
	}
	
	@GetMapping("/delete/{boardid}/{postid}")
	public String deletePost(@PathVariable("postid") int postid, @PathVariable("boardid") int boardid) {
		boardItemService.delete(boardItemService.viewOne(postid).get());
		return "redirect:/post/list?boardid=" + boardid;
	}
}