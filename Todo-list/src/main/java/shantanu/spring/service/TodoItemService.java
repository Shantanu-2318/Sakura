package shantanu.spring.service;

import shantanu.spring.model.TodoData;
import shantanu.spring.model.TodoItem;

public interface TodoItemService {

    void addItems(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUPdate);

    TodoData getData();
}
