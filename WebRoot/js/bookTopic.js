$(function() {
	$('#topicId').select2({
		placeholder : "Select Topics"
	});
	getTopic();
});


function getTopic() {
	var url = "listTopics.action";
	$.ajax({
		type : 'POST',
		url : url,
		success : function(data) {
			var scSelect = document.getElementById("topicId");
			scSelect.options.length = 0;
			if (data.length > 0 && data.indexOf(',') > -1) {
				var scs = data.split(",");// a_b,c_d
				for (var i = 0; i < scs.length; i++) {
					var inner = scs[i].split("_");
					var varItem = new Option(inner[1], inner[0]);
					scSelect.options.add(varItem);
				}
			}
		}
	});
}