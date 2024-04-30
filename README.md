# ToDoアプリ

## 機能一覧
1. 一覧表示
2. 詳細表示
3. 登録
4. 更新
5. 削除

## URLマッピング

|No|役割|メソッド|URL|
|:--|:--|:--|:--|
|1|一覧画面表示|GET|/todos|
|2|詳細画面表示|GET|/todos/{id}|
|3|登録画面表示|GET|/todos/form|
|4|登録処理|POST|/todos/save|
|5|更新画面表示|GET|/todos/etid/{id}|
|6|更新処理|POST|/todos/update|
|7|削除処理|POST|/todos/delete/{id}|

## 画面遷移
- C: 一覧画面 => 登録画面 => <登録処理> => 一覧画面
- R: 一覧画面 => 詳細画面
- U: 一覧画面 => 詳細画面 => 更新画面 => <更新処理> => 一覧画面
- D: 一覧画面 => 詳細画面 => <削除処理> => 一覧画面