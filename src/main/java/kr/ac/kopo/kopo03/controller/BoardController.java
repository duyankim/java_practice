package kr.ac.kopo.kopo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ac.kopo.kopo03.service.BoardService;

@Controller
public class BoardController {
//	@Autowired
//	private SampleRepository sampleRepository;
//	
//	@RequestMapping(value = "/sample/list")
//	@ResponseBody
//	public List<Sample> list(Model model) {
//		return sampleRepository.findAll();
//	}
//	
//	@RequestMapping(value = "/sample/pageable")
//	@ResponseBody
//	public List<Sample> pageable(Model model) {
//		PageRequest pageable = PageRequest.of(0, 10);
//		Page<Sample> page = sampleRepository.findAll(pageable);
//		return page.getContent();
//	}
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String menu(Model model) {
	    model.addAttribute("menu", boardService.viewAll());
	    return "index";
	}
}
