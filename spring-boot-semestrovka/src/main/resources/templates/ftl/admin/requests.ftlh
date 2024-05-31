<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin/users">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="admin" css="/css/admin.css" admin=isAdmin>
    <div class="wrapper">
        <h1>Запросы</h1>
        <#if requests?size != 0>
        <#list requests as request>
            <form method="post">
                <div class="request">
                <p>Имя: ${request.firstName()}</p>
                <p>Фамилия: ${request.lastName()}</p>
                <p>Телефон: ${request.phone()}</p>
                <p>Почта: ${request.email()}</p>
                <input type="hidden" value="${request.id()}" name="requestId">

                <button type="submit" class="btn" name="action" value="approve">Одобрить</button>
                <button type="submit" class="btn" name="action" value="reject">Отклонить</button>

                </div>
            </form>
        </#list>
        <#else>
            <p>Список запросов пуст</p>
        </#if>
    </div>

</@m.menuWithCommon>