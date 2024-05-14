package com.aloha.spring.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
    private int no;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updDate;
    private int views;    
}
