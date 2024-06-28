package example.co.jp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public List<User> findAllUser(){
        return userMapper.findAll();
    }

    public Optional<User> findById(int id){
        return userMapper.findById(id);
    }

    public void update(User user){
        userMapper.update(user);
    }

    public void delete(int id){
        userMapper.delete(id);
    }
}
