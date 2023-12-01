package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDao {

        @Autowired
        JdbcTemplate jdbcTemplate;
        public int insertBoard(BoardVO vo) {
            String sql = "insert into board (title, writer, content, category, regdate) values ("
                    + "'" + vo.getTitle() + "',"
                    + "'" + vo.getWriter() + "',"
                    + "'" + vo.getContent() + "',"
                    + "'" + vo.getCategory() + "',"
                    + "NOW())";
            return jdbcTemplate.update(sql);
        }
    public int updateBoard(BoardVO vo) {
        String sql = "update board set title="+"'"+vo.getTitle()+"',"
        + "writer = "+"'"+vo.getWriter()+"',"
        + "content = "+"'"+vo.getContent()+"',"
        + "category = "+"'"+vo.getCategory()+"'"
        + "where board_id='"+vo.getId()+"'";
        return jdbcTemplate.update(sql);
    }


    public List<BoardVO> getBoards() {
        String sql = "select * from board";
        return jdbcTemplate.query(sql,new BoardRowMapper());
    }
    public BoardVO getBoard(Integer id) {
        String sql = "select * from board where board_id = "+id;
        return jdbcTemplate.queryForObject(sql,new BoardRowMapper());
    }
    public void deleteBoard(Integer id) {
        String sql = "delete from board where board_id = "+id;
        jdbcTemplate.update(sql);
    }
}

class BoardRowMapper implements RowMapper<BoardVO> {
    @Override
    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardVO vo = new BoardVO();
        vo.setId(rs.getInt("board_id"));
        vo.setTitle(rs.getString("title"));
        vo.setContent(rs.getString ("content"));
        vo.setWriter(rs.getString("writer"));
        vo.setCategory (rs.getString("category"));
        vo.setRegDate(rs.getDate("regdate"));
        return vo;
    }
}
