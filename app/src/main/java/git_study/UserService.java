package git_study;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {
    private Map<String, User> userList;

    public UserService(Map<String, User> userList) {
        this.userList = userList;
    }

    public void addUser(User user) {
        if (!userList.containsKey(user.getKey())) {
            userList.put(user.getKey(), user);
        }
    }

    public User getByKey(String key) {
        return userList.get(key);
    }

    public List<User> getByName(String name) {
        if (name != null) {
            return userList.values().stream().filter(e -> name.equals(e.getName())).toList();   
        }

        return null;
    }

    public List<User> getAllUser() {
        return userList.values().stream().collect(Collectors.toList());
    }

    public void updateUser(String key, User user) {
        if (userList.containsKey(key)) {
            userList.put(key, user);
        }
    }

    public void deleteUser(String key) {
        if (userList.containsKey(key)) {
            userList.remove(key);
        }
    }
}
