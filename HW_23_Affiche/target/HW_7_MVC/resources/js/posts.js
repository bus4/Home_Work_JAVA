$(document).ready(function () {
    $(".show-post-text").on('click', function (e) {
        var $parent = $(this).parent('.post');
        $parent.children('.post-text').toggle();
        return false;
    });

    $(".delete-post").click(function () {
        var url = $(this).attr("href");
        var $post = $(this).parent('.post');

        $.ajax(url, {
            method: 'GET',
            success: function () {
                $post.hide();
            }
        });
        return false;
    });

    $(".nedit-post").click(function () {
        var url = $(this).attr("href");
        var $post = $(this).parent('.post');
        var $cont = $post.children('.cont');
        $.ajax(url, {
            method: 'GET',
            success: function () {
                $cont.load(url);
                $post.children('.delete-post').hide("slide");
                $post.children('.nedit-post').hide("slide");
                $post.children('.post-head').hide("slide");
                $post.children('.show-post-text').hide("slide");
                $post.children('.post-text').hide("slide");
                $cont.slideToggle();
                $post.children('.hide-nedit-post').slideToggle();
            }
        });
        return false;
    });

    $(".hide-nedit-post").click(function () {
        var $post = $(this).parent('.post');
        var $cont = $post.children('.cont');
        // $cont.load(" ");
        $cont.slideToggle();
        $post.children('.hide-nedit-post').slideToggle();
        $post.children('.delete-post').show("slide");
        $post.children('.nedit-post').show("slide");
        $post.children('.post-head').show("slide");
        $post.children('.show-post-text').show("slide");
        $post.children('.post-text').show("slide");

        return false;
    });

    $(".show-add-post").click(function () {
        var $parent = $(this).parent('.add');
        var url = $(this).attr("href");
        // alert(url);
        $.ajax(url, {
            method: 'GET',
            success: function () {
                $parent.children('.add-post').slideToggle();

            }
        });

        return false;
    });

})

