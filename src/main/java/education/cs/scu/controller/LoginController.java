package education.cs.scu.controller;

import education.cs.scu.entity.User;
import education.cs.scu.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by maicius on 2017/3/31.
 */
@RestController
public class LoginController {

    @Autowired
    userService userService;

    @RequestMapping(value="/userLogin")
    public String userLogin(HttpServletRequest request,
                             @RequestParam(value="userName") String userName,
                             @RequestParam(value="password") String password) throws Exception{
        User user = new User(userName, password);
        System.out.println(userName);
        ModelAndView mv = new ModelAndView();
        User loginUser = userService.doUserLogin(user);
        HttpSession session = request.getSession();
        if(loginUser != null) {
            session.setAttribute("user", loginUser);
        }else{
            User wrongUser = new User();
            wrongUser.setNickName("该用户不存在");
            session.setAttribute("user", wrongUser);
        }
        mv.setViewName("login");
        System.out.println("Controller finished");
        return "success";
    }

    @RequestMapping(value="/userRegister")
    public ModelAndView userRegister(HttpServletRequest request,
                               @RequestParam(value="userName") String userName,
                               @RequestParam(value="password") String password,
                               @RequestParam(value="nickName") String nickName) throws Exception{
        User user = new User(userName, password);
        ModelAndView mv = new ModelAndView();
        int register = userService.doUserRegister(user);
        System.out.println(register);

        mv.setViewName("index 2");
        return mv;
    }

}
