package com.example.webapp.helper;

import com.example.webapp.entity.ToDo;
import com.example.webapp.form.ToDoForm;

public class ToDoHelper {
    /** ToDoへの変換 */
    public static ToDo convertToDo(ToDoForm form) {
        ToDo todo = new ToDo();
        todo.setId(form.getId());
        todo.setTodo(form.getTodo());
        todo.setDetail(form.getDetail());
        return todo;
    }
    /** ToDoFormへの変換 */
    public static ToDoForm convertToDoForm(ToDo toDo) {
        ToDoForm form = new ToDoForm();
        form.setId(toDo.getId());
        form.setTodo(toDo.getTodo());
        form.setDetail(toDo.getDetail());
        // 更新画面設定
        form.setIsNew(false);
        return form;
    }
}
