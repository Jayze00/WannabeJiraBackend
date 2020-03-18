package com.tbz.jyrabackend.repositories;

import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
   List<Issue> findByBoard(Board board);

   @Query("UPDATE Issue SET title = :title, description = :description, fk_board = :fkBoard, fk_user = :fkUser, status = :issueStatus where id = :id  ")
   Issue  modifyIssue(@Param("title") String title, @Param("desctiption") String description,
                      @Param("fkBoard") Long fkBoard, @Param("fkUser") Long fkUser, @Param("status") Enum status, @Param("id") Long id);
}
