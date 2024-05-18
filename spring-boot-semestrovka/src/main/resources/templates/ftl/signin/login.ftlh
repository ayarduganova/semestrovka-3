<#ftl encoding="UTF-8"/>
<#import "../PARTS/common.ftlh" as c>
<#import "../PARTS/signin.ftlh" as s>
<@c.common page="Sign in" css="/css/signin.css">
    <@s.signin message="${message!}" button="Войти" href="./signUp" textForHref="Зарегистрироваться" text="Ещё нет аккаунта?" title="Вход"/>
</@c.common>
