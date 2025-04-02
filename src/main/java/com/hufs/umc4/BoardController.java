package com.hufs.umc4;

import com.hufs.umc4.dto.BoardRequestDTO;
import com.hufs.umc4.dto.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody BoardRequestDTO dto){
        boardService.createBoard(dto);
        return ResponseEntity.ok("게시글이 작성되었습니다.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDTO> read(@PathVariable Long id){
        BoardResponseDTO dto = boardService.getBoard(id);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody BoardRequestDTO dto){
        boardService.updateBoard(id, dto);
        return ResponseEntity.ok("게시글이 수정되었습니다.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        boardService.deleteBoard(id);
        return ResponseEntity.ok("게시글을 삭제헸습니다.");
    }

}
