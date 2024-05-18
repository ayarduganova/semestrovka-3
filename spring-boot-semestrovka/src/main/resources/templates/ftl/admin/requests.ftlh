<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="admin" css="/css/admin.css" admin=isAdmin>
    <div class="request">
        <#list requests as request>
            <form method="post">
                <p>Имя: ${request.firstName()}</p>
                <p>Фамилия: ${request.lastName()}</p>
                <p>Телефон: ${request.phone()}</p>
                <p>Почта: ${request.email()}</p>
                <input type="hidden" value="${request.id()}" name="requestId">

                <button type="submit" class="btn" name="action" value="approve">Одобрить</button>
                <button type="submit" class="btn" name="action" value="reject">Отклонить</button>
            </form>
        </#list>
    </div>

</@m.menuWithCommon>