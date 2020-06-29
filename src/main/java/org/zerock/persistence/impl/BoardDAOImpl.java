package org.zerock.persistence.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private static final String NAMESPACE = "org.zerock.mapper.BoardMapper.";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(NAMESPACE + "create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(NAMESPACE + "read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(NAMESPACE + "update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(NAMESPACE + "delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(NAMESPACE + "listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if(page <= 0) {
			page = 1;
		}
		return session.selectList(NAMESPACE + "listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		return session.selectList(NAMESPACE + "listCriteria", cri);
	}

	@Override
	public int countPaging() throws Exception {
		return session.selectOne(NAMESPACE + "countPaging");
	}
	
}
