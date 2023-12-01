package com.example;
import java.util. List;
public interface BoardService {

    int insertBoard(BoardVO vo);

    int deleteBoard(int seq);

    int updateBoard(BoardVO vo);

    BoardVO getBoard (int seq);

    List <BoardVO> getBoardList();
}
