package homework.controller;

import homework.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authServ;

    @GetMapping("/user")
    public ModelAndView getDefaultInfo(){
        ModelAndView page=new ModelAndView("auth/user-page");
        page.addObject("username",authServ.getUser().getUsername());
        return page;
    }

    @GetMapping("/admin")
    public ModelAndView getSpecInfo(){
        if(!authServ.hasAuthority("ROLE_ADMIN")){
            return new ModelAndView("error/403");
        }
        return new ModelAndView("auth/admin-page");

    }
}
