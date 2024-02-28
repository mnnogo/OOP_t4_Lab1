<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Форматирование текста</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<br><br><br><br>
<div class="container-fluid col-sm-6" id="container">
    <div class="row justify-content-center">
        <div class="">
            <h2>Выберите .txt файл для загрузки:</h2>
            <form action="Format" method="POST" enctype="multipart/form-data">
                <div class="input-group mb-3">
                    <input type="file" class="form-control mt-2" name="file" accept=".txt">
                    <button class="btn btn-primary mt-2" type="submit">Обработать</button>
                </div>
            </form>
            <label for="text-content">Результат:</label>
            <textarea class="form-control" id="text-content" rows="20" readonly></textarea>
            <a class="btn btn-success mt-3" id="download-btn">Скачать</a>
        </div>
    </div>
</div>
<script src="script.js"></script>
</body>
</html>
