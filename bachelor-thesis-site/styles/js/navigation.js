/*!
 * Adapted from Bootstrap docs JavaScript
 */


!function ($) {

  $(function () {
      
		orderTheLeftNavigations();

    function orderTheLeftNavigations(){
      var current = location.pathname;
      if (current !== "/"){
        $('#frontpagenav li a').each(function(){
          var $this = $(this);

          // console.log($this.attr('href'))

          if (current.includes($this.attr('href'))){
            // console.log($this.attr('href'))
            $this.parent().addClass("active");
          }

          // if the current path is like this link, make it active
          // if($this.attr('href').indexOf(current) !== -1){
          //   $this.parent().addClass("active");
          // }

        })


      }

	    $('#navigation .sidenav').html($("#markdown-toc").html());
	    $('#navigation .sidenav ul').addClass("nav");
	    $("#markdown-toc").remove();

      $(".docs-content table").addClass("table table-hover");
  	}

  })

}(jQuery)
