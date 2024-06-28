package com.simwo1.backboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simwo1.backboard.entity.Member;
import com.simwo1.backboard.service.MailService;
import com.simwo1.backboard.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequestMapping("/mail")
@RequiredArgsConstructor
@Controller
@Log4j2
public class MailController {

    private final MemberService memberservice;
    private final MailService mailService;

    @PostMapping("/reset-mail")
    public String reset_mail(@RequestParam("email") String email, Model model) {
        log.info(String.format("▶▶▶▶▶ reset.html에서 넘어온 이메일 : %s", email));

        // DB에서 메일주소가 있는지 확인하고 있으면 초기화메일 발송 없으면 error발생
        try {
            Member member = this.memberservice.getMemberByEmail(email);
            Boolean result = this.mailService.sendResetPawordEmail(member.getEmail());
            if (result) {
                log.info("초기화메일 전송 완료");
                model.addAttribute("result", "초기화 메일 전송성공");
            } else
                model.addAttribute("result", "초기화 메일 전송실패");
        } catch (Exception e) {
            model.addAttribute("result", "초기화 메일 전송실패");
        }

        return "member/reset_result"; // member/reset_result.html 파일 생성
    }
}
