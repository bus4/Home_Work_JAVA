<#include "../main-template.ftl"/>

<#macro m_body>
<div class="col-md-8 col-md-offset-2 posts">

    <h1>Добро пожаловать в мой Блог,
        <@security.authentication property="principal.mail"/>
        !
    </h1>
    <form action="/logout" method="post">
        <input type="submit" value="Выход из аккаунта">
    </form>
    <br>
    <br>
    <form action="/posts" method="get">
        <input type="text" name="phraze" width="600px">
        <input type="submit" value="Search">
    </form>
    <br>

    <div class="add">

        <a href="/posts/add" class="btn btn-default show-add-post">Добавить новый пост</a>

        <div style="display: none;" class="add-post">
            <form action="/posts/add" method="post" modelAttribute="post">
                <br>
                <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Заголовок</label>
                    <div class="col-sm-10">
                        <input type="text" name="title" class="form-control" id="inputEmail3">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Текст</label>
                    <div class="col-sm-10">
                        <input type="text" name="text" class="form-control" id="inputPassword3">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Сохранить</button>
                    </div>
                </div>
                <br>
            </form>
        </div>
    </div>

    <#list posts as post>
        <div class="post">
            <h3 class="post-head">${post.title}</h3>
            <small class="post-head">Автор: ${(post.suser.mail)!"Неизвестен"} / Дата: ${post.date}</small>

            <p class="post-text">${post.text[0..*127]}</p>
            <p style="display: none;" class="post-text">${post.text}</p>
            <#if (post.text?length > 127) >
                <a href="/posts/${post.id}" class="show-post-text">Читать полностью...</a><br>
            </#if>

            <div style="display: none;" class="cont"></div>

            <a style="display: none;" class="btn btn-default hide-nedit-post">Отмена</a>

            <br class="post-head">
            <a href="/posts/${post.id}/delete" class="btn btn-danger delete-post">Удалить пост</a>
            <a href="/posts/${post.id}/edit" class="btn btn-default nedit-post">Редактировать</a>
        </div>
    <#else>
        <p>Пока ничего нет!</p>
    </#list>
</div>
</#macro>
<@main title="Посты" customScripts=["/resources/js/posts.js"]/>