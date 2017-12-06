/**
 * @disc:对请求的返回结果按照特定条件进行分组
 * @date:2017/12/6 10:39
 * @author:xujiacheng
 * @analysis
 *      1.新建一个数组tempArr。对结果results进行遍历，tempArr接收分组的条件；
 *      2.对数组tempArr和结果results进行嵌套遍历；
 *      3.在嵌套遍历中对results元素和tempArr元素进行对比，进行分组。
 * **/

function resultsGroup(d) {
    var tempArray = [];
    d.resJson.datas.data.forEach((item) => {
        var tempMonth = item.lrrq.split('-')[1];
        if (!(tempArray.indexOf(tempMonth) > -1)) {
            tempArray.push(tempMonth);
        }
    })
    tempArray.forEach((m, index) => {
        var total = 0;
        var number = 0
        var tempDataArray = [];
        d.resJson.datas.data.forEach((item) => {
            var temp = item.lrrq.split('-')[1];
            if (m === temp) {
                total += item.ybtse;
                number += 1;
                tempDataArray.push(item);
            }
        });
        var desc =  `${this.currentYear}年${m}月，xxxxx${number}次，${total}元`;
        var obj = {desc,datas:tempDataArray}
        this.resultData.push(obj);
    })
}