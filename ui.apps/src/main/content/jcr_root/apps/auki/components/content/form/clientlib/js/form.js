$(document).ready(function() {
			$("#submit").click(function() {
				$.ajax({
					type: "POST",
					url: "/bin/test2",
                    data: $('form').serialize(),
					success: function(resp) {
                        alert("Name: " + resp.name + "Description: " + resp.desc);
                        
            	}
				});
			});
		});