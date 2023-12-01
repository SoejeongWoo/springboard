package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class BoardController {
@Autowired
BoardService boardService;

    @GetMapping("/boards")
    public String getboards(Model model) {
        List<BoardVO> boardList = boardService.getBoardList();
        for (int i=0; i < boardList.size(); i++){
            BoardVO boardVO = boardList.get(i);
            if (boardVO.getContent().length() > 30) {
                boardVO.setContent(boardVO.getContent().substring(0, 30) + "...");
            }
        }
        model.addAttribute("list", boardList);


        return "list";
    }


    @GetMapping("/boards/{id}")
    public String getboard(@PathVariable Integer id, Model model) {
        BoardVO board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "view";
    }

    @GetMapping("/boards/delete/{id}")
    public String deleteBoard(@PathVariable Integer id) {
        boardService.deleteBoard(id);
        return "redirect:/boards";
    }

    @GetMapping("/boards/add")
    public String addBoard() {
        return "add";
    }

    @PostMapping("/boards/add")
    public String addBoard(BoardVO boardVO) {
        boardService.insertBoard(boardVO);
        return "redirect:/boards";
    }

    @GetMapping("/boards/update/{id}")
    public String updateBoard(@PathVariable Integer id, Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "update";
    }

    @PostMapping("/boards/update/{id}")
    public String updateBoard(BoardVO boardVO) {
        boardService.updateBoard(boardVO);
        return "redirect:/boards";
    }

}