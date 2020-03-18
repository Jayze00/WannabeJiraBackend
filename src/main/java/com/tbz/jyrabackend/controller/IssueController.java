package com.tbz.jyrabackend.controller;

import com.tbz.jyrabackend.dto.IssueDto;
import com.tbz.jyrabackend.entities.AppUser;
import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.entities.Issue;
import com.tbz.jyrabackend.services.AuthService;
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

    @Autowired
    IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @RequestMapping(value = "/api/boards/{boardId}/issues", method = RequestMethod.GET)
    public IssueDto getIssues(@RequestBody Long boardId) {

        Board board = new Board();
        return issueService.getIssues(board);
    }

    @RequestMapping(value = "/api/boards/{boardId}/issues", method = RequestMethod.POST)
    @ResponseBody
    public Issue addIssue(@PathVariable Long boardId) {

        return issueService.addIssue();
    }

    @RequestMapping(value = "/api/boards/{boardId}/issues/{issueId}", method = RequestMethod.PUT)
    @ResponseBody
    public Issue changeIssue(@PathVariable Long boardId, Long issueId) {
        //issueService.logInUser(userData);
        return null;
    }

    @RequestMapping(value = "/api/boards/{boardId}/issues/{issueId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteIssue(@PathVariable Long id, HttpServletResponse response) {
        try {

        } catch (Exception exc){
            throw new ResponseStatusException(
                    HttpStatus.NOT_MODIFIED, "Issue not deleted", exc);

        }
    }
}

