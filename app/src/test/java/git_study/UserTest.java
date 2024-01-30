package git_study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UserTest {
    private static UserService userService;

    // 테스트 전 userService 생성 및 테스트 유저 입력
    @BeforeAll
    public static void config() {
        HashMap<String, User> userList = new HashMap<>();

        User user1 = new User(1, 2, 1, "사용자1");
        User user2 = new User(1, 2, 2, "사용자2");

        userList.put(user1.getKey(), user1);
        userList.put(user2.getKey(), user2);

        userService = new UserService(userList);
    }

    @Test
    public void testUserAdd() {
        User user = new User(1, 2, 3, "사용자3");
        userService.addUser(user);

        assertEquals(userService.getAllUser().size(), 3);
    }

    @Test
    public void testUserFindByName() {
        String findName = "사용자1";
        List<User> findList = userService.getByName(findName);

        assertNotNull(findList);
        assertEquals(findList.size(), 1);
        assertEquals(findList.get(0).getName(), findName);

        String findName2 = "사용자";
        List<User> findList2 = userService.getByName(findName2);

        assertEquals(findList2.size(), 0);
    }

    @Test
    public void testFindAllUser() {
        List<User> allUser = userService.getAllUser();

        assertNotNull(allUser);
        assertTrue(allUser.size() > 0);
    }

    @Test
    public void updateUser() {
        String key = "10201";
        User user = userService.getByKey(key);

        user.setName("사용자수정");

        userService.updateUser(key, user);

        User updatedUser = userService.getByKey(key);

        assertEquals(updatedUser.getName(), "사용자수정");
    }

    @Test
    public void testDeleteUser() {
        String key = "10201";
        userService.deleteUser(key);

        User user = userService.getByKey(key);

        assertNull(user);
    }
}
