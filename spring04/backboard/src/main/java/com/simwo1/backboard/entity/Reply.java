package com.simwo1.backboard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long rno;

    @Column(name = "content", length = 1000)
    private String content;

    @CreatedDate
    @Column(name = "createDate", updatable = false)
    private LocalDateTime createDate; // 글생성일

    @LastModifiedDate
    @Column(name = "modifyDate")
    private LocalDateTime modifyDate; // 24.06.24 수정일 추가

    // 중요, ERD로 DB를 설계하지 않고 엔티티클래스로 관계를 형성하려면 반드시 사용
    // RelationShip 다대일 설정.
    @ManyToOne
    private Board board;

    // 사용자가 여러개의 게시글을 작성할 수 있다. 다대일 설정
    @ManyToOne
    private Member writer;
}