// window.addEventListener('DOMContentLoaded', function() {
// document.querySelector('.header').style.display = 'none';
// })

// $(function(){

// }) 은 위의 DOMcontent와 같이 스크립트의 위치가 위쪽에 존재하더라도 기능이 적용된다.




// 밑의 $는 document.querySelector 축약형 , hide는 style.display = 'none'을 축약한 것

// $('.header').hide().show();

$(function(){
    $('.main_slider').slick({
        arrows:false,
        autoplay: true,
        autoplaySpeed: 1000,
        vertical: true,
        dots: true,
    });

$('.mopen').on('click', function(){
    $('.gnb').toggleClass('on')
})


// 반응형 t06.에서 메뉴 버튼 모양 바꾸기//

//  $('.mopen').on('click', function(){
//     $('.mopen span').toggleClass('on');
//     this.classList.toggleClass('on'); })
//     


$('.mopen').on('click', function(){
    $('.mopen').toggleClass('on')
})

})