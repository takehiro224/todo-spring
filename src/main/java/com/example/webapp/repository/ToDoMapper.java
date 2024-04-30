package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.webapp.entity.ToDo;

@Mapper
public interface ToDoMapper {
    /** 全ての「ToDo」を取得する */
    List<ToDo> selectAll();
    /** 指定されたIDに対応するToDoを取得 */
    ToDo selectById(@Param("id") Integer id);
    /** ToDoを登録 */
    void insert(ToDo toDo);
    /** ToDoを更新 */
    void update(ToDo toDo);
    /** 指定されたIDのToDoを削除する */
    void delete(@Param("id") Integer id);
}
