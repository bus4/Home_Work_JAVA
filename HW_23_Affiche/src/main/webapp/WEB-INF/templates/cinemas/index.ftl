<#include "../main-template.ftl"/>

<#macro m_body>
<div class="col-md-8 col-md-offset-2 posts">

    <h1>Афиша города Казани
    <#--<@security.authentication property="principal.name"/>-->
    </h1>
    <h1><a href="/films" class="btn btn-link">Фильмы</a>  /  Кинотеатры</h1>
    <form action="/logout" method="post">
        <input type="submit" value="Выход из аккаунта">
    </form>
    <br>
    <br>
    <form action="/cinemas" method="get">
        <input type="text" name="phraze" width="600px">
        <input type="submit" value="Search">
    </form>
    <br>

    <div class="add">

        <a href="/cinemas/add" class="btn btn-default show-add-post">Добавить новый кинотеатр</a>

        <div style="display: none;" class="add-post">
            <form action="/cinemas/add" method="post" modelAttribute="cinema">
                <br>
                <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Название</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" id="inputEmail3">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Описание</label>
                    <div class="col-sm-10">
                        <input type="text" name="description" class="form-control" id="inputPassword3">
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
    <#--<iframe width="560" height="315" src="https://www.youtube.com/embed/Y7JCghWjj_A" frameborder="0" allowfullscreen></iframe>-->

    <#list cinemas as cinema>
        <div class="post">
             <h3 class="post-head"><a href="/cinemas/${cinema.id}">${cinema.name}</a></h3>
            <small class="post-head">Рейтинг: ${cinema.rating}</small>
            <#--<small class="post-head">Автор: ${(post.suser.mail)!"Неизвестен"} / Дата: ${post.date}</small>-->

            <p class="post-text">${cinema.description[0..*127]}</p>
            <p style="display: none;" class="post-text">${cinema.description}</p>
            <#if (cinema.description?length > 127) >
                <a href="/cinema/${cinema.id}" class="show-post-text">Читать полностью...</a><br>
            </#if>

            <div style="display: none;" class="cont"></div>

            <a style="display: none;" class="btn btn-default hide-nedit-post">Отмена</a>

            <br class="post-head">
            <a href="/cinemas/${cinema.id}/delete" class="btn btn-danger delete-post">Удалить кинотеатр</a>
            <#--<a href="/cinemas/${cinema.id}/edit" class="btn btn-default nedit-post">Редактировать</a>-->
        </div>
    <#else>
        <p>Пока ничего нет!</p>
    </#list>
</div>
</#macro>
<@main title="Афиша" customScripts=["/resources/js/posts.js"]/>