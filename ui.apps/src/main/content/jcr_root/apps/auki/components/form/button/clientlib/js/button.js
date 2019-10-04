$(document).ready(function() {
			$("button").click(function() {
				$.ajax({
					type: "GET",
					url: "/bin/test.json?q=cool",
					success: function(cool) {
             	 alert(cool.test);
            	}
				});
			});
		});