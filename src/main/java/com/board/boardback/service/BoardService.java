package com.board.boardback.service;

import com.board.boardback.exception.ResourceNotFoundException;
import com.board.boardback.model.Board;
import com.board.boardback.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> listAllBoards() {
        return boardRepository.findAll();
    }

    public ResponseEntity<Board> getBoardById(Integer id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + id));
        int cnt = board.getViewCnt();
        board.setViewCnt(cnt + 1);
        return ResponseEntity.ok(board);
    }

    public ResponseEntity<Board> updateBoard(Integer id, Board boardDetails) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + id));
        board.setTitle(boardDetails.getTitle());
        board.setContent(boardDetails.getContent());
        Board updatedBoard = boardRepository.save(board);
        return ResponseEntity.ok(updatedBoard);
    }

    public ResponseEntity<Map<String, Boolean>> deleteBoard(Integer id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not exist with id: " + id));
        boardRepository.delete(board);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public List<Board> searchBoardsByTitle(String keyword) {
        return boardRepository.findByTitleContaining(keyword);
    }

    public List<Board> searchBoardsByContent(String keyword) {
        return boardRepository.findByContentContaining(keyword);
    }

    public List<Board> searchBoardsByWriter(String keyword) {
        return boardRepository.findByWriterContaining(keyword);
    }

    public List<Board> getTopViewedBoards(int count) {
        PageRequest pageRequest = PageRequest.of(0, count, Sort.by(Sort.Direction.DESC, "viewCnt"));
        return boardRepository.findAll(pageRequest).getContent();
    }
}