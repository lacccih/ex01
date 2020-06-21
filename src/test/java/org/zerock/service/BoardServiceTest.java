package org.zerock.service;

import java.util.List;

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
public class BoardServiceTest {

	private static final Logger logger = LogManager.getLogger(BoardServiceTest.class);
	
	@Inject
	private BoardService service;
	private Integer bno = 5;
	
	@Test
	public void testRegist() throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("뉴글");
		vo.setContent("새로운 글이다");
		vo.setWriter("user00");		
		service.regist(vo);
		
	}
	
	@Test
	public void testRead() throws Exception {
				
		logger.debug(service.read(bno).toString());
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setBno(bno);
		vo.setTitle("헌글");
		vo.setContent("새로운 글이 아니다");
		service.modify(vo);
		
	}
	
	@Test
	public void testDelete() throws Exception {
		
		service.remove(bno);
		
	}
	
	@Test
	public void testListAll() throws Exception {
		
		List<BoardVO> list = service.listAll();
		
		for(BoardVO vo : list) {
			logger.debug(vo.toString());
		}
		
	}
	
}
