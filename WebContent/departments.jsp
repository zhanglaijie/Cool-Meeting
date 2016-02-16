<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.hs-cn.com/jquery/jquery-1.7.1.min.js"></script>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
  
        <script>
                $(document).ready(function(){ 
    	 $(".clickbutton").click(function(){
    		 if ($(this).val()=="编辑")
    			 {
		        	 var parents =  $(this).parent().parent().parent();
		        	 var par1 = parents.children().eq(0);
		        	 var par11 = par1.text();
		        	 var par2 = par1.next();
		        	 var par22 = par2.text();
		        	 par2.text("");
		        	 var htm = "<input id='ww' type='text'/>";
		        	 par2.append(htm);
		        	 $("#ww").val(par22);
		        	 $("#ww").focus();       	 
		        	 $("#ww").blur(function(){		
		        		 var val = $(this).val();
		        		 par2.empty();
		        		 par2.text(val);
		        		 var par22 = par2.text();
		        		 
		        		 $.post("updateDepartAction.action",{did:par11,dname:par22},
		        				 function(data,status){
		        			 //alert(par11+par22);
		        		 });
		        	 });
		        	 return false; }});});
        </script>
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
                    人员管理 > 部门管理
                </div>
                <form action="addDeptAction.action" method="post">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" name ="dname" maxlength="20"/>
                        
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                  </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    
                     <s:iterator value="list" var="dept">	
                     <tr >			
                        <td ><s:property value="#dept.did" /></td>
                        <td ><s:property value="#dept.dname"/></td>
                        <td >
                        <form action="deleteDepartAction.action?did=<s:property value="#dept.did"/> " method="post">
                            <input type="submit"  class="clickbutton" value="编辑"/>
                            <input type="submit"  class="clickbutton" value="删除"/>
                            </form>
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