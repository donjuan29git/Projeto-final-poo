/*package br.com.supermarket.pooprj.controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.supermarket.pooprj.model.domain.Venda;
import br.com.supermarket.pooprj.service.VendaService;
import br.com.supermarket.pooprj.service.UserService;
import jakarta.validation.Valid;

@Controller
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @Autowired
    private UserService userService;


    @GetMapping("/vendas")
    public String home() {
        return "venda/vendas"; // nome do template sem extensão
    }
    // LISTAR TODOS OS PRODUTOS
    @GetMapping("/listproducts")
    public String index(ModelMap model) {
        model.addAttribute("products", vendaService.findAll());
        int size = vendaService.findAll().size();
        model.addAttribute("size", size);
        return "/Venda/listVenda"; 
    }

    // NOVO PRODUTO
    @GetMapping("/new")
    public String newVenda(ModelMap model) {
        model.addAttribute("product", new Venda());
        model.addAttribute("users", userService.findAll());
        return "/venda/newVenda";
    }

  // CRIAR PRODUTO
    @PostMapping("/create")
    public String create(@Valid Venda venda, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "/venda/newVenda";
        }
        vendaService.save(venda);
        redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso!");
        return "redirect:/products/show/" + venda.getId();
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Long id, ModelMap model) {
        model.addAttribute("product", vendaService.findById(id));
        return "/products/showProduct"; // template que mostra detalhes do produto
    }


    // EDITAR PRODUTO
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, ModelMap model) {
        model.addAttribute("venda", vendaService.findById(id));
        model.addAttribute("users", userService.findAll());
        return "/products/editProduct";
    }

       // ATUALIZAR PRODUTO
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @Validated Venda venda, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "/products/editProduct";
        }
        venda.setId(id);
        vendaService.update(venda);
        redirectAttributes.addFlashAttribute("success", "Produto atualizado com sucesso!");
        return "redirect:/products/show/" + venda.getId();
    }

     // DELETAR PRODUTO
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        vendaService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Produto deletado com sucesso!");
        return "redirect:/products/listproducts";
    }
}*/
