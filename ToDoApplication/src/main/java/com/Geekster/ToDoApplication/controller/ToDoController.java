package com.Geekster.ToDoApplication.controller;

import com.Geekster.ToDoApplication.modle.ToDo;
import com.Geekster.ToDoApplication.service.ToDoService;
// import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    ToDoService todoservice;
 @GetMapping(value = "/Srk")
   public String getToDo(){
      return "HI SONALY...... \n 
         Khushboo tumhare julfo ki ab tak basi h saanso me, \n
          Mehak jati h ruhh meri jab aati ho tum baho me \n
          
          Tumhara SRK my SHONA ,,,,,,,,,....
          
          I LOVE YOU MY Rasmalai......";
   }
    
   @GetMapping(value = "/ToDo")
   public List<ToDo> getToDo(){
      return todoservice.getAllToDosInMyList();
   }

    @PostMapping(value = "/ToDo")
    public String saveToDo(@RequestBody ToDo todoSaveData){
        return todoservice.saveData(todoSaveData);

    }
    @RequestMapping(value = "/ToDoById/{id}", method = RequestMethod.GET)
    public ToDo getToDoById(@PathVariable  Integer id){
        return todoservice.getToDoBasedOnId(id);
    }
    // @GetMapping(value = "/ToDo")
    // public List<ToDo> getFilterToDo(@Nullable @RequestParam Integer id, @Nullable @RequestParam Boolean todoStatus){
    //  return todoservice.getToDo(id,todoStatus);
    // }
    @DeleteMapping(value = "/ToDo/{id}")
    public String removeToDoById( @PathVariable Integer id){
        return todoservice.removeToDo(id);
    }

    @PutMapping(value = "/ToDo/{id}/{status}")
    public String updateToDoStatusById(@PathVariable Integer id, @PathVariable String status){
        return todoservice.updateStatusById(id,status);
    }
}
