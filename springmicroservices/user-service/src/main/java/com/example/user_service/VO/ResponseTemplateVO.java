package com.example.user_service.VO;

import com.example.user_service.entities.UserClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private UserClass userClass;
    private Department department;
}
