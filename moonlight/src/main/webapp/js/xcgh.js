$(function(){
	if(sessionStorage.getItem("username")!=null){
		$('#uname').html(sessionStorage.getItem("username"));
	}else{
		alert("请先登录");
		location.href="login.html";
	}
	
	$.ajax({
		type:"get",
		url:"invoice/getInvoiceId.action",
		success:function(resp){
			$('input[name="fph"]').val(resp);
		},
		error:function(){
			alert("加载数据失败");
		}
	});
	$.ajax({
		type:"get",
		url:"register/getRegisterCaseNum.action",
		success:function(resp){
			$('input[name="blh"]').val(resp);
		},
		error:function(){
			alert("加载数据失败");
		}
	});
	
		/*$.ajax({
			type:"get",
			url:"department/getdeptsnames.action",
			success:function(resp){
				$.each(resp,function(k,v){
					var html="";
					html+="<option value='"+v.id+"'>"+v.deptname+"</option>";
					$('#ghks').append(html);
				})
			},
			error:function(){
				alert("加载数据失败")
			}
		});*/
		
		
		$.ajax({
			type:"get",
			url:"settlecategory/getSettleName.action",
			success:function(resp){
				$.each(resp,function(k,v){
					var html="";
					html+="<option value='"+v.id+"'>"+v.settlename+"</option>";
					$('#jslb').append(html);
				})
			},
			error:function(){
				alert("加载数据失败")
			}
		});
		
		$.ajax({
			type:"get",
			url:"contantsitem/findpaytype.action",
			success:function(resp){
				$.each(resp,function(k,v){
					var html="";
					html+="<option value='"+v.id+"'>"+v.constantname+"</option>";
					$('#skfs').append(html);
				})
			},
			error:function(){
				alert("加载数据失败")
			}
		});
		
		/*$.ajax({
			type:"get",
			url:"user/getRealName.action",
			success:function(resp){
				$.each(resp,function(k,v){
					var html="";
					html+="<option value='"+v.id+"'>"+v.realname+"</option>";
					$('#kzys').append(html);
				})
			},
			error:function(){
				alert("加载数据失败")
			}
		});*/
		
		$.ajax({
			type:"get",
			url:"registlevel/levelnames.action",
			success:function(resp){
				$.each(resp,function(k,v){
					var html="";
					html+="<option value='"+v.id+"'>"+v.registname+"</option>";
					$('#hb').append(html);
				})
			},
			error:function(){
				alert("加载数据失败");
			}
		});
		
		$('input[name="birthday"]').change(function(){
			var birthday = $('input[name=birthday]').val();
			$.ajax({
				type:"post",
				url:"register/getAge.action?birth="+birthday,
				success:function(resp){
					$('input[name="age"]').val(resp);
				},
				error:function(){
					alert("加载数据失败");
				}
			});
		});
		
		$('input[name="kzrq"]').change(function(){
			$('#wb option').remove();
			var html="";
			html+="<option value=''>午别</option><option value='上午'>上午</option><option value='下午'>下午</option>";
			$('#wb').append(html);
		});
		
		$('#wb').change(function(){
			$('#ghks option').remove();
			var days = $('input[name="kzrq"]').val();
			var noons = $('#wb').val();
			$.ajax({
				type:"get",
				url:"scheduling/getDeptNames.action",
				data:"day="+days+"&noon="+noons,
				success:function(resp){
					$.each(resp,function(k,v){
						var html="";
						html+="<option value='"+v.id+"'>"+v.deptname+"</option>";
						$('#ghks').append(html);
					})
				},
				error:function(){
					alert("加载数据失败");
				}
			});
		});
		
		/*var myDate = new Date;
	    var year = myDate.getFullYear();
	    var mon = myDate.getMonth() + 1; 
	    var dat = myDate.getDate();
	    //alert(year+"/"+mon+"/"+dat);
	    $('#ddyy').val(year+"-"+mon+"-"+date);*/
		
		$('#hb').change(function(){
			var kzrq = $('input[name="kzrq"]').val();
			var noon = $('#wb').val();
			var ghks = $('#ghks').val();
			var hb = $('#hb').val();
			//alert(kzrq+"-"+noon+"-"+ghks+"-"+hb);
			$.ajax({
				type:"post",
				url:"register/getUsers.action",
				data:"visitdate="+kzrq+"&noon="+noon+"&dept.id="+ghks+"&reglevel.id="+hb,
				success:function(resp){
					$('#kzys option').remove();
					$.each(resp,function(k,v){
					var html="";
					html+="<option value='"+v.id+"'>"+v.realname+"</option>";
					$('#kzys').append(html);
					});
				},
				error:function(){
					alert("加载数据失败");
				}
			});
		});
		$('#guahao').click(function(){
		var blh = $('input[name="blh"]').val();
		var xm  = $('input[name="xm"]').val();
		var sex= $('#sex').val();
		var sfzh = $('input[name="sfzh"]').val();
		var birthday = $('input[name="birthday"]').val();
		var age = $('input[name="age"]').val();
		var nllx = $('#nllx').val();
		var jtzz = $('input[name="jtzz"]').val();
		var kzrq = $('input[name="kzrq"]').val();
		var wb = $('#wb').val();
		var ghks = $('#ghks').val();
		var kzys = $('#kzys').val();
		var hb = $('#hb').val();
		var jslb = $('#jslb').val();
		
			/*alert(blh);
			alert(xm);
			alert(sex);
			alert(sfzh);
			alert(birthday);
			alert(age);
			alert(nllx);
			alert(jtzz);
			alert(kzrq);
			alert(wb);
			alert(ghks);
			alert(kzys);
			alert(hb);
			alert(jslb);
			alert(typeof birthday+"-"+typeof kzrq);*/
		$.ajax({
			type:"post",
			url:"register/saveRegister.action",
			data:"casenumber="+blh+"&realname="+xm+"&gender="+sex+"&idnumber="+sfzh+"&birthdate="+birthday+"&age="+age+"&agetype="+nllx+"&homeaddress="+jtzz+"&visitdate="+kzrq+"&noon="+wb+"&dept.id="+ghks+"&userid="+kzys+"&reglevel.id="+hb+"&settleid="+jslb,
			success:function(resp){
				alert("挂号成功！");
				window.location.reload();
			},
			error:function(){
				alert("加载数据失败！");
			}
		});
		});
		
			
});

	function logout(){
		$.ajax({
			type:"get",
			url:"user/logout.action",
			success:function(resp){
				sessionStorage.clear();
				alert("退出登录");
				location.href="login.html";
			},
			error:function(){
				alert("加载数据失败");
			}
		});
	}