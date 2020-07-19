$(document).ready(function(){

    $("#mySearchInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#mySearchTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });



    $("#myInput").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });



    $("#myInputlist").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myList li").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

    $("#myInputAnything").on("keyup", function() {
        var value = $(this).val().toLowerCase();
        $("#myDIVAnything *").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });


});