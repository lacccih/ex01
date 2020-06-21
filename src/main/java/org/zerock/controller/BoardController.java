package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO vo, Model mo) throws Exception {
		logger.info("regiser get...");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("regiser post...");
		logger.info(vo.toString());
		service.regist(vo);
		rttr.addFlashAttribute("msg", "success");
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/board/listAll", method = RequestMethod.GET)
	public void listAll(Model mo) throws Exception {
		logger.info("show all list...");
		mo.addAttribute("list",service.listAll());
	}
	
}
