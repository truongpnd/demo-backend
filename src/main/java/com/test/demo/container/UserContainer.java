package com.test.demo.container;

import com.test.demo.dto.UserDTO;
import com.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.demo.repo.UsersRepo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserContainer {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity getUsers() {
       try{
           return ResponseEntity.ok(userService.getAllUsers());
       }catch(Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @PostMapping(value = "/add")
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) {
       try{
           return ResponseEntity.ok(userService.addUser(userDTO));
       }catch(Exception e){
           e.printStackTrace();
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserDTO userDTO) {
       try{
           return ResponseEntity.ok(userService.updateUser(userDTO));
       }catch(Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteUser(@PathVariable String username) {
       try{
           userService.deleteUser(username);
           return ResponseEntity.ok("User deleted successfully");
       }catch(Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @GetMapping("/find/{username}")
    public ResponseEntity getUser(@PathVariable String username) {
       try{
           return ResponseEntity.ok(userService.getUser(username));
       }catch(Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
