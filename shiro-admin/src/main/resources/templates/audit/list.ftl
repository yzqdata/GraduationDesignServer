<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">社团审批管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="<#--table-responsive-->">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <@shiro.hasPermission name="resource:audit:add">
                        <button id="btn_add" type="button" class="btn btn-default" title="发起审批">
                            <i class="fa fa-plus"></i> 发起审批
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
                <h4 class="modal-title" id="addroleLabel">社团审批</h4>
            </div>
            <div class="modal-body">
                <form id="addOrUpdateForm" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_name">社团名称: <span class="required">*</span></label>
<#--                        <div class="col-md-6 col-sm-6 col-xs-12">-->
<#--                            <input type="text" class="form-control col-md-7 col-xs-12" name="club_name" id="club_name" required="required" placeholder="请选择社团名称"/>-->
<#--                        </div>-->
                        <div class="col-md-6 col-sm-6 col-xs-6">
                            <select id="club_id" name="club_id" class="form-control col-md-5 col-xs-5">
                                <option value="">请选择</option>
                                <@zhydTag method="findByApplicantId">
                                    <#if findByApplicantId?? && findByApplicantId?size gt 0>
                                        <#list findByApplicantId as item>
                                            <option value="${item.id?c}">${item.club_name}</option>
                                        </#list>
                                    <#else>
                                        <option value="">无</option>
                                    </#if>
                                </@zhydTag>
                            </select>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_description">审批事项: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="audit_item" name="audit_item" required="required" placeholder="请输入要审批的事项"/>
                        </div>
                    </div>
                    <@shiro.hasPermission name="resource:audit:adminedit">
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="review_comments">审核意见: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="comments" id="comments" placeholder="请输入审核意见"/>
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

<div class="modal fade" id="addOrUpdateModalShenpi" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="addroleLabel">社团审批</h4>
            </div>
            <div class="modal-body">
                <form id="addOrUpdateFormShenpi" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_description">社团ID: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="club_id" name="club_id" required="required" placeholder="请输入要审批的事项"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_description">社团名称: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="club_name" name="club_name" required="required" placeholder="请输入要审批的事项"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="club_description">审批事项: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="audit_item" name="audit_item" required="required" placeholder="请输入要审批的事项"/>
                        </div>
                    </div>
                    <@shiro.hasPermission name="resource:audit:adminedit">
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="review_comments">审核意见: <span class="required">*</span></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input type="text" class="form-control col-md-7 col-xs-12" name="comments" id="comments"  required="required" placeholder="请输入审核意见"/>
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
                <button type="button" class="btn btn-primary addOrUpdateBtnShenpi">保存</button>
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
        var operateBtn = [
            '<@shiro.hasPermission name="resource:audit:adminshenpi"><a class="btn btn-xs btn-primary btn-auditshenpi"" data-id="' + trUserId + '"><i class="fa fa-trash-o"></i>审批事项</a></@shiro.hasPermission>',
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
                return '待审批';
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
            url: "/audit/list",
            getInfoUrl: "/audit/get/{id}",
            updateUrl: "/audit/edit",
            removeUrl: "/audit/remove",
            createUrl: "/audit/add",
            saveRolesUrl: "/audit/saveUserRoles",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'club_id',
                    title: '社团ID',
                    editable: false,
                }
                , {
                    field: 'club_name',
                    title: '社团名称',
                    editable: false,
                }, {
                    field: 'application_date',
                    title: '申请日期',
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
                    field: 'audit_item',
                    title: '审核事项',
                    editable: true
                }, {
                    field: 'auditor_name',
                    title: '审核人',
                    editable: true
                }, {
                    field: 'status',
                    title: '审核状态',
                    editable: false,
                    formatter: statusFormatter
                }, {
                    field: 'comments',
                    title: '审核意见',
                    editable: false
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }
            ],
            modalName: "审批信息"
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