package com.example.demo.model;

import lombok.AllArgsConstructor;   // 매개변수가 모두 포함된 생성자
import lombok.Builder;              // Builder 디자인 패턴 
import lombok.Data;                 // getter/setter 생성
import lombok.NoArgsConstructor;    // 매개변수 없는 생성자
import org.hibernate.annotations.GenericGenerator;  // ID를 자동으로 만들 generator 생성

import javax.persistence.Column;
import javax.persistence.Entity;    // java 클래스를 Entity로 설정
import javax.persistence.GeneratedValue;    // 자동으로 Id 생성
import javax.persistence.Id;        // 기본키가 될 필드
import javax.persistence.Table;     // DB 테이블에 매핑
import javax.persistence.UniqueConstraint;  // Column이 유일한 값을 갖도록 설정

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class UserEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;      // 사용자에게 고유하게 부여되는 id

    @Column(nullable = false)
    private String username;// 사용자의 이름

    @Column(nullable = false)
    private String email;   // 사용자의 email, 아이디와 같은 기능을 함

    @Column(nullable = false)
    private String password;// 사용자의 pw

}