package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.ToDo;

public interface ToDoService {
    /** 全ToDoを検索 */
    List<ToDo> findAllToDo();
    /** 指定されたIDのToDoを検索 */
    ToDo findByIdToDo(Integer id);
    /** ToDoを新規登録 */
    void insertToDo(ToDo toDo);
    /** ToDoを更新 */
    void updateToDo(ToDo toDo);
    /** 指定されたToDoを削除 */
    void deleteToDo(Integer id);
}