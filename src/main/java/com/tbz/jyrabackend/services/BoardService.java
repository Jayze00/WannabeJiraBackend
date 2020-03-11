package com.tbz.jyrabackend.services;

import com.tbz.jyrabackend.entities.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board getBoards() {
        return boardRepository.findAll();
    }
}
