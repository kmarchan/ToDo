package guru.springframework.controllers;

import guru.springframework.domain.ToDo;
import guru.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/list")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "todo/list";
    }

    @RequestMapping("/show/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "/todo/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "/todo/todoform";
    }

    @RequestMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new ToDo());
        return "/todo/todoform";
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public String saveOrUpdateProduct(ToDo product){
        ToDo savedProduct = productService.saveOrUpdate(product);
        return "redirect:/todo/show/" + savedProduct.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/todo/list";
    }
}