package com.example.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.webapp.entity.ToDo;
import com.example.webapp.service.ToDoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class WebappApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebappApplication.class, args).getBean(WebappApplication.class).exe();
    }

    /** DI */
    private final ToDoService service;

    public void exe() {
        /** 全件検索 */
        System.out.println("=== 全件検索 ===");
        for (ToDo todo: service.findAllToDo()) {
            System.out.println(todo);
        }
        /** 1件検索 */
        System.out.println("=== 1件検索 ===");
        System.out.println(service.findByIdToDo(1));
        /** 登録 */
        ToDo todo = new ToDo();
        todo.setTodo("リポジトリのテスト");
        todo.setDetail("DBへの登録処理");
        service.insertToDo(todo);
        System.out.println("=== 登録確認 ===");
        System.out.println(service.findByIdToDo(4));
        /** 更新 */
        ToDo target = service.findByIdToDo(4);
        target.setTodo("リポジトリのテスト: 更新");
        target.setDetail("DBへの更新処理");
        service.updateToDo(target);
        System.out.println("=== 更新確認 ===");
        System.out.println(service.findByIdToDo(4));
        /** 削除 */
        service.deleteToDo(4);
        System.out.println("=== 削除確認 ===");
        for (ToDo row: service.findAllToDo()) {
            System.out.println(row);
        }
    }
}
