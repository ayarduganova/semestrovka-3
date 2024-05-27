<#macro menuWithCommon page css admin>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>${page}</title>
        <link href="/css/menu.css" rel="stylesheet">
        <link href=${css} rel="stylesheet">
    </head>
    <body>
    <div class="navbar">
        <div class="logo">
            <img src="https://catherineasquithgallery.com/uploads/posts/2021-02/1614543159_40-p-sobaki-na-belom-fone-53.png" alt="Logo">
        </div>
        <div class="menu">
            <a href="../profile">Профиль</a>
            <a href="../walkers">Сиделки</a>
            <a href="../map">Площадки</a>
            ${admin}
            <a class="right-part" href="/logout">Выйти</a>
        </div>
    </div>
    <#nested>
    </body>
    </html>
</#macro>