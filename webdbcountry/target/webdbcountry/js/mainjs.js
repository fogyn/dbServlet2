// var myVar = setInterval(myTimer, 1000);
//
// function myTimer() {
//     var d = new Date();
//     //document.getElementById("data3").innerHTML = d.toLocaleTimeString();
// }
//
// function newsClick(param){
//     //var t = par;
//     //var el = document.getElementByClassName(id);
//     //var elements = document.getElementsByClassName(name);
//     //console.log(t);
//     var el = document.getElementById(param);
//
//     //var el = elements[0];
//     if (el.style.display == "block") {
//         el.style.display = "none";
//
//     } else {
//         el.style.display = "block";
//
//     }
//
// }

function makeAjaxCall(del2){
    var data = ""; // if you want to pass data as request param then assign here
    var mas = [];
    $('input[name=ch]').each(function(){
        if($(this).prop('checked')){
            mas.push($(this).val());
        }
    });

    var json1 = JSON.stringify(mas);
    $.ajax({

        url: 'deleteSomeCountry',
        type: 'POST',
        cache: false,
        data: "term=" + mas,
        //data: mas,

        success: function (data) {

            del2 = data.delete;
            $('#delСountryCityajax').append(data.delete);
    },
    error: function (data, status, er) {
        //alert(er);
    }

    });
}


function makeDeleteSomeCity(){
    var data = ""; // if you want to pass data as request param then assign here
    var mas = [];
    $('input[name=chcity]').each(function(){
        if($(this).prop('checked')){
            mas.push($(this).val());
        }
    });

    var json1 = JSON.stringify(mas);
    $.ajax({

        url: 'deleteSomeCity',
        type: 'POST',
        cache: false,
        data: "term=" + mas,
        //data: mas,

        success: function (data) {

            del2 = data.delete;
            $('#delСountryCityajax').append(data.delete);
        },
        error: function (data, status, er) {

        }

    });
}
// $(document).ready(function(){
//     $("#idsub").click(function(){
//         var mas = [];
//         $('input[name=ch]').each(function(){
//             if($(this).prop('checked')){
//                 mas.push($(this).val());
//             }
//         });
//         //alert(mas);
//         var json1 = JSON.stringify(mas);
//         dt = {"login":"myLogin", "password":"myPassword"};
//         //alert("ок");
//         $ajax({
//                 // url: "deleteSomeCountry",
//             // type: "post",
//             // contentType: "application/json",
//             // data: {ch: mas},
//             // success: function(results){
//             //     alert(results);
//             //
//             // }
//
//             // type: "POST",//Метод передачи
//             // dataType: "text",
//             // data: dt,//Передаваемые данные в JSON - формате
//             // url: 'deleteSomeCountry',//Название сервлета
//             url:"ajax",
//             type:"get",
//             dataType:'json',
//             data: {json:json1},
//             success: function(serverData){
//                 //alert(serverData.serverInfo);
//             },
//             error: function(e){
//                 alert("Ошибка запроса");
//             }
//         });
//     });
// });
//


