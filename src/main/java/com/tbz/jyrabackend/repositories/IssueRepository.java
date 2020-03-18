package com.tbz.jyrabackend.repositories;

import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
   List<Issue> findByBoard(Board board);
}
