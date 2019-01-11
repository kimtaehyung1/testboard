package org.board.controller;

import javax.inject.Inject;

import org.board.service.BoardService;
import org.board.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/") //url요청이  /board/로 시작하는 것은 여기서 처리한다. ex) board/abc , board/123 board/create
public class BoardController {
    
    @Inject
    private BoardService service;
    
    @RequestMapping(value="/create.do",method=RequestMethod.GET)
    public void createGET(BoardVO vo, Model model) throws Exception{
    	
        System.out.println(" /board/create 입니다. GET방식");
    }
    
    @RequestMapping(value = "/create.do",method=RequestMethod.POST )
    public String createPOST(BoardVO vo, RedirectAttributes attr) throws Exception{
        
    	service.create(vo);
    	System.out.println("/board/create POST방식 입니다.");
        System.out.println(vo.toString());
        System.out.println(vo.getTitle());
        
        
        attr.addFlashAttribute("result", "성공");
        
        
        return "redirect:/board/listAll";
    }
    
    @RequestMapping(value="/listAll.do", method=RequestMethod.GET)
    public void listAll(Model model) throws Exception {
    	
    	System.out.println("전체 목록 페이지");
    	model.addAttribute("boardList",service.listAll());
    }
}

