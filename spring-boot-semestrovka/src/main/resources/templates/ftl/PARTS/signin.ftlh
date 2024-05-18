<#macro signin message button href textForHref text title>
    <div class="wrapper">
        <h1>${title}</h1>
        <form method="post">
            <div class="input-box"><input type="text" name="username" placeholder="имя пользователя" required></div>
            <div class="input-box"><input type="password" name="password" placeholder="пароль" required></div>
            <input type="submit" class="btn" value="${button}">
            <p>${message}</p>
            <div class="sign">
             ${text}
            <a href=${href}>${textForHref}</a>
            </div>
        </form>
    </div>
</#macro>