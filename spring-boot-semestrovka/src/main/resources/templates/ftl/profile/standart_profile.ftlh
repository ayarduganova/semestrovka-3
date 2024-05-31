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
        <button class="tablinks" onclick="openTab(event, 'Person')" id="p">Человек</button>
        <button class="tablinks" onclick="openTab(event, 'Dog')" id="d">Собаки</button>
        <#if service.hasWalkerRole(current_user)>
        <button class="tablinks" onclick="openTab(event, 'Walker')" id="w">Выгульщик</button>
        </#if>
    </div>

    <div id="Person" class="tabcontent">
        <div class="info">
        <p><strong>Имя: </strong>${profile.firstName}</p>
        <p><strong>Фамилия: </strong>${profile.lastName}</p>
        <p><strong>Пол: </strong>${profile.gender}</p>
        <p><strong>Дата рождения: </strong>${profile.birthday}</p>
        <p><strong>Телефон: </strong>${profile.phone!}</p>
        <p><strong>Почта: </strong>${profile.email!}</p>
        </div>

        <a href="profile/editPerson" class="button-link">редактировать</a>
    </div>

    <form method="get" action="/profile/addDog">
    <div id="Dog" class="tabcontent">
        <div>
            <button type="submit" class="plus-button">+</button>
        </div>
        <#list dogs! as dog>
        <div class="dog-info">
            <p><strong>Имя: </strong>${dog.name}</p>
            <p><strong>Возраст: </strong>${dog.age}</p>
            <p><strong>Порода: </strong>${dog.breed}</p>
            <a href="./profile/editDog/${dog.id}" class="button-link">редактировать</a>
        </div>
        </#list>

    </div>
    </form>
        <div id="Walker" class="tabcontent">
            <#if walker??>
                <p><strong>Обо мне: </strong>${walker.aboutMe}</p>
                <p><strong>Цена(за час): </strong>${walker.price}</p>
                <p><strong>Опыт работы: </strong>${walker.workExperience}</p>
                    <a href="./profile/editWalker" class="button-link">редактировать</a>
                <#else>
                    <a href="./profile/editWalker" class="button-link">заполнить профиль</a>
            </#if>
        </div>

    </div>
    <script src="/js/profile.js" type="text/javascript"></script>
</@m.menuWithCommon>