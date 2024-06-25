package com.simwo1.backboard.common;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.node.Node;
import org.springframework.stereotype.Component;

// 컴포넌트 이름을 어노테이션에 쓸 것!
@Component("CommonUtil")
public class CommonUtil {
    public static String markdown(String content) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(content); // 기존 마크다운으로 작성된 글 파싱
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        return renderer.render(document); // HTML로 랜더링 텍스트 리턴
    }
}
