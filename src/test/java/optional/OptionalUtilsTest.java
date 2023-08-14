package optional;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OptionalUtilsTest {

    @Test
    void mapNullableSuccess() {
        var input = "100";
        var result = OptionalUtils.mapNullable(input, Integer::valueOf);
        assertThat(result, instanceOf(Integer.class));

    }

    @Test
    void mapNullableReturnNull() {
        var input = Integer.valueOf("100");
        input = null;

        var result = OptionalUtils.mapNullable(input, Integer::valueOf);
        assertNull(result);
    }

    @Test
    void updateUserName() {
        var user = new User("John");
        var newName = "Peter";

        OptionalUtils.consumeIfPresent(user, updateName(newName));

        assertEquals(newName, user.getName());
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private static class User {
        String name;
    }

    private static Consumer<User> updateName(String newName) {
        return user -> user.setName(newName);
    }

}
