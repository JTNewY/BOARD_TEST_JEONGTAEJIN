package com.aloha.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.board.dto.Board;
import com.aloha.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardMapper;

    @Override
    public int insert(Board board) throws Exception {
       
       int result = boardMapper.insert(board);

        if(result > 0){
            return result;
        }
        return result;
    }

    @Override
    public List<Board> list() throws Exception {
        // TODO Auto-generated method stub

        List<Board> boardlist = boardMapper.list();

        return boardlist;
    }

    @Override
    public Board select(int no) throws Exception {
       
       Board boardlist = boardMapper.select(no);

        return boardlist;
    }

    @Override
    public int update(Board board) throws Exception {
        
        int result = boardMapper.update(board);

        if(result > 0){
            return result;
        }
        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        
        int result = boardMapper.delete(no);

        if(result > 0){
            return result;
        }
        return result;
    }

   
}
