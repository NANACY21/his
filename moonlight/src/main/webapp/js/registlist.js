$(function(){
			//获得到未诊患者名单
			$.ajax({
				type:"post",
				data:"userid="+sessionStorage.getItem("id")+"&visitstate="+2,
				url:"record/listregist.action",
				success:function(resp){
					var html="";
					$.each(resp,function(k,v){
						
						html +='<tr><td>'+v.casenumber+'</td><td>'+v.realname+'</td><td>'+v.age+'</td></tr>';
						
					});
					$('#Register').append(html);
				},
				error:function(){
					alert("失败");
				}
			});
			//获取一就诊列表
			$.ajax({
				type:"post",
				data:"userid="+sessionStorage.getItem("id")+"&visitstate="+3,
				url:"record/listregist.action",
				success:function(resp){
					var html="";
					$.each(resp,function(k,v){
						
						html +='<tr><td>'+v.casenumber+'</td><td>'+v.realname+'</td><td>'+v.age+'</td></tr>';
						
					});
					$('#Register1').append(html);
				},
				error:function(){
					alert("失败");
				}
			});
		});