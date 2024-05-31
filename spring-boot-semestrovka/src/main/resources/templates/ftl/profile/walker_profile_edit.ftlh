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
        <button class="tablinks">Собака</button>
        <button class="tablinks" onclick="openTab(event, 'Walker')" id="defaultOpen" >Выгульщик</button>
    </div>

    <div id="Walker" class="tabcontent">
        <form method="post">
            <#if walker??>
                <p><strong>Обо мне : </strong><input type="text" name="aboutMe" value="${walker.aboutMe}" required></p>
                <p><strong>Опыт работы : </strong><input type="number" name="workExperience" value="${walker.workExperience}" required></p>
                <p><strong>Цена : </strong><input type="number" step="0.01" name="price" value="${walker.price}" required></p>
                <button type="submit" class="button-link">сохранить</button>
                <button onclick="history.back()" class="button-link">Назад</button>
                <#else>
                    <p><strong>Обо мне : </strong><input type="text" name="aboutMe" required></p>
                    <p><strong>Опыт работы : </strong><input type="number" name="workExperience" required></p>
                    <p><strong>Цена : </strong><input type="number" step="0.01" name="price" required></p>
                    <button type="submit" class="button-link">сохранить</button>
                    <button onclick="history.back()" class="button-link">Назад</button>
            </#if>
        </form>

    </div>
    </div>
    <script src="/js/profile.js" type="text/javascript"></script>
</@m.menuWithCommon>