package com.tunn.identity_service.controller;

import com.tunn.identity_service.dto.request.ApiResponse;
import com.tunn.identity_service.dto.request.UserCreationRequest;
import com.tunn.identity_service.dto.request.UserUpdateRequest;
import com.tunn.identity_service.dto.response.UserResponse;
import com.tunn.identity_service.entity.User;
import com.tunn.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;
    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }
    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String id){
        return userService.getUser(id);
    }
    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable("userId") String id, @RequestBody UserUpdateRequest request){
        return userService.updateUser(id, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String id){
        userService.deleteUser(id);
        return "Xoa thanh cong";
    }
}
