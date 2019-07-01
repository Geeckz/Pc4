package pc.appemp.isilenrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pc.appemp.isilenrollment.model.Product;
import pc.appemp.isilenrollment.repository.JdbcProductRepository;

@Controller

public class ProductController {


    @Autowired
    JdbcProductRepository jdbcProductRepository;


    @GetMapping( {"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/products")
    public String getProductList(Model model){
        model.addAttribute("products", jdbcProductRepository.findAll());
        return "product";
    }

    @GetMapping("/products/add")
    public String addCourse(Model model){
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product, Model model){

        jdbcProductRepository.create(product);

        model.addAttribute("products", jdbcProductRepository.findAll());

        return "product";
    }

}
