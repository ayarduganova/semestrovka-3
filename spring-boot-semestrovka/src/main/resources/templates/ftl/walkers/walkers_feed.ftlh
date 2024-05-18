<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/walkers.css" admin=isAdmin>

    <div class="modal" id="modal">
        <form method="post">
        <div class="modal_box">
            <div class="modal_title">Отправьте заявку, чтобы стать выгульщиком</div>
            <div class="modal_info">
                <p>Имя: <input type="text" name="firstName" value="${user.firstName}" required></p>
                <p>Фамилия: <input type="text" name="lastName" value="${user.lastName}" required></p>
                <p>Почта: <input type="email" name="email" value="${user.email!}"></p>
                <p>Телефон: <input type="tel" name="phone" value="${user.phone!}"></p>
            </div>
            <div class="modal_bottom">
                <button type="submit" class="btn">Отправить</button>
                <a href="#" class="btn btn--close" id="btn_close">Закрыть</a>
            </div>
        </div>
        </form>
    </div>

    <a href="#" class="btn" id="btn">стать выгульщиком</a>

    <div class="posts">
        <#if service.hasRole(current_user, role)>
            <button class="plus-button">+</button>
        </#if>
    </div>

    <script src="/js/walkers.js" type="text/javascript"></script>
</@m.menuWithCommon>