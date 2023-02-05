package com.sashkou.service.api;

import com.sashkou.domain.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    private static final Map<String, User> idToUserMap = Map.of(
        "1", new User("Anton"),
        "2", new User("Daniil")
    );

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return idToUserMap.get(id);
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        idToUserMap.put(UUID.randomUUID().toString(), user);
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        idToUserMap.remove(id);
    }
}
