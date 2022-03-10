package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TodoEntity {
    private String id;  // 이 오브젝트의 id
    private String userId;  // 이 오브젝트를 생성한 사용자의 id
    private String title;   // Todo 타이틀
    private boolean done;   // true - todo를 완료한 경우 (checked)
}
