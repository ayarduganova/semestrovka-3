<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="" admin=isAdmin>
    <h1>Привет </h1>
    <a href="/logout">Log out</a>
</@m.menuWithCommon>