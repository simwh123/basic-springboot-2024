package com.simwo1.backboard.repository;

//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.simwo1.backboard.entity.Board;
//import com.simwo1.backboard.service.BoardService;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

//import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

@SpringBootTest
public class BoardRepositoryTests {
    // JUnit 테스트
    // @Autowired
    // private BoardRepository boardRepository;

    // @Autowired
    // private BoardService boardService;

    // @Test
    // void testThreeHundredBoards() {
    // for (int i = 0; i < 400; i++) {
    // this.boardService.setBoard(String.format("테스트 데이터 - [%03d]", i+1),
    // "별내용 없습니다.", null);
    // }
    // }

    // @Test
    // void testInsertBoard() {
    // Board board1 = new Board(); // 전통적인 객체 생성방식
    // board1.setTitle("첫번째 테스트입니다.");
    // board1.setContent("어쩌라구!");
    // board1.setCreateDate(LocalDateTime.now());
    // this.boardRepository.save(board1);
    // // Builder를 사용한 객체 생성방식
    // Board board2 = Board.builder().title("두번째 테스트입니다.")
    // .content("그래서 어쩌라구!!")
    // .createDate(LocalDateTime.now()).build();
    // this.boardRepository.save(board2);
    // System.out.println("Board 테스트 완료!!");
    // }

    // @Test
    // void testSelectBoard() {
    // List<Board> all = this.boardRepository.findAll(); // select * from board
    // assertEquals(4, all.size());
    // System.out.println(all.size());

    // Board bd = all.get(0); // 게시글중 가장 첫번째 값
    // assertEquals(3, bd.getBno()); // 첫번째 게시글의 PK값이 1인지 확인
    // System.out.println(bd.getBno());
    // }

    // @Test
    // void testUpdateBoard() {
    // Optional<Board> bd = this.boardRepository.findById(1L); // Long값은 뒤에 L추가
    // assertTrue(bd.isPresent()); // bno가 1번인 게시글이 객체 넘어왔는 확인
    // Board ubd = bd.get();
    // ubd.setContent("테스트로 수정합니다.");
    // this.boardRepository.save(ubd); // save() id가 없으면 INSERT, 있으면 UPDATE 쿼리 자동실행
    // System.out.println("수정완료!!");
    // }

    // @Test
    // void testDeleteBoard() {
    // Optional<Board> bd = this.boardRepository.findById(153L);
    // assertTrue(bd.isPresent());
    // Board dbd = bd.get();
    // this.boardRepository.delete(dbd);
    // System.out.println("삭제완료!!");
    // }
}