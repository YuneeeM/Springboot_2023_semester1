package com.board.boardback.controller;

import com.board.boardback.model.Board;
import com.board.boardback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/boards")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    @GetMapping("/boards")
    public List<Board> listAllBoards() {
        return boardService.listAllBoards();
    }

    @GetMapping("/boards/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Integer id) {
        return boardService.getBoardById(id);
    }

    @PutMapping("/boards/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Integer id, @RequestBody Board boardDetails) {
        return boardService.updateBoard(id, boardDetails);
    }

    @DeleteMapping("/boards/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteBoard(@PathVariable Integer id) {
        return boardService.deleteBoard(id);
    }
}
