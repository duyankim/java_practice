package kr.ac.kopo.kopo03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.kopo03.domain.BoardItem;
import kr.ac.kopo.kopo03.service.BoardItemService;

@Controller
public class BoardItemController {

	@Autowired
	private BoardItemService boardItemService;
	
	@GetMapping("/postlist")
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
	    model.addAttribute("postlist", shortenContentList);
	    model.addAttribute("board", boardId);
	    return "postlist";
	}
	
	@GetMapping("/postview")
	public String postview(Model model, @RequestParam("postid") int postId) {
	    BoardItem post = boardItemService.viewOne(postId).get();
	    model.addAttribute("post", post);
	    return "postview";
	}
}
