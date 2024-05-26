<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin/users">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/walkers.css" admin=isAdmin>
    <form method="post">
    <p>Комментарий: <textarea name="comment" rows="5" cols="33" placeholder="Введите свой комментарий" required></textarea></p>
    <button type="submit">Save</button>
    </form>

    <div class="posts">
        <#list posts! as post>
            <p>Пользователь: ${post.userInfoResponse().firstName()} ${post.userInfoResponse().lastName()}</p>
            <p>Комментарий: ${post.comment()}</p>
        </#list>
    </div>

    <script src="/js/walkers.js" type="text/javascript"></script>
</@m.menuWithCommon>