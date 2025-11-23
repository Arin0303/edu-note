package com.edu.edu_note.domain.user.service;

import com.edu.edu_note.domain.user.dto.UserSignUpRequest;
import com.edu.edu_note.domain.user.dto.UserSignUpResponse;
import com.edu.edu_note.domain.user.entity.User;
import com.edu.edu_note.domain.user.repository.UserRepository;
import com.edu.edu_note.global.exception.BusinessException;
import com.edu.edu_note.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSignUpResponse signUp(UserSignUpRequest request) {
        // 1. 중복 검사
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }

        // 2. 비밀번호 암호화 (추후 적용, 현재는 그대로)
        String encodedPassword = request.getPassword();

        // 3. 저장
        User savedUser = userRepository.save(request.toEntity(encodedPassword));

        // 4. 응답 DTO로 변환해서 반환
        return UserSignUpResponse.from(savedUser);
    }
}