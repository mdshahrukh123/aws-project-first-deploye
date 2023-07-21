package com.Geekster.ToDoApplication.service;

import com.Geekster.ToDoApplication.modle.ToDo;
import com.Geekster.ToDoApplication.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    public List<ToDo> getAllToDosInMyList() {
        return toDoRepository.getAllToDos();
    }

    public String saveData(ToDo todoSaveData) {
        boolean insertionStatus = toDoRepository.saveData(todoSaveData);
        if (insertionStatus) {
            return "Add Successfully !!!!!!...";
        } else {
            return "Failed....Data Didn't save in List !!!!....";
        }
    }

    public ToDo getToDoBasedOnId(Integer id) {
        List<ToDo> toDoListNow = toDoRepository.getAllToDos();

        for (ToDo todo : toDoListNow) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public List<ToDo> getToDo(Integer id, Boolean todoStatus) {
        List<ToDo> toDoListNow = toDoRepository.getAllToDos();

        List<ToDo> finalList = new ArrayList<>();
        if (id == null && todoStatus == null) {
            return toDoListNow;

        } else if (id != null && todoStatus != null) {
            for (ToDo todo : toDoListNow) {
                if (todo.getId() == id && todo.getTodoStatus() == todoStatus) {
                    finalList.add(todo);
                }
            }
            return finalList;

        } else if (id != null && todoStatus == null) {
            for (ToDo todo : toDoListNow) {
                if (todo.getId() == id) {
                    finalList.add(todo);
                }
            }
            return finalList;

        } else if (id == null && todoStatus != null) {
            for (ToDo todo : toDoListNow) {
                if (todo.getTodoStatus() == todoStatus) {
                    finalList.add(todo);
                }
            }
            return finalList;
        }
        return finalList;
    }

    public String removeToDo(Integer id) {
        Boolean removeStatus = false;
        if(id != null){
            List<ToDo> toDoListNow = toDoRepository.getAllToDos();
           for(ToDo todo : toDoListNow){
               if(todo.getId() == id){
                   removeStatus = toDoRepository.remove(todo);
                   if(removeStatus){
                       return "todo id : "+id + " successfully Deleted !!!!!.....";
                   }else{
                       return "todo id : "+id + " doesn't Deleted !!!!!.....data base error!!...";
                   }
               }
           }
           return "ToDo with id : " +id + " doesn't exist !!!!.....";
        }
        else{
            return "Invalid id ..... cannot accept null id !!!!...";
        }
    }

    public String updateStatusById(Integer id, String status){
       boolean updateStatus = toDoRepository.update(id,Boolean.parseBoolean(status));
        if(updateStatus){
            return "todo id : " + id + " successfully updated !!!!....";
        }else{
            return "todo id : " + id + " doesn't exist !!!....";
        }
    }
}
