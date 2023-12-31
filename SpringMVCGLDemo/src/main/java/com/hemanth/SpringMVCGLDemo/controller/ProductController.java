package com.hemanth.SpringMVCGLDemo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hemanth.SpringMVCGLDemo.entity.Login;
import com.hemanth.SpringMVCGLDemo.entity.Product;
import com.hemanth.SpringMVCGLDemo.service.LoginService;
import com.hemanth.SpringMVCGLDemo.service.ProductService;

@Controller
@SessionAttributes({"userId","checkUserId"})
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    LoginService loginService;

    @GetMapping("/start")
    public String enterUser(Model model){
        Login login=new Login();
        model.addAttribute("login",login);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model){

        login=loginService.save(login);
        model.addAttribute("userId",login.getId());
        model.addAttribute("checkUserId",login.getId());
        return "redirect:/products";
    }

    @GetMapping(value= "/products")
    public String listProducts(Model model){
        if(model.getAttribute("userId")
                .equals(model.getAttribute("checkUserId"))) {
            model.addAttribute("productListDetails", productService.getAllProducts());
            return "products";
        }
        return "";
    }

    @GetMapping(value= "/products/new")
    public String openAddProductForm(Model model){
        if(model.getAttribute("userId")
                .equals(model.getAttribute("checkUserId"))) {
            Product product = new Product();

            model.addAttribute("product", product);
            return "create_products";
        }
        return "redirect:/products";
    }

    @PostMapping(value= "/save")
    public String saveProduct(@ModelAttribute("product") Product product,Model model){
        if(model.getAttribute("userId")
                .equals(model.getAttribute("checkUserId"))) {
            productService.saveProduct(product);
            return "redirect:/products";
        }
        return "redirect:/start";
    }
}