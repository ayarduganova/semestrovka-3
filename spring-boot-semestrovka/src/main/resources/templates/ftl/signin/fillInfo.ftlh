<#import "/spring.ftl" as spring />
<#import "../PARTS/common.ftlh" as c>
<@c.common page="Sign up" css="/css/signin.css">
    <div class="wrapper-1">
        <h1>Заполните информацию о себе</h1>
        <form method="post">
            <div class="input-container">
            <div class="input-box"><input type="text" name="firstName" placeholder="Имя" required></div>
            <div class="input-box"><input type="text" name="lastName" placeholder="Фамилия" required></div>
            <div class="input-box"><input type="text" name="gender" placeholder="Пол" required></div>
            <div class="input-box"><input type="date" name="birthday" placeholder="Дата рождения" required></div>
            <div class="input-box"><input type="email" name="email" placeholder="Почта"></div>
            <div class="input-box"><input type="tel" name="phone" placeholder="Номер телефона"></div>
            </div>
            <input type="submit" class="btn" value="Войти">
            <p>${message!}</p>
            <input type="hidden" value="${username}" name="username">
        </form>
    </div>
</@c.common>