$(function(){
	$('input[name="ban"]').click(function(){
		 	/*text = $("input:checkbox[name='cks']:checked").map(function(index,elem) {
	            return $(elem).val();
	        }).get().join(',');*/
		
	        var nums = $("input[name='cks']:checked").length;
	        alert(nums);
	        if(nums==0){
				alert("请选择要删除的选项");
				return;
	        }
	        if(confirm("确定要删除所选项？")){
	        	 var checkedList = new Array();
	             $("input[name='cks']:checked").each(function(){
	                 checkedList.push($(this).val());
	             });
	             //alert(checkedList);
	        	$.ajax({
	        		type:"get",
	        		url:"department/deletes.action",
	        		async:true,
	        		data:"id="+checkedList,//104,114
	        		success:function(resp){
	        			if(resp==1){
	        				alert("成功");
	        				$("input[name='cks']:checked").parentsUntil('tbody').remove();
	        			}
	        		},
	        		error:function(){
	        			alert("失败");
	        		}
	        	});
	        	
	        }
	});
});