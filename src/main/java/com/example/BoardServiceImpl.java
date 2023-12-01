package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;
    @Override
    public int insertBoard(BoardVO vo) {
        boardDao.insertBoard(vo);
        return 0;
    }

    @Override
    public int deleteBoard(int id) {
        boardDao.deleteBoard(id);
        return 0;
    }

    @Override
    public int updateBoard(BoardVO vo) {
        boardDao.updateBoard(vo);
        return 0;
    }

    @Override
    public BoardVO getBoard(int seq) {
        return boardDao.getBoard(seq);
    }

    @Override
    public List<BoardVO> getBoardList() {
        return boardDao.getBoards();
    }
}
