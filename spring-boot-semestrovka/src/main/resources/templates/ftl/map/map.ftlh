<#ftl encoding="UTF-8"/>
<#import "../PARTS/menu&common.ftlh" as m>

<#assign isAdmin>
    <#if current_user.isAdmin()>
        <a href="../admin/users">Админ</a>
    </#if>
</#assign>
<@m.menuWithCommon page="main" css="/css/map.css" admin=isAdmin>
    <script src="https://api-maps.yandex.ru/2.1/?apikey=a2737b91-85ee-4441-befd-2436997ef8b8&lang=ru_RU" type="text/javascript">
    </script>
    <script src="/js/map.js" type="text/javascript"></script>
    <div id="map"></div>
    <ul id="addressList">
        <li data-lat="55.745354" data-lon="49.198585">Республика Татарстан, Казань, Приволжский район, сквер по улице Академика Парина</li>
        <li data-lat="55.733767" data-lon="49.175465">Республика Татарстан, Казань, Приволжский район, жилой комплекс Солнечный Город</li>
        <li data-lat="55.759326" data-lon="49.193550">Республика Татарстан, Казань, Приволжский район, микрорайон Горки-1, 2-й микрорайон</li>
    </ul>
</@m.menuWithCommon>