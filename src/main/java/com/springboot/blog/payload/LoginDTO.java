package com.springboot.blog.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Login Model Information")
@Data
public class LoginDTO {

    @ApiModelProperty(value = "Blog Long usernameOrEmail")
    private String usernameOrEmail;

    @ApiModelProperty(value = "Blog Long password")
    private String password;
}
