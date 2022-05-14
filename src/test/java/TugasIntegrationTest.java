import IntergrationTest.SecurityService;
import IntergrationTest.User;
import IntergrationTest.UserDAO;
import IntergrationTest.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TugasIntegrationTest {
    User user = Mockito.mock(User.class);

    UserDAO dao = Mockito.mock(UserDAO.class);
    SecurityService security = Mockito.mock(SecurityService.class);

    @Test
    public void checkPassword() throws Exception {
        UserServiceImpl sut = new UserServiceImpl(dao, security);
        Mockito.when(user.getPassword()).thenReturn("pass");
        Mockito.when(security.md5(user.getPassword())).thenReturn("passmd5");

        sut.assignPassword(user);

        Mockito.verify(user).setPassword("passmd5");

        Mockito.verify(dao).updateUser(user);
    }
}
