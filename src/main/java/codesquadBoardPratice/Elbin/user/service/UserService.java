package codesquadBoardPratice.Elbin.user.service;

import codesquadBoardPratice.Elbin.user.domain.User;
import codesquadBoardPratice.Elbin.user.dto.request.UserCreateDto;
import codesquadBoardPratice.Elbin.user.dto.request.UserLoginDto;
import codesquadBoardPratice.Elbin.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserCreateDto userCreateDto) {
        userRepository.save(new User(userCreateDto.getLoginId(), userCreateDto.getPassword()));
    }


    public User login(UserLoginDto userLoginDto) {
        User user = userRepository.findByLoginId(userLoginDto.getLoginId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        if (!user.getPassword().equals(userLoginDto.getPassword())) {
            throw new NoSuchElementException("Password does not match");
        }

        return user;
    }
}
