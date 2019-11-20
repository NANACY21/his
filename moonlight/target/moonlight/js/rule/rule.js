$(function(){
	//封装Department列表框 
	$.ajax({
		type:"get",
		url:"http://localhost:8080/his/department/searchdept.action",
		data:"depttype=1",
		success:function(resp){
			var html="";
			$.each(resp, function(k,v) {
				html+="<option value='"+v.id+"'>"+v.deptname+"</option>";
			});
			$('#dept').html(html);
		},
		error:function(){
			alert("获取数据失败");
		}
	});

	$.ajax({
		type:"get",
		url:"http://localhost:8080/his/registlevel/getalllevels.action",
		success:function(resp){
			var html="";
			$.each(resp, function(k,v) {
				html+="<option value='"+v.id+"'>"+v.registname+"</option>";
			});
			$('#level').html(html);
		},
		error:function(){
			alert("获取数据失败");
		}
	});

	$('#search').click(function(){
		var deptid = $('#dept').val();
		var registlevelid =$('#level').val();
		$('input[type="hidden"]').val(deptid);
		$.ajax({
			type:"post",
			url:"http://localhost:8080/his/rule/userlist.action",
			data:"department.id="+deptid+"&registLevel.id="+registlevelid,
			success:function(resp){
				var html="";
				$.each(resp, function(k,v) {
					html+="<tr><td><input type='checkbox' name=\"id\" value='"+v.id+"'/></td>"+
						"<td>"+v.username+"</td>"+
						"<td><input type='checkbox' name='mondayam' value='1'/></td>"+
						"<td><input type='checkbox' name='mondaypm' value='1'/></td>"+
						"<td><input type='checkbox' name='tuesdayam' value='1'/></td>"+
						"<td><input type='checkbox' name='tuesdaypm' value='1'/></td>"+
						"<td><input type='checkbox' name='wednesdayam' value='1'/></td>"+
						"<td><input type='checkbox' name='wednesdaypm' value='1'/></td>"+
						"<td><input type='checkbox' name='thursdayam' value='1'/></td>"+
						"<td><input type='checkbox' name='thursdaypm' value='1'/></td>"+
						"<td><input type='checkbox' name='fridayam' value='1'/></td>"+
						"<td><input type='checkbox' name='fridaypm' value='1'/></td>"+
						"<td><input type='checkbox' name='saturdayam' value='1'/></td>"+
						"<td><input type='checkbox' name='saturdaypm' value='1'/></td>"+
						"<td><input type='checkbox' name='sundayam' value='1'/></td>"+
						"<td><input type='checkbox' name='sundaypm' value='1'/></td></tr>";
				});
				$('tbody').html(html);
			},
			error:function(){
				alert("加载数据失败");
			}
		});
	});


	$('#addrule').click(function(){
		var rulename = $('input[name="rulename"]').val();
		var departmentid =$('input[type="hidden"]').val();
		//判断是否有选中的医生
		var cks = $('input[name="id"]:checked');
		if(cks.length==0){
			alert("至少选中一个医生");
		}else{
			var message = "";
			$.each(cks, function() {
				var str="";
				var $this = $(this);//获取当前复选框
				var userid = $this.val();
				//获取当前行所有checkbox
				var cks = $this.parentsUntil('tr').siblings("td:has(input)").children();
				$.each(cks, function() {
					if($(this).prop("checked")==true){
						str+="1";
					}else{
						str+="0";
					}
				});

				message+=rulename+"-"+departmentid+"-"+userid+"-"+str;
				message +="@";

			});
			//alert(message);
			$.ajax({
				type:"get",
				url:"http://localhost:8080/his/rule/addrule.action",
				data:"message="+message,
				async:true,
				success:function(resp){
					alert(resp);
				},
				error:function(){
					alert("添加失败");
				}
			});
		}
	});
});
