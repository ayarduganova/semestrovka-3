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
        <button class="tablinks" onclick="openTab(event, 'Person')" id="defaultOpen">Человек</button>
        <button class="tablinks">Собаки</button>
        <button class="tablinks">Выгульщик</button>
    </div>

    <form method="post">
    <div id="Person" class="tabcontent">
        <div class="info">
        <p><strong>Имя: </strong><input type="text" name="firstName" value="${profile.firstName}" required></p>
        <p><strong>Фамилия: </strong><input type="text" name="lastName" value="${profile.lastName}" required></p>
        <p><strong>Пол: </strong><input type="text" name="gender" value="${profile.gender}" required></p>
        <p><strong>Дата рождения: </strong><input type="date" name="birthday" value="${profile.birthday}" required></p>
        <p><strong>Почта: </strong><input type="email" name="email" value="${profile.email!}"></p>
        <p><strong>Телефон: </strong><input type="tel" name="phone" value="${profile.phone!}"></p>
        </div>

            <button type="submit" class="button-link">cохранить</button>
            <button onclick="history.back()" class="button-link">Назад</button>

    </div>
    </form>
    </div>
    <script src="/js/profile.js" type="text/javascript"></script>
</@m.menuWithCommon>