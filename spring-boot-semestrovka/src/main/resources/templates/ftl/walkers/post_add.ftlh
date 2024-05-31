<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin/users">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/walkers.css" admin=isAdmin>

    <div class="wrapper">
    <form method="post">
    <p>Комментарий: <label>
            <textarea name="comment" rows="5" cols="33" placeholder="Введите свой комментарий" required></textarea>
        </label></p>
    <button type="submit">Save</button>
    </form>
    </div>

    <script src="/js/walkers.js" type="text/javascript"></script>
</@m.menuWithCommon>