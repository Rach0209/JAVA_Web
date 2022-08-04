$(function(){
    ////////////////////////////////////////

    $('.top_banner i').on('click', function(){
        $('.top_banner').slideUp(1500);
    })


    //순서가 중요하다. init reInit 을 사용해서 처음 시작부터 적용되게함.글자색 바꾸기//
    $('.main_slider').on('init reInit afterChange', function(){
        let current = $('.slick-current');
        current.addClass('on').siblings().removeClass('on')
    })


    //슬라이더와 슬라이더 옵션//
    $('.main_slider').slick({
    arrows: false,
    dots: true,
    autoplay: true,
    pauseOnHover: false,
    pauseOnFocus: false,
    });

    // //슬라이더 활성화 시 .on 클래스 붙이기//
    // $('.main_slider').on('afterChange', function(){
    // let current = $('.slick-current');
    // current.addClass('on').siblings().removeClass('on')
    // })

//-----------movie -----------------------//
//그냥 nth-child는 3번째가 되고 nth-of-type은 저 태그안에서 첫번째//
    $('.movie .dec i:nth-of-type(1)').on('click', function(){
        $('.movie video').trigger('play')
    });
    
    $('.movie .dec i:nth-of-type(2)').on('click', function(){
        $('.movie video').trigger('pause')
    });

    $("#myMovie").YTPlayer({
        videoURL:'h3rKe6DdC18',
                        containment:'.utube',
                        autoPlay:true, 
                        mute: true, 
                        startAt:0, 
                        opacity:1,
                        showControls: false,
                        playOnlyIfVisible: true,
    });

    $('.utube i:nth-of-type(1)').on('click', function(){
        $("#myMovie").YTPPlay();
    });

    $('.utube i:nth-of-type(2)').on('click', function(){
        $("#myMovie").YTPPause();
    });

    ///////////////////////////////////////

    //slick혼자하기----------------------///

   // $('.slider_product .container').slick({
    //    slidesToShow: 5,
    //    slidesToScroll: 1,
    //    autoplay: false,
    //    arrows: false,
    //    dots: true,
    //  });

      //$(".slider_product i.xi-arrow-left").on("click", function(){
    //$(".slider_product .container").slick("slickPrev");
    //  });
    //  $(".slider_product i.xi-arrow-right").on("click", function(){
    //    $(".slider_product .container").slick("slickNext");
    //  });

///////////////////////////////////////////////

////////////footer form...혼자하기///////////////////
//$(".link select").on("change", function(){
//    var lik=$(this).val();
//    if(lik) window.open(lik);
//  });



////////////////////////////////////////////

$('.product_slider').on('init reInit afterChange', function(){
    let current = $('.product_slider .slick-center');
    current.addClass('on').siblings().removeClass('on');

})


$('.product_slider').slick({
    slidesToShow: 5,
    centerMode: true, //1200px라인 맞추고 싶다 = 센터모드
    arrows: false,
    dots: true,
    autoplay: true,

    //slick responsive 반응형--------------------------------//
    responsive: [
        {
          breakpoint: 768,
          settings: {
            slidesToShow: 1,
          }
        }
        // You can unslick at a given breakpoint now by adding:
        // settings: "unslick"
        // instead of a settings object
      ]
});

$('.product_list .s_left').on('click', function(){
    $('.product_slider').slick('slickPrev');
})
$('.product_list .s_right').on('click', function(){
    $('.product_slider').slick('slickNext');
})


/////////////tap메뉴만들기//////////////////////

$('.tab_link>li').on('click', function(){
var idx = $(this).index();
$(this).addClass('on').siblings().removeClass('on');

$('.tab_content>li').eq(idx).addClass('on').siblings().removeClass('on');
})
//eq는 css의 nth child와 비슷 몇번째 인지///////
})
////////////////////////////////////////////

////////////////////form//////////////////////

$('.footer #link').on('change', function(){
    var lik = $(this).val();
if (lik) window.open(lik)
})

////////////////반응형/////////////////////
//// () => {} 는 function (){} 의 축약 but this는 먹히지 않음.///////
$('.mbtn').on('click', function() {
    $('nav').toggleClass('on');
    $(this).toggleClass('is-active');
})