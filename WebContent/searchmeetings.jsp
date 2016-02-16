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
                    会议预定 > 搜索会议
                </div>
                 <form action="SearchMeet?prove=search" method="post">
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="mname" name="mname" maxlength="20"/>
                                </td>
                                <td>会议室名称：</td>
                                <td>
                                    <input type="text" id="rname" name="rname" maxlength="20"/>
                                </td>
                                <td>预定者姓名：</td>
                                <td>
                                    <input type="text" id="names" name="names" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预定日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="date" id="appointstart" name="appointstart" placeholder="例如：2013-10-20"/>
                                    到&nbsp;<input type="date" id="appointend" name="appointend" placeholder="例如：2013-10-22"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议日期：</td>
                                <td colspan="5">
                                    从&nbsp;<input type="date" id="start" name="start" placeholder="例如：2013-10-20"/>
                                    到&nbsp;<input type="date" id="end" name="end" placeholder="例如：2013-10-22"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" name="first" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number"><s:property value="total"/></span>条结果，
                            分成<span class="info-number"><s:property value="page"/></span>页显示，
                            当前第<span class="info-number"><s:property value="current"/></span>页
                        </div>
                        <div class="header-nav">
                        
                          <form action="NextMeetAction.action" method="post">
                            <input type="submit" name = next class="clickbutton" value="首页"/>
                            <input type="submit" name = next class="clickbutton" value="上页"/>
                            <input type="submit" name = next class="clickbutton" value="下页"/>
                            <input type="submit" name = next class="clickbutton" value="末页"/>
                        	    跳到第 <input type="text" id="pagenum" name = pagetemp class="nav-number"/>页
                            <input type="submit" name = next class="clickbutton" value="跳转"/>
                            </form>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                	
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
						<td><s:property value="#meet.mname" /></td>
						<td><s:property value="#meet.room.rname" /></td>
						<td><s:date name="#meet.mstarttime" format="yyyy-MM-dd HH:mm:ss"/></td>
						<td><s:date name="#meet.mendtime" format="yyyy-MM-dd HH:mm:ss"/></td>
						<td><s:date name="#meet.appointtime" format="yyyy-MM-dd HH:mm:ss"/></td>
						<td><s:property value="#meet.emp.names" /></td>
						<td>
                            <a class="clickbutton" href="meetingdetails?mname=<s:property value="#meet.mname" />">查看详情</a>
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