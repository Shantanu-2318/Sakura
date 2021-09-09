package shantanu.spring.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import shantanu.spring.model.TodoData;
import shantanu.spring.model.TodoItem;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // == Fields ==
    @Getter
    private final TodoData data = new TodoData();

    // == Public Methods ==
    @Override
    public void addItems(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }
}
