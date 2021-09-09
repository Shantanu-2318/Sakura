package shantanu.spring.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

@Slf4j
public class TodoData {

    // == Fields ==
    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    // == Constructor ==


    public TodoData() {
        addItem(new TodoItem("First","details of first", LocalDate.now()));
        addItem(new TodoItem("Second","details of second", LocalDate.now()));
        addItem(new TodoItem("Third","details of third", LocalDate.now()));
        log.info("Todo-List is {}", items);
    }

    // == Public Methods ==
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd){
        log.info("Adding item : {}", toAdd);
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;
    }

    public void removeItem(int id){
        items.removeIf(item -> item.getId() == id);
    }

    public TodoItem getItem(int id){
        for (TodoItem item :
                items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> iterator = items.listIterator();
        while (iterator.hasNext()){
            TodoItem item = iterator.next();
            if (item.equals(toUpdate)){
                iterator.set(toUpdate);
                break;
            }
        }
    }
}
