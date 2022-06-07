package com.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDTO {

    private Long id;

    @NotEmpty(message = "Name should not be null or empty.")
    private String name;

    @NotEmpty(message = "Email should not be null or empty.")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10)
    private String body;

}
