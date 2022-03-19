package com.example.rest_api;

import com.example.rest_api.model.CurrencyForm;
import com.example.rest_api.model.URLGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class CurrencyFormController {
    private final RequestThreadsRunner appRunner = new RequestThreadsRunner(new RestService());

    @RequestMapping(value = "/form_currency", method = RequestMethod.GET)
    public String currencyForm(Model model) {
        model.addAttribute("currencyForm", new CurrencyForm());
        return "form";
    }

    @RequestMapping(value = "/form_currency", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute CurrencyForm currencyForm, Model model) {
        model.addAttribute("currencyForm", currencyForm);
        System.out.println("Request: " + currencyForm.getFromCurrency() +", to: " + currencyForm.getToCurrency());

        URLGenerator urlGenerator = new URLGenerator(currencyForm.getFromCurrency(), currencyForm.getTime());
        System.out.println(urlGenerator.getFirstUrl());
        System.out.println(urlGenerator.getSecondUrl());
        System.out.println(urlGenerator.getThirdUrl());
        try {
            appRunner.run(currencyForm, urlGenerator.getFirstUrl(), urlGenerator.getSecondUrl(), urlGenerator.getThirdUrl());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "result";
    }

}

