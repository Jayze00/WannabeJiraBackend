package com.tbz.jyrabackend.repositories;

import com.tbz.jyrabackend.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByIsOpen(Boolean isOpen);

}
