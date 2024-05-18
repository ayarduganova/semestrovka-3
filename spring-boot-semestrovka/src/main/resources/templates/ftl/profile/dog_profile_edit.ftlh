<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/profile.css" admin=isAdmin>
    <div class="tab">
        <button class="tablinks">Человек</button>
        <button class="tablinks" onclick="openTab(event, 'Dog')" id="defaultOpen">Собака</button>
    </div>

        <div id="Dog" class="tabcontent">
            <#list dogs! as dogOrd>
                <#if dogOrd.id == dog.id>
                    <form action="/profile/editDog" method="post">
                    <p>Имя: <input type="text" name="name" value="${dog.name}" required></p>
                    <p>Возраст: <input type="number" name="age" value="${dog.age}" required></p>
                    <p>Порода: <input type="text" name="breed" value="${dog.breed}" required></p>
                    <button type="submit">Save</button>
                    <input type="hidden" value="${dog.id}" name="dogId">
                    </form>
                <#else>
                    <p>Имя: ${dogOrd.name}</p>
                    <p>Возраст: ${dogOrd.age}</p>
                    <p>Порода: ${dogOrd.breed}</p>
                    <a href="./profile/editDog/${dogOrd.id}">редактировать</a>
                </#if>
            </#list>
        </div>

    <script src="/js/profile.js" type="text/javascript"></script>
</@m.menuWithCommon>