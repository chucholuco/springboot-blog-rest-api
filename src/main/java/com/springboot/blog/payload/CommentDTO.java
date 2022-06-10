package com.springboot.blog.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Comment model information")
@Data
public class CommentDTO {

    @ApiModelProperty(value = "Blog Comment Id")
    private Long id;

    @ApiModelProperty(value = "Blog Comment name")
    @NotEmpty(message = "Name should not be null or empty.")
    private String name;

    @ApiModelProperty(value = "Blog Comment email")
    @NotEmpty(message = "Email should not be null or empty.")
    @Email
    private String email;

    @ApiModelProperty(value = "Blog Comment body")
    @NotEmpty
    @Size(min = 10)
    private String body;

}
