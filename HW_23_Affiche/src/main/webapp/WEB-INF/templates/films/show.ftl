<#include "../main-template.ftl"/>

<#macro m_body>
<div class="col-md-8 col-md-offset-2 posts">

<#--<h1>${film.name}-->
<#--<@security.authentication property="principal.name"/>-->

<#--</h1>-->

<#--<form action="/logout" method="post">-->
<#--<input type="submit" value="Выход из аккаунта">-->
<#--</form>-->
<#--<br>-->
<#--<br>-->
<#--<form action="/films" method="get">-->
<#--<input type="text" name="phraze" width="600px">-->
<#--<input type="submit" value="Search">-->
<#--</form>-->
<#--<br>-->


<#--<#list films as film>-->
    <div class="post">
        <h1 class="post-head">${film.name}</h1>
        <p style="color: orange" class="post-head">Рейтинг: ${film.rating}</p>
    <#--<small class="post-head">Автор: ${(post.suser.mail)!"Неизвестен"} / Дата: ${post.date}</small>-->

        <p class="post-text">${film.description}</p>

        <a href="/films/${film.id?c}/seances" class="btn btn-default ">Расписание</a>
        <br>
        <a href="/films" class="btn btn-link">Все фильмы</a>

    <#--<p style="display: none;" class="post-text">${film.description}</p>-->
    <#--<#if (film.description?length > 127) >-->
    <#--<a href="/film/${film.id}" class="show-post-text">Читать полностью...</a><br>-->
    <#--</#if>-->

    <#--<div style="display: none;" class="cont"></div>-->

    <#--<a style="display: none;" class="btn btn-default hide-nedit-post">Отмена</a>-->

    <#--<a href="/films/${film.id}/delete" class="btn btn-danger delete-post">Удалить фильм</a>-->
    <#--<a href="/films/${film.id}/edit" class="btn btn-default nedit-post">Редактировать</a>-->
    </div>
<#--<#else>-->
<#--<p>Пока ничего нет!</p>-->
<#--</#list>-->

<#--<a href="/films/${film.id}/seances" class="btn btn-default nedit-post">Расписание</a>-->

    <div class="add">
        <br class="post-head">

        <a href="/films/${film.id?c}/comments/add" class="btn btn-default show-add-post">Добавить новый комментарий</a>

    <#--<div class="add-post">-->
        <div style="display: none;" class="add-post">
            <form action="/films/${film.id?c}/comments/add" method="post" modelAttribute="comment">
                <br>
                <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">Ваш комментарий</label>
                    <div class="col-sm-10">
                        <input type="text" name="text" class="form-control" id="inputEmail3">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="reviewStars-input" class="col-sm-2 col-form-label">Ваша оценка фильма</label>
                    <div class="col-sm-10">
                        <#--<input type="number" min="0" max="10" name="rating" class="form-control" id="inputEmail3">-->
                    <#--<output for="inputEmail3" name="level">0</output>/10-->

                        <div id="reviewStars-input">
                            <input id="star-4" type="radio" name="rating" value="5"/>
                            <label title="gorgeous" for="star-4"></label>

                            <input id="star-3" type="radio" name="rating" value="4"/>
                            <label title="good" for="star-3"></label>

                            <input id="star-2" type="radio" name="rating" value="3"/>
                            <label title="regular" for="star-2"></label>

                            <input id="star-1" type="radio" name="rating" value="2"/>
                            <label title="poor" for="star-1"></label>

                            <input id="star-0" type="radio" name="rating" value="1"/>
                            <label title="bad" for="star-0"></label>
                        </div>


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

    <#list filmComments as comment>
        <div class="post">
            <h3 class="post-head">${comment.suser.name}</h3>
            <small class="post-head">Дата: ${comment.date}</small>
            <small style="color: orange" class="post-head">Оценка: ${comment.rating}</small>
        <#--<small class="post-head">Автор: ${(post.suser.mail)!"Неизвестен"} / Дата: ${post.date}</small>-->

            <p class="post-text">${comment.text[0..*127]}</p>
            <p style="display: none;" class="post-text">${comment.text}</p>
            <#if (comment.text?length > 127) >
                <a href="/films/${film.id}/comments/${comment.id}" class="show-post-text">Читать полностью...</a><br>
            </#if>

        <#--<div style="display: none;" class="cont"></div>-->

        <#--<a style="display: none;" class="btn btn-default hide-nedit-post">Отмена</a>-->

            <br class="post-head">

            <a href="/films/${film.id}/comments/${comment.id?c}/delete" method="get" class="btn btn-danger">Удалить
                комментарий</a>
        <#--<a href="/comments/${comment.id}/edit" class="btn btn-default nedit-post">Редактировать</a>-->
        </div>
    <#else>
        <p>Пока ничего нет!</p>
    </#list>
</div>
</#macro>
<#--<@main title="Афиша"/>-->
<@main title="Афиша" customScripts=["/resources/js/posts.js"]/>