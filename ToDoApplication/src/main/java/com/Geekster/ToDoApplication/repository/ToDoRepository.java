package com.Geekster.ToDoApplication.repository;

import com.Geekster.ToDoApplication.modle.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ToDoRepository {
    List<ToDo> todoList;

    public ToDoRepository(){
        todoList = new ArrayList<>();
        todoList.add(new ToDo(0,"Dummy ToDo for Testing",true));
    }
    public List<ToDo> getAllToDos(){
//        ToDo toDoObj1 = new ToDo();
//        toDoObj1.setTodoName("Create Document");
//        toDoObj1.setTodoStatus(true);
//        todoList.add(toDoObj1);
//
//        ToDo toDoObj2 = new ToDo();
//        toDoObj2.setTodoName("Create Application");
//        toDoObj2.setTodoStatus(true);
//        todoList.add(toDoObj2);
//
//        ToDo toDoObj3 = new ToDo();
//        toDoObj3.setTodoName("Learning Code");
//        toDoObj3.setTodoStatus(false);
//        todoList.add(toDoObj3);

        return todoList;
    }


    public boolean saveData(ToDo todoSaveData) {
        todoList.add(todoSaveData);
        return true;
    }

    public boolean remove(ToDo todo){
        todoList.remove(todo);
        return true;
    }

    public Boolean update(Integer id, Boolean status){
        for(ToDo todo : todoList){
            if(todo.getId() == id){
                // remove original
                 remove(todo);
                 // change this todo
                todo.setTodoStatus(status);
                // add this new
                saveData(todo);
                return true;
            }
        }
        return false;
    }
}
