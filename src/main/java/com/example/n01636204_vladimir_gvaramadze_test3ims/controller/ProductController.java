package com.example.n01636204_vladimir_gvaramadze_test3ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.n01636204_vladimir_gvaramadze_test3ims.models.Product;
import com.example.n01636204_vladimir_gvaramadze_test3ims.services.ProductService;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {this.productService = productService;}


    @GetMapping("/")
    public String getHome(Model model)
    {
        model.addAttribute("message", "This is HomePage!");
        return "index";
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "product";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}")
    public String getProductDetails(@PathVariable Long id, Model model) {
        productService.getProductById(id).ifPresent(product -> model.addAttribute("product", product));
        return "product-details";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        Optional<Object> productOptional = Optional.empty();
        if (productOptional.isPresent()) {
            model.addAttribute("product", product.get());
            return "product-edit";
        } else {
            return "redirect:/product";
        }
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        productService.updateProduct(id, product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
}






























