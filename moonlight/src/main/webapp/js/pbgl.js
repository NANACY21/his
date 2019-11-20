$(function(){
	$.ajax({
		type:"get",
		url:"user/depts.action",
		success:function(resp){
			var html="";
			$.each(resp,function(k,v){
				html+='<option value="'+v.id+'">'+v.deptname+'</option>';
			});
			$('#depts').append(html);
		},
		error:function(){
			alert("数据加载失败");
		}
	});
	$.ajax({
		type:"get",
		url:"registlevel/levelnames.action",
		success:function(resp){
			var html="";
			$.each(resp,function(k,v){
				html+='<option value="'+v.id+'">'+v.registname+'</option>';
			});
			$('#levels').append(html);
		},
		error:function(){
			alert("数据加载失败");
		}
	});
	
	$.ajax({
		type:"get",
		url:"user/getlevel.action",
		success:function(resp){
			var html="";
			$.each(resp,function(k,v){
				html+='<option value="'+v.id+'">'+v.registname+'</option>';
			});
			$('#level').append(html);
		},
		error:function(){
			alert("加载数据失败");
		}
	});
	
	
	
	$('#search').click(function(){
		var deptid = $('select[id="dept"] option:selected').val();
		var levelid= $('select[id="level"] option:selected').val();
		$.ajax({
			type:"post",
			url:"user/getdoctors.action",
			data:"dept.id="+deptid+"&registLevel.id="+levelid,
			/*contentType:"application/json",
			data:{"dept.id":deptid,"registLevel.id":levelid},*/
			success:function(resp){
		
				var html="";
				$.each(resp,function(k,v){
					html+='<tr><td><input type="checkbox" name="uid" value="'+v.id+'"></td>';
					html+='<td>'+v.username+'</td>';
					html+='<td><input type="checkbox" name="mondayam"/></td><td><input type="checkbox" name="mondaypm"/></td>';
					html+='<td><input type="checkbox" name="tuesdayam"/></td><td><input type="checkbox" name="tuesdaypm"/></td>';
					html+='<td><input type="checkbox" name="wendsdayam"/></td><td><input type="checkbox" name="wendsdaypm"/></td>';
					html+='<td><input type="checkbox" name="thursdayam"/></td><td><input type="checkbox" name="thursdaypm"/></td>';
					html+='<td><input type="checkbox" name="fridayam"/></td><td><input type="checkbox" name="fridaypm"/></td>';
					html+='<td><input type="checkbox" name="saturdayam"/></td><td><input type="checkbox" name="saturdaypm"/></td>';
					html+='<td><input type="checkbox" name="sundayam"/></td><td><input type="checkbox" name="sundaypm"/></td>';
					html+='</tr>';
				});
				$('tr').next().remove();
				$('table').append(html);
			},
			error:function(){
				alert("查询失败");
			}
		});
	});

	$('#find').click(function() {
		var dept = $('#depts').val();
		var level = $('#levels').val();
		$.ajax({
			type : "post",
			url : "user/getdoctors.action",
			data:"dept.id="+dept+"&level.id="+level,
			success : function(resp) {
				var html="";
				$.each(resp, function(k, v) {
					html+="<tr><td><input type='checkbox' class='uid' name='flag' value='"+v.id+"'/></td>";
					html+="<td>"+v.username+"</td>";
					html+="<td><input type='checkbox' name='monam'/></td><td><input type='checkbox' name='monpm'/></td>";
					html+="<td><input type='checkbox' name='tueam'/></td><td><input type='checkbox' name='tuepm'/></td>";
					html+="<td><input type='checkbox' name='wedam'/></td><td><input type='checkbox' name='wedpm'/></td>";
					html+="<td><input type='checkbox' name='thuam'/></td><td><input type='checkbox' name='thupm'/></td>";
					html+="<td><input type='checkbox' name='friam'/></td><td><input type='checkbox' name='fripm'/></td>";
					html+="<td><input type='checkbox' name='satam'/></td><td><input type='checkbox' name='satpm'/></td>";
					html+="<td><input type='checkbox' name='sunam'/></td><td><input type='checkbox' name='sunpm'/></td></tr>";
				});
				$('tr').next().remove();
				$('#pbs').append(html);
			},
			error : function() {
				alert("数据加载失败");
			}
		});

	});

	$('input[name="save"]').click(function(){
		var deptid=$('select[name="dname"] option:selected').val();
		var rulename = $('input[name="rulename"]').val();
		var $uids = $('.uid');
		var data = "";//封装传递的规则字符串  +  部门id  + 医生id
		var num =1;
		$.each($uids,function(k,v){
			var $this = $(v);
			if($this.is(':checked')){//判断是否被选中
				var $childs = $this.parentsUntil('tbody').find($("input[type='checkbox']"));
				var cks ="";//规则字符串
				$.each($childs,function(k1,v1){
					var $t  =$(v1);
					if(!$t.is($this)){//不是当前uid对象
						if($t.is(':checked')){
							cks+="1";
						}else{
							cks+="0";
						}
					}
				});
				//data   cks
				if(num==1){
					data +="uid="+$this.val()+"&cks="+cks;
				}else{
					data +="&uid="+$this.val()+"&cks="+cks;
				}
				num++;
			}
		});
		data +="&deptid="+deptid+"&rulename="+rulename;
		alert(data);

		$.ajax({
			type:"post",
			url:"rule/addrules.action",
			data:data,
			success:function(resp){
				if("ok"==resp){
					alert("添加规则成功");
				}else{
					alert("添加规则失败");
				}
			},
			error:function(){
				alert("加载数据失败");
			}
		});

	});
});