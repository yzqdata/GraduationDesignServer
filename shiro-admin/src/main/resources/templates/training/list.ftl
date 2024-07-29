<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">社团培训信息浏览</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="<#--table-responsive-->">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <@shiro.hasPermission name="resource:training:add">
                            <button id="btn_add" type="button" class="btn btn-default" title="新增培训">
                                <i class="fa fa-plus"></i>新增培训信息
                            </button>
                        </@shiro.hasPermission>
                        <#--                        <@shiro.hasPermission name="resource:community:adminedit">-->
                        <#--                            <button id="btn_delete_ids" type="button" class="btn btn-default" title="删除选中">-->
                        <#--                                <i class="fa fa-trash-o"></i> 批量删除-->
                        <#--                            </button>-->
                        <#--                        </@shiro.hasPermission>-->
                    </div>
                    <table id="tablelist">
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/layout/footer.ftl"/>
<!--弹框-->
<div class="modal fade bs-example-modal-sm" id="selectRole" tabindex="-1" role="dialog" aria-labelledby="selectRoleLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="selectRoleLabel">分配角色</h4>
            </div>
            <div class="modal-body">
                <form id="boxRoleForm">
                    <div class="zTreeDemoBackground left">
                        <ul id="treeDemo" class="ztree"></ul>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--/弹框-->
<!--添加用户弹框-->
<div class="modal fade" id="addOrUpdateModal" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="addroleLabel">新增培训信息</h4>
            </div>
            <div class="modal-body">
                <form id="addOrUpdateForm" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="course_name">课程名称: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="course_name" id="course_name" required="required" placeholder="请输入课程名称"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="course_description">课程描述: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="course_description" name="course_description" required="required" placeholder="请输入课程描述"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="course_date">课程时间: <span class="required">*</span></label>
<#--                        <div class="input-group date" id="myDatepicker">-->
<#--                            <input type="text" class="form-control"  name="course_date" id="course_date"/>-->
<#--                            <span class="input-group-addon">-->
<#--                                    <span class="glyphicon glyphicon-calendar"></span>-->
<#--                                </span>-->
<#--                        </div>-->
                        <div class="col-sm-4">
                            <div class="form-group">
                                <div class="input-group date" id="myDatepicker">
                                    <input type="text" class="form-control"  name="course_date" id="course_date"/>
                                    <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                                </div>
                            </div>
                        </div>
                    </div>
<#--                    <div class="col-sm-4">-->
<#--                        Basic Example-->
<#--                        <div class="form-group">-->
<#--                            <div class="input-group date" id="myDatepicker">-->
<#--                                <input type="text" class="form-control"  name="course_date" id="course_date"/>-->
<#--                                <span class="input-group-addon">-->
<#--                                    <span class="glyphicon glyphicon-calendar"></span>-->
<#--                                </span>-->
<#--                            </div>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                    <div class="item form-group">-->
<#--                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="course_time">课程时间: <span class="required">*</span></label>-->
<#--                        <div class="col-md-6 col-sm-6">-->
<#--                            <input class="form-control" class="time" type="time" name="course_time" id="course_time" required="required">-->
<#--                        </div>-->
<#--                    </div>-->
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="location">培训地点: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="location" id="location" placeholder="请输入培训地点"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="instructor_name">培训讲师: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="instructor_name" id="instructor_name" placeholder="请输入培训讲师"/>
                        </div>
                    </div>
                   <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="max_participants">最大参与人数: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="max_participants" id="max_participants" placeholder="请输入最大参与人数"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="current_participants">当前参与人数: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="current_participants" id="current_participants" placeholder="请输入当前参与人数"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary addOrUpdateBtn">保存</button>
            </div>
        </div>
    </div>
</div>
<!--/添加用户弹框-->
<script>
    $(function () {
        $('#myDatepicker').datetimepicker();
    });
    /**
     * 操作按钮
     * @param code
     * @param row
     * @param index
     * @returns {string}
     */
    function operateFormatter(code, row, index) {
        var currentUserId = '${user.id}';
        console.log("currentUserId="+currentUserId);
        var trUserId = row.id;
        var operateBtn = [
            '<@shiro.hasPermission name="resource:training:edit"><a class="btn btn-xs btn-primary btn-update" data-id="' + trUserId + '"><i class="fa fa-edit"></i>编辑培训信息</a></@shiro.hasPermission>',
            '<@shiro.hasPermission name="resource:training:delete"><a class="btn btn-xs btn-danger btn-remove" data-id="' + trUserId + '"><i class="fa fa-trash-o"></i>删除培训信息</a></@shiro.hasPermission>'

        ];
        return operateBtn.join('');
    }

    function statusFormatter(value, row, index) {
        // 根据 'status' 字段的值来返回不同的字符串
        switch (value) {
            case 0:
                return '待审批';
            case 1:
                return '已注销';
            case 2:
                return '审批不通过';
            default:
                return '未知状态';
        }
    }

    function statusFormatter2(value, row, index) {
        // 根据 'status' 字段的值来返回不同的字符串
        switch (value) {
            case 0:
                return '-';
            default:
                return value;
        }
    }


    $(function () {
        var options = {
            url: "/training/list",
            getInfoUrl: "/training/get/{id}",
            updateUrl: "/training/edit",
            removeUrl: "/training/remove",
            createUrl: "/training/add",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'course_name',
                    title: '课程名称',
                    editable: false,
                }, {
                    field: 'course_description',
                    title: '课程描述',
                    editable: true
                }, {
                    field: 'course_date',
                    title: '课程日期',
                    editable: true,
                    formatter: function (code) {
                        switch (code) {
                            case null:
                                return '-';
                            default:
                                return new Date(code).format("yyyy-MM-dd hh:mm:ss")
                        }
                    }
                }, {
                    field: 'location',
                    title: '培训地点',
                    editable: false
                }, {
                    field: 'instructor_name',
                    title: '培训讲师',
                    editable: false
                }, {
                    field: 'max_participants',
                    title: '最大参与人数',
                    editable: false
                }, {
                    field: 'current_participants',
                    title: '当前参与人数',
                    editable: false
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }
            ],
            modalName: "注销社团信息"
        };
        //1.初始化Table
        $.tableUtil.init(options);
        //2.初始化Button的点击事件
        $.buttonUtil.init(options);

        /* 分配用户角色 */
        $('#tablelist').on('click', '.btn-allot', function () {
            console.log("分配权限");
            var $this = $(this);
            var userId = $this.attr("data-id");
            $.ajax({
                async: false,
                type: "POST",
                data: {uid: userId},
                url: '/roles/rolesWithSelected',
                dataType: 'json',
                success: function (json) {
                    var data = json.data;
                    console.log(data);
                    var setting = {
                        check: {
                            enable: true,
                            chkboxType: {"Y": "ps", "N": "ps"},
                            chkStyle: "radio"
                        },
                        data: {
                            simpleData: {
                                enable: true
                            }
                        },
                        callback: {
                            onCheck: function (event, treeId, treeNode) {
                                console.log(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
                                var treeObj = $.fn.zTree.getZTreeObj(treeId);
                                var nodes = treeObj.getCheckedNodes(true);
                                var ids = new Array();
                                for (var i = 0; i < nodes.length; i++) {
                                    //获取选中节点的值
                                    ids.push(nodes[i].id);
                                }
                                console.log(ids);
                                console.log(userId);
                                $.post(options.saveRolesUrl, {"userId": userId, "roleIds": ids.join(",")}, function (obj) {
                                }, 'json');
                            }
                        }
                    };
                    var tree = $.fn.zTree.init($("#treeDemo"), setting, data);
                    tree.expandAll(true);//全部展开

                    $('#selectRole').modal('show');
                }
            });
        });
    });
</script>