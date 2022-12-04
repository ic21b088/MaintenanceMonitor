
function executeQuery() {
  $.ajax({
    url: 'message/deliver',
    success: function(data) {
    console.log(data)
      if(data.color==="white"){
       $("#p1").html(data.statusMessage);
        $("#p2").html(data.lastUpdated);
         $('body').css('background', '#FFFFFF');
      }
    else if(data.color==="green"){
     $('body').css('background', '#90EE90');
//     alert(data.lastUpdated)
//     $("#p1").html(data.lastUpdated);
             $("#p1").html(data.statusMessage);
             $("#p2").html(data.lastUpdated);
//       $('<p></p>').attr('id',"").html();
//     document.getElementById("p1").innerHTML = data.statusMessage
//     document.getElementById("p2").innerHTML = data.statusMessage
     }else{
           $('body').css('background', '#FFCCCB');
           $("#p1").html(data.statusMessage);
           $("#p2").html(data.lastUpdated);
     }
      // do something with the return value here if you like
    },
     error: function(data){
      $('body').css('background', '#FFFFFF');
       }
  });
  setTimeout(executeQuery, 6000);
}

$(document).ready(function() {
  setTimeout(executeQuery, 1000);
});