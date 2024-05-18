<#import "/spring.ftl" as spring />
<#import "../PARTS/common.ftlh" as c>
<#import "../PARTS/signin.ftlh" as s>
<@c.common page="Sign up" css="/css/signin.css">
    <@s.signin message="${message!}" button="Зарегистрироваться" href="./login" textForHref="Войти" text="Уже есть аккаунт?" title="Регистрация"/>
</@c.common>
