$(window).load(init);

//function init() {
    // Grab the tab links and content divs from the page
    var tabListItems = $('.cmp-tabs__tab');

    // loop through all tab li tags
    $('.cmp-tabs__tab').each(function(i, ele){
		// Assign click/focus events to the tab anchor/links
		var tabLink = $(this).find('li').on('click', showTab).on('focus', function () { $(this).blur(); });
		var tabBody = $($(tabLink).attr('href'));
		
		// highlight the first tab
        if (i == 0) $(tabLink).addClass('selected');
		
		// hide all the content divs but the first
		if (i != 0) $(tabBody).hide();
	});

	//auto-rotate every 3 seconds
    //setInterval(function () {
		var selectedTab = $('.cmp-tabs__tablist').find('li.cmp-tabs__tab--active');
		var index = $(selectedTab).index();
		
		if (index < $('.cmp-tabs__tablist').find('li').length - 1)
			index++;
        else
            index = 0;
		
		$('.cmp-tabs__tablist').find('li:eq('+index+') ').click();
    }, 3000);
}

//function showTab(e) {
	// prevent default anchor/link action
	e.preventDefault();

    var selectedId = $(this).attr('href');
	
	// remove 'on' class from all tab li tags
	$('.cmp-tabs__tablist').find('li').removeClass('.cmp-tabs__tab--active');
	
	// remove 'selected' class from all tab anchors/links
	$('.cmp-tabs__tablist').find('li.selected').removeClass('selected');
	
	// add 'on' class to selected tab li tag
	$(this).closest('li').addClass('.cmp-tabs__tab--active');
	
	// add selected class 
	$(this).addClass('selected');
	
	// hide all tab bodies
	$('div.tabContent').hide();
	
	// show selected tab body
	$(selectedId).show();
}