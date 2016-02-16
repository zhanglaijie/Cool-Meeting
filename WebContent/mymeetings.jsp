<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
   		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                  欢迎您，<strong><s:property value="#session.ename"/></strong>
                <a href="changepassword.jsp">[修改密码]</a>||
                <a href="Logout.action">[退出]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notifyAction.action">最新通知</a></li>
                        <li class="sidebar-menuitem"><a href="myAction.action?ename=<s:property value="#session.ename"/>">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetingAction.action?ename=<s:property value="#session.ename"/>">我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="departAction.action">部门管理</a></li>
                        
                        <li class="sidebar-menuitem"><a href="RegisterAction.action">员工注册</a></li>
                        
                        <li class="sidebar-menuitem"><a href="approveAction.action">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="searchEmpAction.action?prove=show">搜索员工</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="/MeetingSystem/showAllRoom">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="/MeetingSystem/GoBookMeet">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="SearchMeet?prove=show">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的会议
                </div>
                <table class="listtable">
                    <caption>我将参加的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="meetlist" var="meet">
                    <tr>
                        <td><s:property value="#meet.mname"/></td>
                        <td><s:property value="#meet.room.rname"/></td>
                        <td><s:date name="#meet.mstarttime" format="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><s:date name="#meet.mendtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><s:date name="#meet.appointtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><s:property value="#meet.emp.ename"/></td>
                        <td>
                            <a class="clickbutton" href="DAction.action?mname=<s:property value="#meet.mname"/>">查看详情</a>
                        </td>
                    </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>