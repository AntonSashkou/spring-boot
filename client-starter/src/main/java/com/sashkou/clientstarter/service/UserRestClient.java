package com.sashkou.clientstarter.service;

import com.sashkou.domain.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient
public interface UserRestClient {

    @RequestLine(value = "GET /users/{id}")
    @Headers({"Content-Type: application/json"})
    User getUser(@Param("id") String id);

    @RequestLine(value = "POST /users")
    @Headers({"Content-Type: application/json"})
    User createUser(@RequestBody User user);

    @RequestLine(value = "DELETE /users/{id}")
    @Headers({"Content-Type: application/json"})
    User deleteUser(@Param("id") String id);
}
