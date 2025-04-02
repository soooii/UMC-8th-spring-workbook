package com.hufs.umc4;

import com.hufs.umc4.dto.BoardRequestDTO;
import com.hufs.umc4.dto.BoardResponseDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void createBoard(BoardRequestDTO dto){
        BoardEntity board = new BoardEntity(dto.getTitle(), dto.getContent());
        boardRepository.save(board);
    }

    public BoardResponseDTO getBoard(Long id){
        Optional<BoardEntity> existBoard = boardRepository.findById(id);
        BoardEntity board = existBoard.get();
        BoardResponseDTO dto = new BoardResponseDTO(board.getTitle(), board.getContent());
        return dto;
    }

    @Transactional
    public void updateBoard(Long id, BoardRequestDTO dto){
        Optional<BoardEntity> existBoard = boardRepository.findById(id);
        BoardEntity board = existBoard.get();
        board.update(dto.getTitle(), dto.getContent());
    }

    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }
}
