package org.board.dao;

import java.util.List;

import org.board.vo.BoardVO;

public interface BoardDAO {

	    public int create(BoardVO vo) throws Exception;
	    
	    public List<BoardVO> listAll() throws Exception;
	    
	    public BoardVO read(Integer no) throws Exception;
	    
	    public void delete(Integer no) throws Exception;
	    
	    public void update(BoardVO vo) throws Exception;


}
