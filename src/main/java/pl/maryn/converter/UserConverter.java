package pl.maryn.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.maryn.entity.User;
import pl.maryn.repository.UserRepository;

public class UserConverter implements Converter<String, User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String source) {
        User group = userRepository.findById(Long.parseLong(source));
        return group;
    }
}
