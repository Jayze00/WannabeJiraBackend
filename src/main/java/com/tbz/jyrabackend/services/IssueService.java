package com.tbz.jyrabackend.services;

import com.tbz.jyrabackend.dto.IssueDto;
import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.entities.Issue;
import com.tbz.jyrabackend.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    private IssueRepository issueRepository;

    @Autowired
    IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public IssueDto getIssues(Board board) {
        IssueDto issueDto = new IssueDto();
        List<Issue> issues = issueRepository.findByBoard(board);
        for (Issue issue : issues) {
            switch (issue.getStatus()) {
                case toDo:
                    issueDto.getToDo().add(issue);
                    break;
                case inProgress:
                    issueDto.getInProgress().add(issue);
                    break;
                case done:
                    issueDto.getDone().add(issue);
                    break;
            }
        }
        return issueDto;
    }

    public Issue addIssue(Issue issue) {
        issueRepository.save(issue);
        return issue;
    }

    public Issue modifyIssue(Issue issue) {
        Optional<Issue> issueEntity = issueRepository.findById(issue.getId());
        Issue modifiableIssue = issueEntity.get();
        modifiableIssue.setBoard(issue.getBoard());
        modifiableIssue.setDescription(issue.getDescription());
        modifiableIssue.setStatus(issue.getStatus());
        modifiableIssue.setTitle(issue.getTitle());
        modifiableIssue.setUser(issue.getUser());
        issueRepository.save(modifiableIssue);
        return modifiableIssue;
    }

    public void deleteIssue(Issue issue) {
        issueRepository.delete(issue);
    }
}
