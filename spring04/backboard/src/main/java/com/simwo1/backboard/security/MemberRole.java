package com.simwo1.backboard.security;

import lombok.Getter;

@Getter
public enum MemberRole {
    // 이렇게 쓰는 방법
    // ADMIN("관리자", "ROLE_ADMIN"), USER("사용자", "ROLE_USER");

    // MemberRole(String key, String value) {
    // this.key = key;
    // this.value = value;
    // }

    // private String key;
    // private String value;

    ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

    MemberRole(String value) {
        this.value = value;
    }

    private String value;
}