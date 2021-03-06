package com.example.bank.controller.vue;

import com.example.bank.entity.order32.Board;
import com.example.bank.service.order32.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/vueBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class VueBoardController {

    @Autowired
    private BoardService service;

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<List<Board>> getVueBoardList() {
        log.info("getVueBoardList()");

        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Board> postRegisterBoard(@RequestBody Board board) {
        log.info("postRegisterBoard()");

        service.register(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity<Board> getVueBoardRead(@PathVariable("boardNo") Integer boardNo) {
        log.info("getVueBoardRead()");

        Board board = service.read(boardNo);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<Void> vueBoardRemove(@PathVariable("boardNo") Integer boardNo) {
        log.info("vueBoardRemove()");

        service.remove(boardNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<Board> vueBoardModify(@PathVariable("boardNo") Integer boardNo,
                                                @RequestBody Board board) {
        log.info("vueBoardModify()");

        board.setBoardNo(boardNo);
        service.modify(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }
}
