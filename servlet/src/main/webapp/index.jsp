<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Форматирование текста</title>
</head>
<body>
<h2>Выберите .txt файл для загрузки:</h2>
<form action="Format" method="POST" enctype="multipart/form-data">
    <input type="file" name="file" accept=".txt">
    <input type="submit" value="Считать" id="read-file">
</form>
<label>
    Содержимое файла: <br>
    <textarea name="textContent" rows="10" cols="50" readonly></textarea>
</label>
</body>
</html>
