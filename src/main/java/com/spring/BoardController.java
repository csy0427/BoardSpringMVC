package com.spring;

import com.Domain.Board;
import com.Domain.File;
import com.Domain.Member;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(HttpRequest.class);

    @Autowired
    private BoardService boardService;

    @Autowired
    private FileService fileService;

    @RequestMapping(value="/")
    public String test(){
        return "index";
    }

    @RequestMapping(value = "list.do")
    public ModelAndView list(HttpSession httpSession) throws Exception{
        List<Board> tmpBoardList = boardService.list();
        httpSession.setAttribute("boardList",tmpBoardList);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("list");
        modelAndView.addObject("boardList",tmpBoardList);
        return modelAndView;
    }

    @RequestMapping(value = "read.do",method = RequestMethod.GET)
    public ModelAndView get(@RequestParam String boardnumber, HttpSession httpSession){
        Board tmpPost=boardService.get(boardnumber);
        boardService.increaseViews(tmpPost);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("read");
        httpSession.setAttribute("post",tmpPost);
        modelAndView.addObject("post",tmpPost);

        File file=fileService.get(boardnumber);
        System.out.println(file.getFileName());

        if(file!=null){
            System.out.println("****************");
            httpSession.setAttribute("file",file);
            modelAndView.addObject("file",file);
        }
        return modelAndView;
    }

    @RequestMapping(value = "updateForm.do")
    public String updateForm(@ModelAttribute Board board) throws Exception{
        return "/board/updateForm";
    }

    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    public String update(@ModelAttribute Board board, HttpSession session) throws Exception{
        System.out.println("update method called**********");
        board.setId((String) session.getAttribute("id"));
        System.out.println(board.toString());
        boardService.update(board);
        return "redirect:list.do";
    }

    @RequestMapping(value= "delete.do")
    public String delete (@RequestParam String boardnumber,HttpSession session){
        String realId=boardService.get(boardnumber).getId();
        //권한 확인...
        if(session.getAttribute("id").equals(realId)){
            System.out.println("delete controller");
            boardService.delete(boardnumber);
        }
        return "redirect:list.do";

    }

    @RequestMapping(value = "write.do", method = RequestMethod.GET)
    public String write(@ModelAttribute Board board, @ModelAttribute Member member, HttpSession httpSession){
        return "/board/writeForm";
    }

    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public String add(@ModelAttribute Board board, HttpSession httpSession, @RequestParam("file") MultipartFile file){
        board.setId((String) httpSession.getAttribute("id"));
        boardService.add(board);
        fileService.save(board,file);
        return "redirect:list.do";
    }

    @RequestMapping(value = "downloadFile.do")
    public String downloadFile(HttpSession httpSession, @RequestParam("filename") String filename){
        fileService.downloadFile(filename);
        return "redirect:list.do";
    }
}
