<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin/users">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/profile.css" admin=isAdmin>
    <div class="tab">
        <button class="tablinks">Человек</button>
        <button class="tablinks" onclick="openTab(event, 'Dog')" id="defaultOpen">Собака</button>
    </div>

    <form method="post">
        <div id="Dog" class="tabcontent">

                <p>Имя: <input type="text" name="name" placeholder="кличка" required></p>
                <p>Возраст: <input type="number" name="age" placeholder="возраст" required></p>
                <p>Порода: <input type="text" name="breed" placeholder="порода" required></p>
                <button type="submit">Save</button>

            <#list dogs! as dogOrd>
                <p>Имя: ${dogOrd.name}</p>
                <p>Возраст: ${dogOrd.age}</p>
                <p>Порода: ${dogOrd.breed}</p>
                <a href="./profile/editDog/${dogOrd.id}">редактировать</a>
            </#list>
        </div>
    </form>

    <script src="/js/profile.js" type="text/javascript"></script>
</@m.menuWithCommon>