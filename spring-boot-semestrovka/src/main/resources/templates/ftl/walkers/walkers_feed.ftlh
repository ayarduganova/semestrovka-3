<#import "../PARTS/menu&common.ftlh" as m>
<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin/users">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/walkers.css" admin=isAdmin>
    <div class="wrapper">
    <form id="search-form">
        <label for="query"></label><input type="text" class="form-control" id="query" name="query" placeholder="Начните вводить"/>
    </form>

    <div class="modal" id="modal">
        <form method="post">
        <div class="modal_box">
            <div class="modal_title">Отправьте заявку, чтобы стать выгульщиком</div>
            <div class="modal_info">
                <p><strong>Имя: </strong><label>
                        <input type="text" name="firstName" value="${user.firstName}" required/>
                    </label></p>
                <p><strong>Фамилия: </strong><label>
                        <input type="text" name="lastName" value="${user.lastName}" required/>
                    </label></p>
                <p><strong>Почта: </strong><label>
                        <input type="email" name="email" value="${user.email!}"/>
                    </label></p>
                <p><strong>Телефон: </strong><label>
                        <input type="tel" name="phone" value="${user.phone!}"/>
                    </label></p>
            </div>
            <div class="modal_bottom">
                <button type="submit" class="btn-send">Отправить</button>
                <a href="#" class="btn btn--close" id="btn_close">Закрыть</a>
            </div>
        </div>
        </form>
    </div>

    <#if service.hasWalkerRole(current_user)>
        <form method="get" action="../walkers/addPost">
            <button class="plus-button">+</button>
        </form>
    <#else>
        <a href="#" class="btn" id="btn">стать выгульщиком</a>
    </#if>

    <div id="feedback">
        <div class="post-list" id="post-list">
        <#list posts! as post>
            <div class="info">
            <p>Пользователь: ${post.userInfoResponse.firstName} ${post.userInfoResponse.lastName}</p>
            <p>Комментарий: ${post.comment}</p>
            </div>
        </#list>
        </div>
    </div>

    </div>

    <script src="/js/walkers.js" type="text/javascript"></script>
    <script type="application/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

    <script type="text/javascript" src="/js/ajax.js"></script>
</@m.menuWithCommon>
