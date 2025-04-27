package org.mp.machineprogramsapi.service;

import org.mp.machineprogramsapi.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();

        User user1 = new User(1, "Ida", "Smith", "ida@email.com");
        User user2 = new User(2, "John", "Doe", "john@email.com");
        User user3 = new User(3, "Jill", "Johnson", "jill@email.com");
        User user4 = new User(4, "William", "Wendt", "william@email.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
