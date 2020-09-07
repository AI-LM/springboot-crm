<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>公告通知管理</title>
    <!--freemarker引入模板文件 使用相对路径来引入的-->
    <#include "../common/link.ftl" >
    <script>
        $(function () {
            //新增/编辑按钮点击事件
            $(".btn-input").click(function () {
                //清除模态框的数据
                 $("#editForm input").val('');
                 $("#editForm textarea").val('');
                //$("#editForm")[0].reset(); //不能清除隐藏域
                //获取事件源绑定的数据 使用data方法可以很方便获取data-*开头的属性的数据
                var json = $(this).data("json");
                if(json){ //json有数据代表是编辑
                    $("#editForm input[name=id]").val(json.id);
                    $("#editForm input[name=title]").val(json.title);
                    $("#editForm textarea[name=content]").val(json.content);
                }
                //打开模态框
                $("#myModal").modal('show');
            })


            //保存
            $(".btn-submit").click(function () {
                //使用jquery-form插件来提交异步表单(有表单时会使用该插件,写的代码比较少)
                $("#editForm").ajaxSubmit(handlerMessage)
            })


           //删除按钮
           $(".btn-delete").click(function () {
                //获取当前点击的公告通知id
               var id = $(this).data('id');
               //提示确认框
               $.messager.confirm("警告","是否确认删除?",function () {
                   //发送ajax请求
                   $.get('/notice/delete.do',{id:id},handlerMessage)
               })


           })



        })
    </script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!--页面头部-->
    <#include "../common/navbar.ftl" >
    <!--菜单回显 声明变量设置值-->
    <#assign currentMenu="notice"/>
    <!--菜单-->
    <#include "../common/menu.ftl" >
    <div class="content-wrapper">
        <section class="content-header">
            <h1>公告通知管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/notice/list.do" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <a href="#" class="btn btn-success btn-input" style="margin: 10px">
                            <span class="glyphicon glyphicon-plus"></span> 添加
                        </a>
                </form>
                <!--编写内容-->
                <div class="box-body table-responsive no-padding ">

                    <table class="table table-hover table-bordered">
                        <tr>
                            <th>编号</th>
                            <th>公告标题</th>
                            <th>发布人</th>
                            <th>发布时间</th>
                            <th>是否已读</th>
                            <th>操作</th>
                        </tr>
                            <#list result.list as notice>
                                  <tr>
                                      <!--freemarker 如果取值时是空值 会报错-->
                                      <td>${notice_index+1}</td>
                                      <td>${notice.title!}</td>
                                      <td>${(notice.employee.name)!}</td>
                                      <td>${(notice.pubDate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                                      <td>${notice.noticeId!}</td>
                                      <td>
                                          <a href="/notice/show.do?id=${notice.id!}"
                                             class="btn btn-success btn-xs btn-trace">
                                              <span class="glyphicon glyphicon-phone"></span> 查看
                                          </a>
                                          <!-- 使用data-*绑定自定义数据-->
                                          <a href="#"
                                             class="btn btn-info btn-xs btn-input"
                                             data-json='${notice.json!}' >
                                              <span class="glyphicon glyphicon-pencil"></span> 编辑
                                          </a>

                                              <a href="#"
                                                 class="btn btn-danger btn-xs btn-delete"
                                                    data-id='${notice.id!}'>
                                                  <span class="glyphicon glyphicon-trash"></span> 删除
                                              </a>

                                      </td>
                                  </tr>
                            </#list>
                    </table>
                    <!--分页-->
                    <#include "../common/page.ftl">


                </div>
            </div>
        </section>
    </div>
     <#include "../common/footer.ftl">
</div>


<!-- Modal模态框 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="/notice/saveOrUpdate.do" method="post" id="editForm">
                    <input type="hidden" name="id">
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="title" class="col-sm-3 control-label">公告标题：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="title" name="title"
                                   placeholder="请输入公告标题">
                        </div>
                    </div>

                    <div class="form-group" >
                        <label for="title" class="col-sm-3 control-label">公告内容：</label>
                        <div class="col-lg-6">
                            <textarea type="text" class="form-control" id="content" name="content"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary btn-submit">保存</button>
            </div>
        </div>
    </div>
</div>



</body>
</html>
