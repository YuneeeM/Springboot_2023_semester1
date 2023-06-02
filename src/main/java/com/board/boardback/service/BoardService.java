package com.board.boardback.service;

import com.board.boardback.exception.ResourceNotFoundException;
import com.board.boardback.model.Board;
import com.board.boardback.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //board rest api 생성
    public Board createBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }

    //게시판의 모든 리스트
    public List<Board> listAllBoards() {
        return boardRepository.findAll();
    }

    //id를 통한 게시물 참조
    public ResponseEntity<Board> getBoardById(@PathVariable Integer id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not exist with id :"+id));
        int cnt = board.getViewCnt();
        board.setViewCnt(cnt+1);

        return ResponseEntity.ok(board);
    }

    //게시물 수정
    public ResponseEntity<Board> updateBoard(@PathVariable Integer id, @RequestBody Board boardDetails) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not exist with id :"+id));
        board.setTitle(boardDetails.getTitle());
        board.setContent(boardDetails.getContent());

        Board updatedBoard = boardRepository.save(board);
        return ResponseEntity.ok(updatedBoard);
    }

    public ResponseEntity<Map<String,Boolean>> deleteBoard(@PathVariable Integer id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not exist with id :" + id));

        boardRepository.delete(board);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
