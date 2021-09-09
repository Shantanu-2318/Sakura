package shantanu.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shantanu.spring.model.TodoData;
import shantanu.spring.model.TodoItem;
import shantanu.spring.service.TodoItemService;
import shantanu.spring.util.AttributeNames;
import shantanu.spring.util.Mappings;
import shantanu.spring.util.ViewNames;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {
    // == Fields ==
    private final TodoItemService todoItemService;

    // == Constructor ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == Model Attributes ==
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    // == Handler Methods ==
    @GetMapping(Mappings.ITEMS_LIST)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model){
        log.info("Editing item with id : {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null){
            todoItem = new TodoItem("","", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM)TodoItem todoItem){
        log.info("todo item from form : {}", todoItem);
        if (todoItem.getId() == 0){
            todoItemService.addItems(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" +Mappings.ITEMS_LIST;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Removing Element wuth id : {}",id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS_LIST;
    }
    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;
    }
}
