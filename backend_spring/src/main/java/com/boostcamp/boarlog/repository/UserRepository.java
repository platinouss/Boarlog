package com.boostcamp.boarlog.repository;

import com.boostcamp.boarlog.domain.User;
import com.boostcamp.boarlog.dto.auth.SignUpReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final MongoOperations template;
    public void insertUser(SignUpReqDto signUpReqDto) {
        User user = User.builder()
                .email(signUpReqDto.getEmail())
                .password(signUpReqDto.getPassword())
                .username(signUpReqDto.getUsername())
                .build();
        template.insert(user);
    }

    public User findUserByEmail(String email) {
        return template.findOne(query(where("email").is(email)), User.class);
    }

    public void deleteUser(String email) {
        User user = findUserByEmail(email);
        if (user == null) {
            return;
        }
        template.remove(user);
    }
}
