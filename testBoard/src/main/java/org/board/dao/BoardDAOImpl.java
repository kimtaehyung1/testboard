package org.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.board.vo.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
    private SqlSession sqlSession;

	 private static String namespace = "org.board.mapper.BoardMapper";

	  //게시판추가
	    @Override
	    public int create(BoardVO vo) throws Exception {
	        
	     return   sqlSession.insert(namespace+".insertBoard", vo);
	 
	    }
	    
	    //게시판보기
	    @Override
	    public List<BoardVO> listAll() throws Exception {
	        
	    	return sqlSession.selectList(namespace+".listBoard");
	        
	    }
	    
	    //게시판 상세
	    @Override
	    public BoardVO read(Integer no) throws Exception {
	    	return sqlSession.selectOne(namespace+".detailBoard", no);
	         
	    }
	 
	    //게시판 삭제
	    @Override
	    public void delete(Integer no) throws Exception {
	        sqlSession.delete(namespace+".deleteBoard", no);
	 
	    }
	 
	    //게시판 수정
	    @Override
	    public void update(BoardVO vo) throws Exception {
	        sqlSession.update(namespace+".updateBoard", vo);
	 
	    }
}
