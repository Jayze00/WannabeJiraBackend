package com.tbz.jyrabackend.services;

import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.entities.Issue;
import com.tbz.jyrabackend.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    public Board persistBoard(Board board) {
        board.setOpen(true);
        return boardRepository.save(board);
    }

    public Board getBoardById(Long id) {
        Optional<Board> boardEntity = boardRepository.findById(id);
        return boardEntity.get();
    }


    public void removeBoard(Board board) {
        boardRepository.delete(board);
    }
}
