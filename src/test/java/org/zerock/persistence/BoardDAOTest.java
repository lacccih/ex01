package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

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
	
	@Test
	public void testUpdate() throws Exception {
		
		BoardVO vo = new BoardVO();
		vo.setBno(3);
		vo.setTitle("헌글");
		vo.setContent("새로운 글이 아니다");
		dao.update(vo);
		
	}
	
	@Test
	public void testDelete() throws Exception {
		
		dao.delete(3);
		
	}
	
	@Test
	public void testListPage() throws Exception {
		
		List<BoardVO> list = dao.listPage(5);
		for(BoardVO vo: list) {
			System.out.println(vo.toString());
		}
		
	}
	
	@Test
	public void testListCriteria() throws Exception {
		
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(8);
		List<BoardVO> list = dao.listCriteria(cri);
		for(BoardVO vo: list) {
			System.out.println(vo.toString());
		}
		
	}
	
	@Test
	public void testURI() {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 2)
				.build();
		
		System.out.println("/board/read?bno=12&perPageNum=2");
		System.out.println(uriComponents.toString());
		
	}
	
	@Test
	public void testURI2() {
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/{m}/{p}/{X}")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 2)
				.build()
				.expand("board", "read","xoxo")
				.encode();
		
		System.out.println("/board/read?bno=12&perPageNum=2");
		System.out.println(uriComponents.toString());
		
	}
	
}
