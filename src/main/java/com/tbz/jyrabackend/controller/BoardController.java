package com.tbz.jyrabackend.controller;

import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.services.BoardService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    private BoardService boardService;

    @RequestMapping(value = "/api/boards", method = RequestMethod.GET)
    public void getBoards(@RequestBody List<Board> board) {
        boardService.getBoards();
    }

}
