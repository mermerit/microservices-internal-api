package com.example.userservice.VO;

import com.example.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponceVo {

    private User user;
    private Department department;


}
