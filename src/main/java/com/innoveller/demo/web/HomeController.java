package com.innoveller.demo.web;


import com.innoveller.demo.dto.BankAccountDto;
import com.innoveller.demo.model.BankAccount;
import com.innoveller.demo.model.Transaction;
import com.innoveller.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class HomeController
{
    @Autowired
    BankService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listBankAccount", service.getAllBankAccount());
        return "index";
    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model) {
        BankAccountDto bankAccount = new BankAccountDto();
        model.addAttribute("account", bankAccount);
        return "new_account";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") BankAccountDto bankAccountDto) {
        service.createAccount(bankAccountDto);
        return "redirect:/";
    }

    @GetMapping("/findAccount/{id}")
    public String findAccountById(@PathVariable(value = "id") long id, Model model) {

        BankAccount account = service.findAccount(id);

        model.addAttribute("account", account);
        return "find";
    }

}


