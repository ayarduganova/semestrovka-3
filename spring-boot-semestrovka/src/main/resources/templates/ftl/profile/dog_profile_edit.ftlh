<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin/users">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/profile.css" admin=isAdmin>
    <div class="wrapper">
    <div class="tab">
        <button class="tablinks">Человек</button>
        <button class="tablinks" onclick="openTab(event, 'Dog')" id="defaultOpen">Собака</button>
        <button class="tablinks">Выгульщик</button>
    </div>

        <div id="Dog" class="tabcontent">
            <#if dog??>
                    <form action="/profile/editDog" method="post">
                    <p><strong>Имя: </strong><input type="text" name="name" value="${dog.name}" required></p>
                    <p><strong>Возраст: </strong><input type="number" name="age" value="${dog.age}" required></p>
                    <p><strong>Порода: </strong><input type="text" name="breed" value="${dog.breed}" required></p>
                    <button type="submit" class="button-link">сохранить</button>
                        <button onclick="history.back()" class="button-link">Назад</button>
                    <input type="hidden" value="${dog.id}" name="dogId">
                    </form>
            <#else>
                <form method="post">
                    <p><strong>Имя: </strong><input type="text" name="name" placeholder="кличка" required></p>
                    <p><strong>Возраст: </strong><input type="number" name="age" placeholder="возраст" required></p>
                    <p><strong>Порода: </strong><input type="text" name="breed" placeholder="порода" required></p>
                    <button type="submit" class="button-link">сохранить</button>
                    <button onclick="history.back()" class="button-link">Назад</button>
                </form>
            </#if>
        </div>
    </div>
    <script src="/js/profile.js" type="text/javascript"></script>
</@m.menuWithCommon>