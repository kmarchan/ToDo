package guru.springframework.controllers;

import guru.springframework.domain.ToDo;
import guru.springframework.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    private ToDoService todoService;

    @Autowired
    public void setToDoService(ToDoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list")
    public String listtodos(Model model){
        model.addAttribute("todos", todoService.listAll());
        return "todo/list";
    }

    @RequestMapping("/show/{id}")
    public String gettodo(@PathVariable Integer id, Model model){
        model.addAttribute("todo", todoService.getById(id));
        return "/todo/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("todo", todoService.getById(id));
        return "/todo/todoform";
    }

    @RequestMapping("/new")
    public String newToDo(Model model){
        model.addAttribute("todo", new ToDo());
        return "/todo/todoform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(ToDo todo){
        ToDo savedToDo = todoService.saveOrUpdate(todo);
        return "redirect:/todo/show/" + savedToDo.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        todoService.delete(id);
        return "redirect:/todo/list";
    }
}