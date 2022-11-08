package kr.co.heart.dao;

import java.util.Map;
import java.util.List;
import kr.co.heart.domain.BoardDto;

public interface BoardDao {

	BoardDto select(Integer bno) throws Exception;
	
	int insert(BoardDto dto) throws Exception;
	int count() throws Exception;
	int deleteAll() throws Exception;
	
	List<BoardDto> selectPage(Map map) throws Exception;

	int increaseViewCnt(Integer bno) throws Exception;
	
}
