<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
    <!--<s:property value="#session.s"/> -->
 <html>
    <head>
    
    
    
    
        <script language="javascript" type="text/javascript"> 
        function myalet(){
          if ("${requestScope.result}"=="用户名不存在")
        	  {
        	  	alert("${requestScope.result}");
        	  	return true;
        	  }
          else if ("${requestScope.result}"=="密码错误")
    	  {
    	  	alert("${requestScope.result}");
    	  	return true;
    	  }
          return false;
        }
        </script>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
    <body onload="return myalet()">
        <div class="page-header">
            <div class="header-banner">
                <img src="images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                 欢迎您，<strong>请登录</strong>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                   <!--   <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notifyAction.action">最新通知</a></li>
                        <li class="sidebar-menuitem"><a href="myAction.action?ename=<s:property value="#session.ename"/>">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetingAction.action?ename=<s:property value="#session.ename"/>">我的会议</a></li>
                    </ul> -->
                </div>
                <div class="sidebar-menugroup">
                	 <!-- 
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="departAction.action">部门管理</></li>
                        
                        <li class="sidebar-menuitem"><a href="RegisterAction.action">员工注册</a></li>
                        
                        <li class="sidebar-menuitem"><a href="approveAction.action">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="searchEmpAction.action?prove=show">搜索员工</a></li>
                    </ul>
                    -->
                </div>
                <div class="sidebar-menugroup">
                	<!-- 
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="/MeetingSystem/showAllRoom">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="/MeetingSystem/GoBookMeet">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="SearchMeet?prove=show">搜索会议</a></li>
                    </ul>
                     -->
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    登录
                </div>
                <form action="Login" method="post">
                    <fieldset>
                        <legend>登录信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>账号名:</td>
                                <td>
                                    <input name="ename" type="text" placeholder="默认 :day2"/>
                                </td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td>
                                    <input name="epasswd" type="password" placeholder="默认:123456"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="submit" value="登录" class="clickbutton"/>
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>