package com.example.webapp.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.ToDo;
import com.example.webapp.form.ToDoForm;
import com.example.webapp.helper.ToDoHelper;
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

    /** 新規登録画面を表示 */
    @GetMapping("/form")
    public String newToDo(@ModelAttribute ToDoForm form) {
        form.setIsNew(true);
        return "todo/form";
    }

    /** 新規登録処理実行 */
    @PostMapping("/save")
    public String create(ToDoForm form, RedirectAttributes attributes) {
        // フォームをエンティティに変換
        ToDo todo = ToDoHelper.convertToDo(form);
        // 登録実行
        toDoService.insertToDo(todo);
        // フラッシュメッセージ
        attributes.addFlashAttribute("message", "新しいToDoが作成されました");
        // PRGパターン
        return "redirect:/todos";
    }

    /** 更新画面を表示 */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
        // IDに対応するToDoを取得
        ToDo target = toDoService.findByIdToDo(id);
        if (target != null) {
            ToDoForm form = ToDoHelper.convertToDoForm(target);
            model.addAttribute("toDoForm", form);
            return "todo/form";
       } else {
        attributes.addFlashAttribute("errorMessage", "対象データがありません");
        return "redirect:/todos";
       }
    }

    /** 更新処理実行 */
    @PostMapping("/update")
    public String update(ToDoForm form, RedirectAttributes attributes) {
        // フォームをエンティティに変換
        ToDo todo = ToDoHelper.convertToDo(form);
        // 更新処理
        toDoService.updateToDo(todo);
        // フラッシュメッセージ
        attributes.addFlashAttribute("message", "ToDoが更新されました");
        // PRGパターン
        return "redirect:/todos";
    }
}