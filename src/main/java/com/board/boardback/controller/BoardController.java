package com.board.boardback.controller;

import com.board.boardback.model.Board;
import com.board.boardback.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // POST 요청 - 게시물 생성
    @PostMapping
    public ResponseEntity<Board> createBoard(@Valid @RequestBody Board board) {
        Board createdBoard = boardService.createBoard(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBoard);
    }

    // GET 요청 - 모든 게시물 조회
    @GetMapping
    public ResponseEntity<List<Board>> listAllBoards() {
        List<Board> boards = boardService.listAllBoards();
        return ResponseEntity.ok(boards);
    }

    // GET 요청 - 특정 게시물 조회
    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Integer id) {
        return boardService.getBoardById(id);
    }

    // PUT 요청 - 특정 게시물 수정
    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Integer id, @Valid @RequestBody Board boardDetails) {
        return boardService.updateBoard(id, boardDetails);
    }

    // DELETE 요청 - 특정 게시물 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBoard(@PathVariable Integer id) {
        return boardService.deleteBoard(id);
    }

    // GET 요청 - 제목으로 게시물 검색
    @GetMapping("/search/title")
    public ResponseEntity<List<Board>> searchBoardsByTitle(@RequestParam("keyword") String keyword) {
        List<Board> boards = boardService.searchBoardsByTitle(keyword);
        return ResponseEntity.ok(boards);
    }

    // GET 요청 - 내용으로 게시물 검색
    @GetMapping("/search/content")
    public ResponseEntity<List<Board>> searchBoardsByContent(@RequestParam("keyword") String keyword) {
        List<Board> boards = boardService.searchBoardsByContent(keyword);
        return ResponseEntity.ok(boards);
    }

    // GET 요청 - 작성자로 게시물 검색
    @GetMapping("/search/writer")
    public ResponseEntity<List<Board>> searchBoardsByWriter(@RequestParam("keyword") String keyword) {
        List<Board> boards = boardService.searchBoardsByWriter(keyword);
        return ResponseEntity.ok(boards);
    }

    // GET 요청 - 조회수 상위 게시물 조회
    @GetMapping("/top/{count}")
    public ResponseEntity<List<Board>> getTopViewedBoards(@PathVariable int count) {
        List<Board> boards = boardService.getTopViewedBoards(count);
        return ResponseEntity.ok(boards);
    }
}
