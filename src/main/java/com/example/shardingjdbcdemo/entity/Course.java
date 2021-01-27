package com.example.shardingjdbcdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long cid;
    private String cname;
    private Long userId;
    private String cstatus;
}
