package com.tbz.jyrabackend.services;

import com.tbz.jyrabackend.dto.IssueDto;
import com.tbz.jyrabackend.entities.Board;
import com.tbz.jyrabackend.entities.Issue;
import com.tbz.jyrabackend.entities.Issue.Status;
import com.tbz.jyrabackend.repositories.AppUserRepository;
import com.tbz.jyrabackend.repositories.BoardRepository;
import com.tbz.jyrabackend.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    private IssueRepository issueRepository;
    private BoardRepository boardRepository;
    private AppUserRepository appUserRepository;

    @Autowired
    IssueService(IssueRepository issueRepository, BoardRepository boardRepository, AppUserRepository appUserRepository) {
        this.issueRepository = issueRepository;
        this.boardRepository = boardRepository;
        this.appUserRepository = appUserRepository;
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

    public Issue addIssue(Long boardId, Issue issue) {
        Board board = boardRepository.findById(boardId).get();
        issue.setBoard(board);
        issue.setStatus(Status.toDo);
        issue.setUser(appUserRepository.findById(issue.getUser().getId()).get());
        return issueRepository.save(issue);
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

    public void deleteIssue(Long issueId) {
        issueRepository.deleteById(issueId);
    }
}
