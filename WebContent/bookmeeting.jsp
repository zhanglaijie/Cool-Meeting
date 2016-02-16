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
            #divfrom{
                float:left;
                width:150px;
            }
            #divto{
                float:left;
                width:150px;
            }
            #divoperator{
                float:left;
                width:50px;
                padding:60px 5px;
            }
            #divoperator input[type="button"]{
                margin:10px 0;
            }
            #selDepartments{
                display:block;
                width:100%;
            }
            #selEmployees{
                display:block;
                width:100%;
                height:200px;
            }
            #selSelectedEmployees{
                display:block;
                width:100%;
                height:225px;
            }
        </style>

	
       
    <script src="jquery.js" type="text/javascript"></script> 
        
        <script language="javascript" type="text/javascript"> 
        $(document).ready(function(){ 
            $('.yuding').click(function(){ 
            	var str="";
           		$("#selSelectedEmployees option").each(function ()
           		{
           	     		var val = $(this).val(); //获取单个valu
           	     		val += "#"
           	            str += val;
           	             
           	    });
           				
           		var mname = $("#mname").val();
           		var mnumber = $("#mnumber").val();
           		var startdate = $("#startdate").val();
           		var starttime= $("#starttime").val();
           		var enddate = $("#enddate").val();
           		var endtime= $("#endtime").val();
           		var rid = $("#rid").val();
           		var mremark = $("#mremark").val();
           		
           		$.post("AddMeet.action",{mname:mname,mnumber:mnumber,startdate:startdate,starttime:starttime,
           			enddate:enddate,endtime:endtime,rid:rid,mremark:mremark,memps:str},
       				 function(data,status){
       			 alert("添加成功");
       		 });
        }); 
        }); 
        </script>
       <%--
        $(document).ready(function(){ 
        $('#selDepartments').change(function(){ 
        var did = $(this).children('option:selected').val(); 

        alert(did);
        var dname = $(this).children('option:selected').text();
        alert(dname);
	
        var reJson;
			 $.ajax({
			  type:'POST',
			  url:"dofindemp。jsp",
			  data:{did:did},
			  dataType: 'json',
			  async:false, //为了简便，设置为同步操作
			  cache: false,
			  success:function(responseData){
			   reJson=responseData;
			  }
			  
			 });
			  
			  //var eid=reJson.eid;
			  //var ename=reJson.ename;
			  
       
        </script> --%>
        
        <script type="application/javascript">
            function employee(employeeid, employeename){
                this.employeeid = employeeid;
                this.employeename = employeename;
            }
            function department(departmentid, departmentname, employees){
                this.departmentid = departmentid;
                this.departmentname = departmentname;
                this.employees = employees;
            }
            var data = new Array(
                new department(1, "技术部", new Array(
                    new employee(1001, "a00"), new employee(1002, "a01"), new employee(1003, "a02"), new employee(1004, "a03"))),
                new department(2, "销售部", new Array(
                    new employee(2001, "b00"), new employee(2002, "b01"), new employee(2003, "b02"), new employee(2004, "b03"))),
                new department(3, "市场部", new Array(
                    new employee(3001, "c00"), new employee(3002, "c01"), new employee(3003, "c02"), new employee(3004, "c03"))),
                new department(4, "行政部", new Array(
                    new employee(4001, "d00"), new employee(4002, "d01"), new employee(4003, "d02"), new employee(4004, "d03"))));
            
            var selDepartments;
            var selEmployees;
            var selSelectedEmployees;
            
            function body_load(){
                selDepartments = document.getElementById("selDepartments");
                selEmployees = document.getElementById("selEmployees");
                selSelectedEmployees = document.getElementById("selSelectedEmployees");
                
                for(var i=0;i<data.length;i++){
                    var dep = document.createElement("option");
                    dep.value = data[i].departmentid;
                    dep.text = data[i].departmentname;
                    selDepartments.appendChild(dep);
                }
                
                fillEmployees();
            }
            
            function fillEmployees(){
                clearList(selEmployees);
                var departmentid = selDepartments.options[selDepartments.selectedIndex].value;
                var employees;
                for(var i=0;i<data.length;i++){
                    if (departmentid == data[i].departmentid){
                        employees = data[i].employees;
                        break;
                    }
                }
                for(i=0;i<employees.length;i++){
                    var emp = document.createElement("option");
                    emp.value = employees[i].employeeid;
                    emp.text = employees[i].employeename;
                    selEmployees.appendChild(emp);
                }
            }
            
            function clearList(list){
                while(list.childElementCount > 0){
                    list.removeChild(list.lastChild);
                }
            }
            
            function selectEmployees(){
                for(var i=0;i<selEmployees.options.length;i++){
                    if (selEmployees.options[i].selected){
                        addEmployee(selEmployees.options[i]);
                        selEmployees.options[i].selected = false;
                    }
                }
            }
            
            function deSelectEmployees(){
                var elementsToRemoved = new Array();
                var options = selSelectedEmployees.options;
                for(var i=0;i<options.length;i++){
                    if (options[i].selected){
                        elementsToRemoved.push(options[i]);
                    }
                }
                for(i=0;i<elementsToRemoved.length;i++){
                    selSelectedEmployees.removeChild(elementsToRemoved[i]);
                }
            }
            
            function addEmployee(optEmployee){
                var options = selSelectedEmployees.options;
                var i = 0;
                var insertIndex = -1;
                while(i < options.length){
                    if (optEmployee.value == options[i].value){
                        return;
                    } else if (optEmployee.value < options[i].value) {
                        insertIndex = i;
                        break;
                    }
                    i++;
                }
                
                
                var opt = document.createElement("option");
                opt.value = optEmployee.value;
                opt.text = optEmployee.text;
                
                if (insertIndex == -1){
                    selSelectedEmployees.appendChild(opt);
                } else {
                    selSelectedEmployees.insertBefore(opt, options[insertIndex]);
                }
            }            
        </script>

       

    </head>
    <body onload="body_load()">
    		
   		    <s:iterator value="deptlist" var="dept">
      		<s:property value="#dept.did"/>
			<s:property value="#dept.dname"/>
 			</s:iterator>
			<s:debug></s:debug>
    
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
                    会议预定 > 预定会议
                </div>
                <form action="AddMeet.action" method="post">
                    <fieldset>
                        <legend>会议信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input type="text" id="mname" name="mname" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>
                                    <input type="text" id="mnumber" name="mnumber"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>
                                    <input type="date" id="startdate" name="startdate"/>
                                    <input type="time" id="starttime" name="starttime"/>
                                </td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>
                                    <input type="date" id="enddate" name="enddate" />
                                    <input type="time" id="endtime" name="endtime"/>
                                </td>
                            </tr>
							<tr>
                                <td>会议室名称：</td>
                                <td>
                                    <select id="rid">   
                                    
                                    	<s:iterator value="roomlist" var="room">
                                     	<option value="<s:property value="#room.rid"/>">
                                     	<s:property value="#room.rname"/></option>
                                     	</s:iterator> 
                                     </select>
                                </td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <textarea id="mremark" name="mremark" rows="5" ></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>选择参会人员：</td>
                                <td>
                                    <div id="divfrom">
                                        <%--  <select id="selDepartments" >
                                         <s:iterator value="deptlist" var="dept">
                                         <option value="<s:property value="#dept.did"/>">
                                         <s:property value="#dept.dname"/></option>
 										 </s:iterator>
                                        </select>  --%>
                                        
                                        <select id="selEmployees" multiple="true">
                                        <s:iterator value="emplist" var="empls">
                                        	<option value="<s:property value="#empls.eid"/>">
                                        		<s:property value="#empls.ename"/>
                                        	</option>
                                        </s:iterator>
                                        
                                        </select>
                                    </div>
                                    <div id="divoperator">
                                        <input type="button" class="clickbutton" value="&gt;" onclick="selectEmployees()"/>
                                        <input type="button" class="clickbutton" value="&lt;" onclick="deSelectEmployees()"/>
                                    </div>
                                    <div id="divto">
                                        <select id="selSelectedEmployees" multiple="true" name="memps">
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" class="yuding" value="预定会议"/>
                                    <input type="button" class="clickbutton" value="重置"/>
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