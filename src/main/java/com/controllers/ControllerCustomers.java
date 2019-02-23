package com.controllers;

import com.javaMail.EmailClient;
import com.service.CustomersService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.sql.Date;

@Controller
public class ControllerCustomers {
    private final CustomersService customersService;

    @Autowired
    public ControllerCustomers(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/selectForPas")
    String selectPas() {
        if (customersService.returnHashPas() != null)
            return customersService.returnHashPas();
        else return "Empty request";
    }

    @GetMapping("/selectForEmail")
    String selectEmail() {
        if (customersService.returnEmail() != null)
            return customersService.returnEmail();
        else return "Empty request";
    }

    @GetMapping("/updateMail")
    String changeEmail() {
        if (customersService.updateEmail() != null)
            return customersService.updateEmail();
        else return "Empty request";
    }

    @GetMapping("/updateLevelAccess")
    String changeLevelAccess() {
        if (customersService.updateLevelAccess() != null)
            return customersService.updateLevelAccess();
        else return "Empty request";
    }

    @GetMapping("/updatePassword")
    String changePassword() {
        if (customersService.updatePassword() != null)
            return customersService.updatePassword();
        else return "Empty request";
    }

    @GetMapping("/updateMobailNumber")
    String changeMobailNumber() {
        if (customersService.updateMobailNumber() != null)
            return customersService.updateMobailNumber();
        else return "Empty request";
    }

    @GetMapping("/updateName")
    String changeName() {
        if (customersService.updateName() != null)
            return customersService.updateName();
        else return "Empty request";
    }


    @GetMapping("/updateImg")
    String changeImg() {
        if (customersService.updateImg() != null)
            return customersService.updateImg();
        else return "Empty request";
    }

    //TODO: регистрация пользователя: 1) обычная
    @GetMapping(value = "/registrationForVK", produces = "text/html;charset=UTF-8")
    String registrationForVK() {
        return "index.html";
    }

    //TODO: регистрация пользователя: 1) обычная
    @GetMapping("/registrationForGMAIL")
    String registration() {
        return "gmail.html";
    }


    //TODO: регистрация пользователя: 2) через ВК
    @GetMapping(value = "/registrationVK", produces = "text/html;charset=UTF-8")
    String registrationVK(@RequestParam("first_name") String first_name,
                          @RequestParam("last_name") String last_name,
                          @RequestParam("herf") String href,
                          @RequestParam("mid") String mid) {

            customersService.registrationWithSocialNetwork(StringEscapeUtils.unescapeHtml(first_name),
                    StringEscapeUtils.unescapeHtml(last_name),
                    href, mid);


        return "Ok!";
    }

    //TODO: регистрация пользователя: 3) через GMail
    @GetMapping("/registrationGMAIL")
    String registrationGMAIL(@RequestParam("first_name") String first_name,
                             @RequestParam("last_name") String last_name,
                             @RequestParam("email") String email) {
        customersService.registrationWithSocialNetwork(first_name, last_name,
                email, email);
        return "Ok!";
    }

    @GetMapping("/newCust")
    String newCust() {
        Date d = new Date(2018, 11, 12);
        customersService.insertNewCustomer("masha",
                "DFff", "werftrds", "fghj@ff",
                "wedfrgtyhj", "234567", true, d, 1);

        try {
            EmailClient.sendAsHtml("dashkova_m@inbox.ru",
                    "MoviesMT",
                    "<h2>Welcome to our site:)</h2><p>You are registered in MoviesMT!</p>");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "connected";
    }


}
