<#include "../main-template.ftl"/>

<#macro m_body>
<div class="col-md-8 col-md-offset-2 posts">

    <h1>Расписание фильма "${film.name}"
    <#--<@security.authentication property="principal.name"/>-->
    </h1>
    <a href="/films" class="btn btn-link">Все фильмы</a>

<#--<form action="/logout" method="post">-->
<#--<input type="submit" value="Выход из аккаунта">-->
<#--</form>-->
    <br>
    <br>
    <form action="/films" method="get">
        <input type="text" name="phraze" width="600px">
        <input type="submit" value="Search">
    </form>
    <br>

    <div class="add">

        <a href="/films/${film.id?c}/seances/add" class="btn btn-default show-add-post">Добавить новый сеанс</a>

        <div style="display: none;" class="add-post">
            <form action="/films/${film.id?c}/seances/add" method="post" modelAttribute="seance">

                <br>
            <#--<div class="form-group row">-->
            <#--<label for="inputEmail3" class="col-sm-2 col-form-label">Дата</label>-->
            <#--<div class="col-sm-10">-->
            <#--&lt;#&ndash;<input type="datetime" name="date" class="date-cell" id="inputEmail3">&ndash;&gt;-->
            <#--</div>-->
            <#--</div>-->
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-labe">Дата</label>
                    <div class="col-sm-10">
                        <input type="datetime-local" name="date" class="form-control" value="2017-01-10T14:00:00"
                               id="inputPassword3">
                    </div>
                </div>
            <#--<input type="datetime" name="date">-->

                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Цена билета</label>
                    <div class="col-sm-10">
                        <input type="number" name="price" class="form-control" step="10" id="inputPassword3">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Кинотеатр</label>
                    <div class="col-sm-10">
                        <select type="number" name="cinema" class="form-control" id="inputPassword3">
                        <#--<select type="text" name="cinema" class="custom-select mb-2 mr-sm-2 mb-sm-0" id="inlineFormCustomSelect">-->
                        <#--<select list="cinemas" type="text" name="cinema" class="form-control" id="inputPassword3">-->
                        <#--<datalist id="<cinemas>">-->
                            <#list cinemas as cinema>
                                <option value="${cinema.id}">${cinema.name}</option>
                            <#--<option name="${cinema.name}" value="${cinema.id}">-->
                            </#list>
                        </select>

                    <#--</datalist>-->

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
        <br>
    </div>
<#--<iframe width="560" height="315" src="https://www.youtube.com/embed/Y7JCghWjj_A" frameborder="0" allowfullscreen></iframe>-->
    <#assign lastcinema="">
    <div class="post">

        <#list seances as seance>
            <#if (seance.cinema.name != lastcinema) >
                <hr>
                <h3 class="post-head">${seance.cinema.name}</h3>
                <br class="post-head">
                <#assign lastcinema=seance.cinema.name>
            </#if>


        <#--<small class="post-head">Цена: ${seance.price}</small>-->
        <#--<small class="post-head">Автор: ${(post.suser.mail)!"Неизвестен"} / Дата: ${post.date}</small>-->

            <p class="btn btn-default">${seance.date}</p>
        <#--<p class="post-text">${seance.film.name}</p>-->
        <#--<p style="display: none;" class="post-text">${seance.cinema.name}</p>-->
        <#--<a href="/seance/${seance.id}" class="show-post-text">Читать полностью...</a><br>-->

        <#--<div style="display: none;" class="cont"></div>-->

        <#--<a style="display: none;" class="btn btn-default hide-nedit-post">Отмена</a>-->

        <#--<a href="/seances/${seance.id}/delete" class="btn btn-danger delete-post">Удалить фильм</a>-->
        <#--<a href="/seances/${seance.id}/edit" class="btn btn-default nedit-post">Редактировать</a>-->
        <#else>
            <p>Пока ничего нет!</p>
        </#list>
    </div>

</div>
</#macro>
<@main title="Афиша" customScripts=["/resources/js/posts.js"]/>