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

});