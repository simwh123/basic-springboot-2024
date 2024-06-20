package com.simwo1.backboard.controller;

// import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simwo1.backboard.entity.Board;
import com.simwo1.backboard.service.BoardService;
import com.simwo1.backboard.validation.BoardForm;
import com.simwo1.backboard.validation.ReplyForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@RequestMapping("/board") // Restful URL은 /board로 시작
@Controller
public class BoardController {

    private final BoardService boardService; // 중간 연결책

    // @RequestMapping("/list", method=RequestMethod.GET) // 아래와 동일 기능
    // Model -> controller에 있는 객체를 View로 보내주는 역할을 하는 객체
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        // List<Board> boardList = this.boardService.getList();
        // model.addAttribute("boardList", boardList); // thymeleaf, mustache, jsp등
        // view로 보내는 기능!!!

        Page<Board> paging = this.boardService.getList(page);
        model.addAttribute("paging", paging); // 페이징된 보드를 view로 전달!

        return "board/list"; // templates/board/list.html 렌더링해서 리턴하라!
    }

    // 댓글 검증을 추가하려면 매개변수로 ReplyForm을 전달!!
    @GetMapping("/detail/{bno}")
    public String detail(Model model, @PathVariable("bno") Long bno, ReplyForm replyForm) throws Exception {
        Board board = this.boardService.getBoard(bno);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/create")
    public String create(BoardForm boardForm) {
        return "board/create";
    }

    @PostMapping("/create")
    public String create(@Valid BoardForm boardForm,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "board/create"; // 현재 html에 그대로 머무르기.
        }

        // this.boardService.setBoard(title, content);
        this.boardService.setBoard(boardForm.getTitle(), boardForm.getContent());
        return "redirect:/board/list";
    }

}