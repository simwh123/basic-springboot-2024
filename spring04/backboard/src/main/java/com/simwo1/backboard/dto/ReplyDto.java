package com.simwo1.backboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

    private Long rno;

    private String content;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private String writer;
}