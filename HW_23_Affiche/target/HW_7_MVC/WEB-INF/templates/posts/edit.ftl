<#--<!DOCTYPE html>-->
<#--<html>-->
<#--<body>-->
<div class="edit-post">
    <form action="/posts/${post.id}/save" method="post" modelAttribute="post">
        <br>
        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 col-form-label">Заголовок</label>
            <div class="col-sm-10">
                <input type="text" name="title" class="form-control" id="inputEmail3" value="${post.title}">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Текст</label>
            <div class="col-sm-10">
                <input type="text" name="text" class="form-control" id="inputPassword3" value="${post.text}">
            </div>
        </div>
        <div class="form-group row">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Сохранить</button>
                <#--<a class="btn btn-default hide-nedit-post">Отмена</a>-->
            </div>
        </div>
    <#--<br>-->
    </form>
</div>
<#--</body>-->
<#--<@main title="Вход"/>-->