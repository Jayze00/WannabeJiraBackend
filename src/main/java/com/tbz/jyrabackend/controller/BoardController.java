package com.tbz.jyrabackend.controller;

import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    private BoardService boardService;

    @Autowired
    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/api/boards", method = RequestMethod.GET)
    public List<Board> getBoard() {
        return boardService.getBoards();
    }


    @RequestMapping(value = "/api/boards", method = RequestMethod.POST)
    public Board persistBoard(@RequestBody Board board) {
        return boardService.persistBoard(board);
    }

}
