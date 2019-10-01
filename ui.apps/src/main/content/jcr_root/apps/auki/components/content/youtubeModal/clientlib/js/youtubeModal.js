    var $videoSrc;  
    $('.videomodal__btn').click(function() {
        console.log("here");
        $videoSrc = $(this).attr( "src" );
        console.log($videoSrc);
    });
    

    // when the modal is opened autoplay it  
    $('#exampleModal').on('shown.bs.modal', function (e) {
        
    // set the video src to autoplay and not to show related video. Youtube related video is like a box of chocolates... you never know what you're gonna get
    $("#video").attr('src',$videoSrc + "?autoplay=1" ); 
    console.log($("#video").attr('src'));
    })
      
    
    
    // stop playing the youtube video when I close the modal
    $('#exampleModal').on('hide.bs.modal', function (e) {
        // a poor man's stop video
        // $videoSrc=null;
        $("#video").attr('src',$videoSrc); 
    }) 