package com.board.boardback.repository;

import com.board.boardback.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByWriterContaining(String keyword);

    List<Board> findByContentContaining(String keyword);

    List<Board> findByTitleContaining(String keyword);
}
