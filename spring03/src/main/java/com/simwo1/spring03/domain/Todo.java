package com.simwo1.spring03.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Todo {
    private Integer tno;

    private String title;

    private LocalDateTime dueDate;

    private String writer;

    private Integer isDone;
}