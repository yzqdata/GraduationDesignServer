<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>社团管理系统</title>
    <link href="/assets/images/favicon.jpg" rel="shortcut icon" type="image/x-icon">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/jquery-confirm/2.5.1/jquery-confirm.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/fancybox/2.1.5/jquery.fancybox.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/nprogress/0.2.0/nprogress.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/toastr.js/2.0.3/css/toastr.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/iCheck/1.0.2/skins/square/green.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-daterangepicker/2.1.24/daterangepicker.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/zTree.v3/3.5.29/css/metroStyle/metroStyle.min.css" rel="stylesheet">

    <link href="/assets/css/zhyd.core.css" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/" class="site_title"><i class="fa fa-coffee"></i> <span>社团管理系统</span></a>
                </div>
                <div class="clearfix"></div>
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="/assets/images/touxiang.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
<#--                        <span>你好,尊敬的：<#if user?exists>${user.username?if_exists}<#else>管理员</#if></span>-->
                        <h2>本次登录账户：<#if user?exists>${user.username?if_exists}<#else>管理员</#if></h2>
                        <br>
                        <h2>欢迎您来到社团管理系统</h2>
                    </div>
                </div>
                <br />
            <#include "/layout/sidebar.ftl"/>
            </div>
        </div>
        <#include "/layout/setting.ftl"/>
        <div class="right_col" role="main">