package com.simwo1.backboard.validation;

import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardForm {
    @Size(max = 250)
    // @NotEmpty(message = "제목은 필수입니다.") // 스페이스를 허용함!(이거 쓰지마~)
    @NotBlank(message = "제목을 필수입니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;
}