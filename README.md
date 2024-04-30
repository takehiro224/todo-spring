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

## 作成コンポーネント一覧
|No|層|コンポーネント|作成物名称|備考|
|:-:|:-|:-|:-|:-|
|1|アプリケーション層|View|-|画面|
|2|アプリケーション層|Controller|ToDoController|制御の役割|
|3|アプリケーション層|Form|ToDoForm|画面のフォームを表現|
|4|ドメイン層|Service|ToDoService|インターフェース|
|5|ドメイン層|ServiceImpl|ToDoServiceImpl|Serviceの実装|
|6|ドメイン層|Domain Object|ToDo|Entity|
|7|ドメイン層|Repository|ToDoMapper|インターフェース|
|8|インフラストラクチャ層|RepositoryImpl|-|O/R Mapperにより自動作成される|
|9|インフラストラクチャ層|O/R Mapper|-|MyBatis|

## レイヤ別コンポーネント説明
### アプリケーション層
|コンポーネント|説明|
|:-|:-|
|Controller|「リクエスト」をマッピングし、結果を「View」に渡す。「Service」を呼び出す|
|Form|「画面のフォーム」を表現。「画面の入力値をControllerに渡す」「Controllerから画面に値を渡す」|
|View|見た目|

### ドメイン層
|コンポーネント|説明|
|:-|:-|
|Domain Object|業務処理を実行する上で必要な概念やルールを表現する広い概念|
|Service|インターフェース。「業務処理」の定義のみを記述し、実装はない|
|ServiceImpl|Serviceの実装クラス。業務処理そのもの|
|Repository|インターフェース。データベースへのデータ操作の定義を記述|

### インフラストラクチャ層
|コンポーネント|説明|
|:-|:-|
|RepositoryImpl|ドメイン層で定めたRepositoryを実装するクラス|
|O/R Mapper|データをマッピング|

## memo
### アプリケーションの起動フロー
1. 設定
application.propertiesが読み込まれる
2. 構造
schema.sqlが実行され、テーブルが作成される
3. データ
data.sqlが実行され、データが格納される