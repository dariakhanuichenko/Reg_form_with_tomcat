package net.proselyte.springsecurityapp.controller;


import lombok.extern.slf4j.Slf4j;
import net.proselyte.springsecurityapp.dto.RequestDto;
import net.proselyte.springsecurityapp.dto.UserDto;
import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.SecurityService;
import net.proselyte.springsecurityapp.service.UserService;
import net.proselyte.springsecurityapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;
import java.util.ResourceBundle;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "registration";
    }

    @RequestMapping(value = "/api")
    public String getMainPage() {
        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserDto userForm,
                               BindingResult bindingResult, Model model) {


        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
        if (userForm.getRoles().equals("ROLE_USER")) {
            log.info("{}", userForm.getRoles().equals("ROLE_USER"));
            return "redirect:/create_request";
        }else if (userForm.getRoles().equals("ROLE_MANAGER")){
            return "redirect:/checkAllRequests";
        }
            return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout, Locale locale) {
        if (error != null) {
            model.addAttribute("error",
                    ResourceBundle.getBundle("validationMessages",locale)
                            .getString("incorrect.usernameorpass"));
        }

        if (logout != null) {
            model.addAttribute("message",
                    ResourceBundle.getBundle("validationMessages",locale)
                            .getString("logout.success"));
        }
        return "login";

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView getLocale(Locale locale, UserDto user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("locale", messageSource.getMessage("locale", new String[]{locale.getDisplayName(locale)}, locale));
        return modelAndView;

    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }



    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}
