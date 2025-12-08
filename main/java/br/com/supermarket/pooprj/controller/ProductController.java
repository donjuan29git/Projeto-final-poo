package br.com.supermarket.pooprj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.supermarket.pooprj.model.domain.Product;
import br.com.supermarket.pooprj.service.ProductService;
import br.com.supermarket.pooprj.service.UserService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    // LISTAR TODOS OS PRODUTOS
    @GetMapping("/listproducts")
    public String index(ModelMap model) {
        model.addAttribute("products", productService.findAll());
        int size = productService.findAll().size();
        model.addAttribute("size", size);
        return "/products/listProduct"; 
    }

    // NOVO PRODUTO
    @GetMapping("/new")
    public String newProduct(ModelMap model) {
        model.addAttribute("product", new Product());
        model.addAttribute("users", userService.findAll());
        return "/products/newProduct";
    }

  // CRIAR PRODUTO
    @PostMapping("/create")
    public String create(@Valid Product product, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "/products/newProduct";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso!");
        return "redirect:/products/show/" + product.getId();
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("product", productService.findById(id));
        return "/products/showProduct"; // template que mostra detalhes do produto
    }


    // EDITAR PRODUTO
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, ModelMap model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("users", userService.findAll());
        return "/products/editProduct";
    }

       // ATUALIZAR PRODUTO
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @Valid Product product, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "/products/editProduct";
        }
        product.setId(id);
        productService.update(product);
        redirectAttributes.addFlashAttribute("success", "Produto atualizado com sucesso!");
        return "redirect:/products/show/" + product.getId();
    }

   // @DeleteMapping("/delete/{id}")
        @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Produto deletado com sucesso!");
        return "redirect:/products/listproducts";
    }
}
