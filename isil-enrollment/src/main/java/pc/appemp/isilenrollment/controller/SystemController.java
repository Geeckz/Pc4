package pc.appemp.isilenrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pc.appemp.isilenrollment.model.Product;
import pc.appemp.isilenrollment.model.Supplier;
import pc.appemp.isilenrollment.repository.JdbcProductRepository;
import pc.appemp.isilenrollment.repository.JdbcSupplierRepository;

@Controller

public class SystemController {


    @Autowired
    JdbcProductRepository jdbcProductRepository;

    @Autowired
    JdbcSupplierRepository jdbcSupplierRepository;


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
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product, Model model){

        jdbcProductRepository.create(product);

        model.addAttribute("products", jdbcProductRepository.findAll());

        return "product";
    }


    @GetMapping("/suppliers")
    public String getSupplierList(Model model){
        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());
        return "supplier";
    }

    @GetMapping("/suppliers/add")
    public String addSupplier(Model model){
        model.addAttribute("supplier", new Supplier());
        return "supplier-add";
    }

    @PostMapping("/suppliers/save")
    public String saveSupplier(Supplier supplier, Model model){

        jdbcSupplierRepository.create(supplier);

        model.addAttribute("suppliers", jdbcSupplierRepository.findAll());

        return "supplier";
    }



}
