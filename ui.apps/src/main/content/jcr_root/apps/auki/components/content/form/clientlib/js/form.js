$(document).ready(function() {
			$("#submit").click(function(event) {

                event.preventDefault();
				$.ajax({
					type: "POST",
					url: "/bin/test2",
                    data: $('form').serialize(),
                    processData: false,
					success: function(resp) {
                        alert("Name: " + resp.name + " Description: " + resp.desc);

            	}
				});
			});
		});