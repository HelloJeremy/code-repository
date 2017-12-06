/**
 * @disc:获取日期的相关代码
 * @date:2017/12/6 11:05
 * @author:xujiacheng
 *
 * **/

// 获取当前的年 格式：YY
function getCurrentYear() {
    var date = new Date();
    var year = date.getFullYear();
    return year;
}

// 获取当前的日期 格式：YYYY-MM-DD
function getCurrentDay() {
    var date = new Date();
    var seperator1 = "-";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

// 获取某年某月的第一天 格式：YYYY-MM-DD
function getFirstDay(year,month) {
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    return `${year}-${month}-01`;
}

//获取某年某月的最后一天 格式：YYYY-MM-DD
function getLastDay(year, month) {
    var _month = month
    var new_year = year; //取当前的年份
    var new_month = month++;//取下一个月的第一天，方便计算（最后一天不固定）
    if (month > 12) {
        new_month -= 12; //月份减
        new_year++; //年份增
    }
    var new_date = new Date(new_year, new_month, 1); //取当年当月中的第一天
    var day = (new Date(new_date.getTime() - 1000 * 60 * 60 * 24)).getDate();//获取当月最后一天日期
    if (_month >= 1 && _month <= 9) {
        _month = "0" + _month;
    }
    return `${year}-${_month}-${day}`;
}