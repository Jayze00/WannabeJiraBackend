package com.tbz.jyrabackend.controller;

import com.tbz.jyrabackend.dto.IssueDto;
import com.tbz.jyrabackend.entities.AppUser;
import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.entities.Issue;
import com.tbz.jyrabackend.services.AuthService;
import com.tbz.jyrabackend.services.BoardService;
import com.tbz.jyrabackend.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

@RestController
public class IssueController {
    private IssueService issueService;
    private BoardService boardService;

    @Autowired
    IssueController(IssueService issueService, BoardService boardService) {
        this.issueService = issueService;
        this.boardService = boardService;
    }

    @RequestMapping(value = "/api/boards/{boardId}/issues", method = RequestMethod.GET)
    public IssueDto getIssues(@PathVariable Long boardId) {
        Board board = boardService.getBoardById(boardId);
        return issueService.getIssues(board);
    }

    @RequestMapping(value = "/api/boards/{boardId}/issues", method = RequestMethod.POST)
    @ResponseBody
    public Issue addIssue(@PathVariable Long boardId, @RequestBody Issue issue) {
        return issueService.addIssue(boardId, issue);
    }

    @RequestMapping(value = "/api/boards/{boardId}/issues/{issueId}", method = RequestMethod.PUT)
    @ResponseBody
    public Issue changeIssue(@PathVariable Long boardId, @PathVariable Long issueId, @RequestBody Issue issue) {
        return issueService.modifyIssue(issue);
    }

    @RequestMapping(value = "/api/boards/{boardId}/issues/{issueId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteIssue(@PathVariable Long boardId, @PathVariable Long issueId) {
        issueService.deleteIssue(issueId);
    }
}

