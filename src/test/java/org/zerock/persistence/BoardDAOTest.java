package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {

	private static final Logger logger = LogManager.getLogger(BoardDAOTest.class);
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("뉴글");
		vo.setContent("새로운 글이다");
		vo.setWriter("user00");
		dao.create(vo);
		
	}
	
	@Test
	public void testRead() throws Exception {
		
		logger.debug(dao.read(3).toString());
		
	}
	
	
}
