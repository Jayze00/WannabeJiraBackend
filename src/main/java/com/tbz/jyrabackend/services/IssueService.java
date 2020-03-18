package com.tbz.jyrabackend.services;

import com.tbz.jyrabackend.dto.IssueDto;
import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.entities.Issue;
import com.tbz.jyrabackend.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    private IssueRepository issueRepository;


    @Autowired
    IssueService(IssueRepository issueRepository){
        this.issueRepository = issueRepository;
    }

    public IssueDto getIssues(Board board){
        IssueDto issueDto = new IssueDto();
        List<Issue> issues = issueRepository.findByBoard(board);
        for (Issue issue : issues){
            switch (issue.getStatus()){
                case ToDo:
                    issueDto.getTodo().add(issue);
                    break;

                case InProgress:
                    issueDto.getInprogress().add(issue);
                    break;

                case Done:
                    issueDto.getDone().add(issue);
                    break;
            }
        }
        return issueDto;
    }

    public Issue addIssue(Issue issue){
        issueRepository.save(issue);
        return issue;
    }
}
