/**
 * @disc:js代码判断Html元素是否在浏览器可视区域内
 * @date:2017/12/6 15:27
 * @author:xujiacheng
 *
 * **/

function checkElInClient() {
    var windowHeight = document.documentElement.clientHeight // 视窗高度-也就是浏览器可视区域高度
    var targetRect = document.getElementsByClassName('infinite-scroll-preloader')[0].getBoundingClientRect()
    //getBoundingClientRect()的top属性-目标元素离视窗顶部的距离
    var targetTop = targetRect.top;
    if (targetTop < windowHeight) {// 在视窗内

    } else {// 在视窗外

    }
},