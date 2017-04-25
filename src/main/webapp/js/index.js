/*
---------------------------
-Click on the Button Join !-
---------------------------
*/


var t = 0;

function join_1(){
    if(t === 0){
        document.querySelectorAll('.cont_letras > p')[0].style.left = '320px';
        document.querySelectorAll('.cont_letras > p')[1].style.left = '-320px';
        document.querySelectorAll('.cont_letras > p')[2].style.left = '200px';
        setTimeout(function(){
            document.querySelector('.cont_join').className = 'cont_join cont_join_form_act';
        },1000);
    t++;
    }
    else{
        t++;
        $.ajax({
            url:"/userLogin.action",
            type:"get",
            data:{userName:$("#userName").val(),
                    password:$("#password").val()},
            success:function(data){
                alert(data);
            }
        })
        document.querySelector('.cont_form_join').style.bottom = '-420px';
        setTimeout(function(){
	        document.querySelector('.cont_join').className = 'cont_join cont_join_form_act cont_join_finish';
        },500);

  }

}