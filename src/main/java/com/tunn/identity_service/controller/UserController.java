package com.tunn.identity_service.controller;

import com.tunn.identity_service.dto.request.ApiResponse;
import com.tunn.identity_service.dto.request.UserCreationRequest;
import com.tunn.identity_service.dto.request.UserUpdateRequest;
import com.tunn.identity_service.dto.response.UserResponse;
import com.tunn.identity_service.entity.User;
import com.tunn.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;
    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse>builder()
                .result(userService.createUser(request))
                .build();

        return apiResponse;
    }
    @GetMapping
    ApiResponse<List<User>> getUsers(){
        return ApiResponse.<List<User>>builder()
                .result(userService.getUsers())
                .build();
    }
    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String id){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(id))
                .build();
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
