package com.spring;

import com.Domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value="/")
    public String test(){
        return "index";
    }

    @RequestMapping(value = "list.do", method = RequestMethod.GET)
    public ModelAndView list() throws Exception{
        List<Board> tmpBoardList = boardService.list();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("list");
        System.out.println(tmpBoardList.get(0).getTitle());
        modelAndView.addObject("boardList",tmpBoardList);
        return modelAndView;
    }

    @RequestMapping(value = "get.do",method = RequestMethod.GET)
    public String get(@RequestParam String boardNumber, HttpSession httpSession){
        List<String> tmpPost=boardService.get(boardNumber);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("post",tmpPost);
        return "redirect:read.do";
    }

    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    public String update(@ModelAttribute Board board){
        boardService.update(board);
        return "redirect:list.do";
    }

    @RequestMapping("delete.do")
    public String delete (@RequestParam String boardNumber){
        boardService.delete(boardNumber);
        return "redirect:list.do";
    }

    @RequestMapping(value = "write.do", method = RequestMethod.GET)
    public String write(@ModelAttribute Board board){
        return "board/writeForm";
    }

    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public String add(@ModelAttribute Board board){
        System.out.println(board.getTitle());
        boardService.add(board);
        return "redirect:list.do";
    }
}
