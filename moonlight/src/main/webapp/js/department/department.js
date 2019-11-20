function gettype(depttype){
	if(depttype==1){
		return "临床科室";
	}else if(depttype==2){
		return "医技科室";
	}else if(depttype==3){
		return "财务科室";
	}else if(depttype==4){
		return "行政科室";
	}else if(depttype==5){
		return "其它";
	}else{
		return "未知错误";
	}
}
$(function(){
	$.ajax({
		url:"http://localhost:8080/his/department/getall.action",
		type:"get",
		success:function(resp){
			var html="";
			$.each(resp, function(k,v) {
				html+='<tr><td><input type="checkbox" name="id" value="'+v.id+'"></td>';
				html+='<td>'+v.deptcode+'</td><td>'+v.deptname+'</td><td>'+v.constantItem.constantname+'</td><td>'+gettype(v.depttype)+'</td>';
				html+='<td>编辑&nbsp;删除</td></tr>';
			});
			$('#deptlist').append(html);
		},
		error:function(){
			alert("加载数据失败，请刷新网页");
		}
	});
	$("#checkall").click(function(){
		var $cks = $('input[name="id"]');
		if($(this).prop("checked")==true){
			$cks.prop("checked",true);
		}else{
			$cks.prop("checked",false);
		}
	});
});