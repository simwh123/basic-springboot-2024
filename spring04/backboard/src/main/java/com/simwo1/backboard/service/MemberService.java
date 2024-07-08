package com.simwo1.backboard.service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simwo1.backboard.common.NotFoundException;
import com.simwo1.backboard.entity.Member;
import com.simwo1.backboard.repository.MemberRepository;
import com.simwo1.backboard.security.MemberRole;

import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 새로 사용자 생성
    public Member setMember(String username, String email, String password) {
        Member member = Member.builder().username(username).email(email).regDate(LocalDateTime.now()).build();

        // ... 처리되는 일이 많아서 1~2초시간이 걸리면
        // BCryptPasswordEncoder 매번 새롭게 객체를 생성한다
        // 이것보다는 Bean 등록해놓고 쓰는게 유지보수를 위해서 더 좋음
        // BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(password)); // 암호화한 값을 DB에 저장
        member.setRegDate(LocalDateTime.now());
        member.setRole(MemberRole.USER); // 일반사용자 권한
        this.memberRepository.save(member);

        return member;
    }

    // 기존 사용자 비번초기화
    public void setMember(Member member) {
        member.setPassword(passwordEncoder.encode((member.getPassword()))); // Bcrypt암호화를 안했어요!!!
        this.memberRepository.save(member); // 업데이트!!
    }

    // 사용자를 가져오는 메서드
    public Member getMember(String username) {
        Optional<Member> member = this.memberRepository.findByUsername(username);
        if (member.isPresent())
            return member.get();
        else
            throw new NotFoundException("Member not found!");
    }

    // 24.06.28. 이메일로 사용자 검색 메서드
    public Member getMemberByEmail(String email) {
        Optional<Member> member = this.memberRepository.findByEmail(email);
        if (member.isPresent())
            return member.get();
        else
            throw new NotFoundException("Member not found!");
    }

    // 24.07.04. React에서 넘어온 정보로 로그인 확인
    public Member getMemberByUsernameAndPassword(String username, String password) {
        Optional<Member> _member = this.memberRepository.findByUsername(username);
        Member realMember;

        if (_member.isPresent()) {
            realMember = _member.get(); // 같은 이름의 사용자정보가 다 넘어옴(암호화된 비밀번호까지)
            // plain text와 암호화된 값이 같은 값을 가지고 있는지 체크
            boolean isMatched = passwordEncoder.matches(password, realMember.getPassword());

            if (isMatched)
                return realMember;
            else
                throw new NotFoundException("Member not found!");
        } else {
            throw new NotFoundException("Member not found!");
        }
    }

}