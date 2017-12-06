/**
 * @disc:从当前月，每3个月请求一次，上拉滚动继续请求下三个月，直到01-01日
 * @date:2017/12/6 11:32
 * @author:xujiacheng
 * @analysis:
 *      1.判断当前月距1月是不是超过三个月，如果是A就从当前月取3个月查询，如果不是B就从1月01日到当前月查询(结束)；
 *      2.如果A,取当前月3个月后的那个月afterThreeMonth,重复1的判断逻辑。
 * **/

// 对当前月份进行判断==>获取查找期限起
var lastDay = `${swzdV.currentYear}-01-01`;

function checkTime(month) {
    if (month - 1 >= 3) {
        beforemonth = month - 2

        this.beforemonth = beforemonth
        this.hasmore = true;

        if (beforemonth <= 9) {
            beforemonth = "0" + beforemonth;
            return `${beforemonth}-01`;
        } else {
            return `${beforemonth}-01`;
        }
    } else {
        this.beforemonth = 1
        // this.hasmore = false;
        return "01-01";
    }
}

//第一次请求
function created() {
    var cxrqq = `${this.currentYear}-${this.checkTime(this.currentMonth)}`;
    var cxrqz = this._getCurrentDay();
    var params = this.getParamsByTab(cxrqq, cxrqz);
    this.toSearch(params);
}

// 上拉加载更多
var sLoading = false;
$(document).on('infinite', '.infinite-scroll', function () {
    // 如果正在加载，则退出
    if (sLoading) return;
    // 设置flag
    sLoading = true;
    toLoad();
});

// 下拉加载更多
var pLoading = false;
$(document).on('refresh', '.pull-to-refresh-content', function (e) {
    // 如果正在加载，则退出
    if (pLoading) return;
    // 设置flag
    pLoading = true;
    toLoad('pull');
    // $.pullToRefreshDone('.pull-to-refresh-content');
});

//请求更多
function toLoad(flag) {
    setTimeout(function () {
        if(swzdV.beforemonth===1) {
            return;
        }
        sLoading = false;
        pLoading = false;
        var cxrqz = swzdV.getLastDay(swzdV.currentYear, swzdV.beforemonth - 1);
        var cxrqq = `${swzdV.currentYear}-${swzdV.checkTime(swzdV.beforemonth - 1)}`;
      

        var params = swzdV.getParamsByTab(cxrqq, cxrqz);
        if (cxrqq === lastDay) {
            if (swzdV.hasmore) {
                swzdV.toSearch(params);
            }
            swzdV.hasmore = false;
            $.detachInfiniteScroll($('.infinite-scroll'));
            return;
        }
        if (swzdV.hasmore) {
            swzdV.toSearch(params);
        }
        if (flag === 'pull') {
            $.pullToRefreshDone('.pull-to-refresh-content');
        }
    }, 1000);
}