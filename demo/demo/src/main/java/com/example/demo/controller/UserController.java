package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.UserEntity;
import com.example.demo.security.TokenProvider;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; // @Component stereotype

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {
    
    @Autowired
    private UserService userService;
                                // RequestBody로 보내는 JSON -> userDTO 객체로 변환

    @Autowired
    private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        try{
            // 요청을 이용해 저장할 사용자 만들기
            UserEntity user = UserEntity.builder()
                                .email(userDTO.getEmail())
                                .username(userDTO.getUsername())
                                .password(passwordEncoder.encode(userDTO.getPassword()))
                                .build();

            // 서비스를 이용해 리포지터리에 사용자 지정
            UserEntity registeredUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                                .email(registeredUser.getEmail())
                                .id(registeredUser.getId())
                                .username(registeredUser.getUsername())
                                .build();

            // 사용자 정보는 항상 1개 이므로 ResponseDTO 대신 UserDTO 리턴
            return ResponseEntity.ok().body(responseUserDTO);

        }catch(Exception e){

            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();

            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO){
        
        UserEntity user = userService.getByCredentials(
            userDTO.getEmail(),
            userDTO.getPassword(),
            passwordEncoder
        );

        if(user != null){
            final String token = tokenProvider.create(user);
            final UserDTO responseUserDTO = UserDTO.builder()
                .email(user.getUsername())
                .id(user.getId())
                .token(token)
                .build();
            
            return ResponseEntity.ok().body(responseUserDTO);
        }else{
            ResponseDTO responseDTO = ResponseDTO.builder()
                                        .error("Login failed.")
                                        .build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }

    }
}
