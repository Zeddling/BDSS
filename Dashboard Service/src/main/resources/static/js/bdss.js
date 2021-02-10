$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

    $('#form-submit').on('click', function() {
        var pName = $('#pName').val();
        var pNum = $('#pNum').val();
        var pDate = $('#dDate').val();
        var file_upload = $('file_upload')
        var comments = $('#comments').val();
        var reader = new FileReader();
        reader.onload = function(file_upload) {
            $('#preview').remove();
            $('#preview').after('<img src="'+file_upload.target.result+'" alt="file.jpeg" class="img-thumbnail"');
            // read the image file as a data URL.
            reader.readAsDataURL(e.target.files[0].files);
        };
    });

	// Code By Webdevtrick ( https://webdevtrick.com )
	function readFile(input) {
	  if (input.files && input.files[0]) {
	    var reader = new FileReader();

	    reader.onload = function(e) {
	      var htmlPreview =
		'<img width="200" src="' + e.target.result + '" />' +
		'<p>' + input.files[0].name + '</p>';
	      var wrapperZone = $(input).parent();
	      var previewZone = $(input).parent().parent().find('.preview-zone');
	      var boxZone = $(input).parent().parent().find('.preview-zone').find('.box').find('.box-body');

	      wrapperZone.removeClass('dragover');
	      previewZone.removeClass('hidden');
	      boxZone.empty();
	      boxZone.append(htmlPreview);
	    };

	    reader.readAsDataURL(input.files[0]);
	  }
	}

	function reset(e) {
	  e.wrap('<form>').closest('form').get(0).reset();
	  e.unwrap();
	}

	$(".dropzone").change(function() {
	  readFile(this);
	});

	$('.dropzone-wrapper').on('dragover', function(e) {
	  e.preventDefault();
	  e.stopPropagation();
	  $(this).addClass('dragover');
	});

	$('.dropzone-wrapper').on('dragleave', function(e) {
	  e.preventDefault();
	  e.stopPropagation();
	  $(this).removeClass('dragover');
	});

	$('.remove-preview').on('click', function() {
	  var boxZone = $(this).parents('.preview-zone').find('.box-body');
	  var previewZone = $(this).parents('.preview-zone');
	  var dropzone = $(this).parents('.form-group').find('.dropzone');
	  boxZone.empty();
	  previewZone.addClass('hidden');
	  reset(dropzone);
	});

});
