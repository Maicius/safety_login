package education.cs.scu.service;

import education.cs.scu.entity.User;

/**
 * Created by maicius on 2017/3/31.
 */
public interface userService {
    User doUserLogin(User user) throws Exception;
    int doUserRegister(User user) throws Exception;
}
