package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.ToDo;
import com.example.webapp.service.ToDoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {
    /** DI */
    private final ToDoService toDoService;

    /** ToDoの一覧を表示 */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("todos", toDoService.findAllToDo());
        return "todo/list";
    }

    /** 指定されたIDのToDoの詳細を表示 */
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
        // ToDoのIDに対応する「ToDo」情報を取得
        ToDo toDo = toDoService.findByIdToDo(id);
        if (toDo != null) {
            model.addAttribute("todo", toDo);
            return "todo/detail";
        } else {
            // 対象データが存在しない場合はフラッシュメッセージを設定
            attributes.addFlashAttribute("errorMessage", "対象データがありません");
            // リダイレクト
            return "redirect:/todos";
        }
    }
}