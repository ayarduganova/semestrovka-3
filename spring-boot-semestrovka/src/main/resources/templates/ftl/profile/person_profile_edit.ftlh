<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin/users">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/profile.css" admin=isAdmin>
    <div class="tab">
        <button class="tablinks" onclick="openTab(event, 'Person')" id="defaultOpen">Человек</button>
        <button class="tablinks">Собака</button>
        <button class="tablinks">Выгульщик</button>
    </div>

    <form method="post">
    <div id="Person" class="tabcontent">
        <h3>Профиль человека</h3>
        <p>Имя: <input type="text" name="firstName" value="${profile.firstName}" required></p>
        <p>Фамилия: <input type="text" name="lastName" value="${profile.lastName}" required></p>
        <p>Пол: <input type="text" name="gender" value="${profile.gender}" required></p>
        <p>Дата рождения: <input type="date" name="birthday" value="${profile.birthday}" required></p>
        <p>Почта: <input type="email" name="email" value="${profile.email!}"></p>
        <p>Телефон: <input type="tel" name="phone" value="${profile.phone!}"></p>

            <button type="submit">Save</button>

    </div>
    </form>

    <script src="/js/profile.js" type="text/javascript"></script>
</@m.menuWithCommon>