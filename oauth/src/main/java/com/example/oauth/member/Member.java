package com.example.oauth.member;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "member", schema = "study_db")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SuppressWarnings("unused")
public class Member {

    @Id
    @GeneratedValue
    private Long id;
	private String name;
    private String username;
    private String remark;
    
    @Builder
    public Member(String name, String username, String remark) {
        this.name = name;
        this.username = username;
        this.remark = remark;
    }
}
