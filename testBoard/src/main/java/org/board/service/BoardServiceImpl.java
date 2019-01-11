package org.board.service;

import java.util.List;

import javax.inject.Inject;

import org.board.dao.BoardDAO;
import org.board.vo.BoardVO;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    @Inject
    private BoardDAO dao;
    
    
    public int create(BoardVO vo) throws Exception {
       return  dao.create(vo);
 
    }
 

    public List<BoardVO> listAll() throws Exception {
        
        
        return dao.listAll();
    }

    public BoardVO read(Integer no) throws Exception {
        
        return dao.read(no);
    }
 

    public void delete(Integer no) throws Exception {
        dao.delete(no);
 
    }
 

    public void update(BoardVO vo) throws Exception {
        
        dao.update(vo);
 
    }

}
