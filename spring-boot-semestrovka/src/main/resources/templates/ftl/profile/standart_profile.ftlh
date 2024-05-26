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
        <button class="tablinks" onclick="openTab(event, 'Dog')" >Собака</button>
        <button class="tablinks" onclick="openTab(event, 'Walker')" >Выгульщик</button>
    </div>

    <div id="Person" class="tabcontent">
        <h3>Профиль человека</h3>
        <p>Имя: ${profile.firstName}</p>
        <p>Фамилия: ${profile.lastName}</p>
        <p>Пол: ${profile.gender}</p>
        <p>Дата рождения: ${profile.birthday}</p>
        <p>Телефон: ${profile.phone!}</p>
        <p>Почта: ${profile.email!}</p>

        <a href="profile/editPerson">редактировать</a>
    </div>

    <form method="get" action="/profile/addDog">
    <div id="Dog" class="tabcontent">

        <#list dogs! as dog>
            <p>Имя: ${dog.name}</p>
            <p>Возраст: ${dog.age}</p>
            <p>Порода: ${dog.breed}</p>
            <a href="./profile/editDog/${dog.id}">редактировать</a>
        </#list>

        <button class="plus-button">+</button>
    </div>
    </form>
    <#if service.hasRole(current_user, role)>
        <div id="Walker" class="tabcontent">
            <#if walker??>
                ${walker.aboutMe}
                ${walker.price}
                ${walker.workExperience}
                    <a href="./profile/editWalker">редактировать</a>
                <#else>
                    <a href="./profile/editWalker">заполнить профиль</a>
            </#if>
        </div>
    </#if>


    <script src="/js/profile.js" type="text/javascript"></script>
</@m.menuWithCommon>