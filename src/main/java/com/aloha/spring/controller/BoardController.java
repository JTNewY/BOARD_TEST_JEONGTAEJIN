package com.aloha.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.spring.dto.Board;
import com.aloha.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) throws Exception{


        model.addAttribute(boardService); 

        return "board/list";
    }
    
    @GetMapping("/read")
    public String read(@RequestParam("no") int no , Model model) throws Exception {

        Board board = boardService.select(no);

        model.addAttribute("board", board);

    
        return "board/read="+ no ;
    }
    
    @GetMapping("/insert")
    public String insert() throws Exception {

        return "board/insert";
    }
    @PostMapping("/insert")
    public String insertPro(@RequestParam("no") int no,Board board) throws Exception {
        
        int result = boardService.insert(board);

        if(result >0){
            return"board/list";
        }
        
        return "board/insert&error";
    }
    

    @GetMapping("/update")
    public String update(@RequestParam("no") int no) throws Exception{
        
        return "/board/update";
    }

    @PostMapping("/update")
    public String updatePro(@RequestParam("no") int no, Board board) throws Exception {
        
        int result = boardService.update(board);

        if(result > 0){
            return "board/list";
        }
        
        return "/board/update?no="+no+"&error";
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam("no")int no)throws Exception {
       
        int result = boardService.delete(no);
        
        if(result > 0){
            return "board/list";
        }

        return "board/update?no="+no+ "&error";
    }
    

    // 아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ 왜 안돼ㅁㄴㅇㅁㄴㅇㄴㅁ
}
