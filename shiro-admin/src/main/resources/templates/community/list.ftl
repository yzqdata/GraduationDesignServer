<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">社团登记管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="<#--table-responsive-->">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <@shiro.hasPermission name="resource:community:add">
                        <button id="btn_add" type="button" class="btn btn-default" title="创建社团">
                            <i class="fa fa-plus"></i> 创建社团
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
                <h4 class="modal-title" id="addroleLabel">创建社团</h4>
            </div>
            <div class="modal-body">
                <form id="addOrUpdateForm" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_name">社团名称: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="club_name" id="club_name" required="required" placeholder="请输入社团名称"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_description">社团简介: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="club_description" name="club_description" required="required" placeholder="请输入社团简介"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_goals">社团目标和计划: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="club_goals" id="club_goals" placeholder="请输入社团目标和计划"/>
                        </div>
                    </div>
                    <@shiro.hasPermission name="resource:community:adminedit">
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="review_comments">审核意见: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="review_comments" id="review_comments" placeholder="请输入审核意见"/>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">是否可用: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <select name="status" id="status" required="required" class="form-control col-md-7 col-xs-12">
                                    <option value="">请选择状态</option>
                                    <option value="0" selected="selected">待审批</option>
                                    <option value="1">审批通过</option>
                                    <option value="2">审批不通过</option>
                                </select>
                            </div>
                        </div>
                    </@shiro.hasPermission>
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


<!--/注销用户弹窗-->
<div class="modal fade" id="addOrUpdateModalZhuxiao" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="addroleLabel">注销社团</h4>
            </div>
            <div class="modal-body">
                <form id="addOrUpdateFormZhuxiao" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_name">社团名称: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="club_name" id="club_name" required="required" placeholder="请输入社团名称"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_goals">注销原因: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="reason_for_cancellation" id="reason_for_cancellation" placeholder="请输入注销原因"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary addOrUpdateBtnZhuxiao">注销提交</button>
            </div>
        </div>
    </div>
</div>

<script>
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
        console.log("trUserId="+currentUserId);
        var operateBtn = [
            '<@shiro.hasPermission name="resource:community:adminedit"><a class="btn btn-xs btn-primary btn-adminedit" data-id="' + trUserId + '"><i class="fa fa-edit"></i>审批社团</a></@shiro.hasPermission>',
            '<@shiro.hasPermission name="resource:community:submitwriteoff"><a class="btn btn-xs btn-danger btn-zhuxiao" data-id="' + trUserId + '"><i class="fa fa-edit"></i>注销社团</a></@shiro.hasPermission>',
            '<@shiro.hasPermission name="resource:community:proprieteredit"><a class="btn btn-xs btn-primary btn-update" data-id="' + trUserId + '"><i class="fa fa-edit"></i>编辑社团信息</a></@shiro.hasPermission>'
        ];
        return operateBtn.join('');
    }

    function statusFormatter(value, row, index) {
        // 根据 'status' 字段的值来返回不同的字符串
        switch (value) {
            case 0:
                return '待审批';
            case 1:
                return '审批通过';
            case 2:
                return '审批不通过';
            default:
                return '已注销';
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
            url: "/community/list",
            getInfoUrl: "/community/get/{id}",
            updateUrl: "/community/edit",
            removeUrl: "/community/remove",
            writeoffUrl: "/community/submitwriteoff",
            createUrl: "/community/add",
            saveRolesUrl: "/community/saveUserRoles",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'club_name',
                    title: '社团名称',
                    editable: false,
                }, {
                    field: 'club_description',
                    title: '社团简介',
                    editable: true
                }, {
                    field: 'club_goals',
                    title: '社团目标和计划',
                    editable: true
                }, {
                    field: 'application_name',
                    title: '申请者',
                    editable: true
                }, {
                    field: 'application_date',
                    title: '申请时间',
                    editable: false,
                    formatter: function (code) {
                        return new Date(code).format("yyyy-MM-dd")
                    }
                }, {
                    field: 'status',
                    title: '状态',
                    editable: false,
                    formatter: statusFormatter // 使用自定义的格式化方法
                }, {
                    field: 'reviewer_name',
                    title: '审核人',
                    editable: false,
                    formatter: statusFormatter2
                }, {
                    field: 'review_date',
                    title: '审核日期',
                    editable: false,
                    formatter: function (code) {
                        switch (code) {
                            case null:
                                return '-';
                            default:
                                return new Date(code).format("yyyy-MM-dd")
                        }
                    }
                }, {
                    field: 'review_comments',
                    title: '审核意见',
                    editable: false
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }
            ],
            modalName: "社团"
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