document.getElementById('download-btn').addEventListener('click', function () {
    let textContent = document.getElementById('text-content').value; // получаем текстовое содержимое из поля textarea
    let blob = new Blob([textContent], { type: 'text/plain' }); // создаем Blob с текстовым содержимым

    let anchor = document.createElement('a'); // создаем элемент <a> для временной ссылки
    anchor.href = URL.createObjectURL(blob); // устанавливаем ссылку на Blob в атрибут href элемента <a>
    anchor.download = 'formatted-file.txt'; // устанавливаем имя файла для скачивания

    anchor.click(); // "щелкаем" по ссылке, чтобы скачать файл
});
