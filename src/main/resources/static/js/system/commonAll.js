
//每个页面的ajax的回调函数
var handlerMessage = function (data) { //form中已经设置了action,method
    if(data.success){ //用alert或者popup都可以
        $.messager.alert("温馨提示","操作成功!2s后自动关闭")
        window.setTimeout(function () {
            window.location.reload();
        },2000)
    }else{
        $.messager.popup(data.msg)
    }
}

$(function () {
    $.messager.model = {ok: {text: "确定", classed: 'btn-primary'}, cancel: {text: "取消", classed: 'btn-default'}};
    $('.btn_delete').click(function () {
        var url = $(this).data('url');
        $.messager.confirm('温馨提示', '确定要删除吗？', function () {
            $.get(url,handlerMessage);
        })
    });
});

$.messager.model = {
    ok:{text:"确认"},
    cancel:{text:"取消"}
}

//禁用数组添加[]的功能
jQuery.ajaxSettings.traditional = true;