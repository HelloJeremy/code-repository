/**
*
*筛选_遍历时正确删除满足条件的list中的元素
**/

//错误代码-->出现异常ConcurrentModificationException(因为在遍历时remove会改变list 元素的index)
List<Map<String, Object>> resMap = simpleJdbcTemplate.queryForList(...);
List<Map<String, Object>> currentresMap = new ArrayList<Map<String, Object>>();
for(Map<String, Object> temp : resMap) {
    String day = (String)temp.get("MONTH");
    String year = day.split("-")[0];
    if(currentYear.equals(year)) {
        currentresMap.add(temp);
        resMap.remove(temp);
    }
}

//正确代码(筛选)_迭代器
 List<Integer> list1 = new ArrayList<Integer>();
 for(int i = 1;i<=10;i++) {
     list1.add(i);
 }
 List<Integer> list2 = new ArrayList<Integer>();
  Iterator<Integer> iterator = list1.iterator();
    while (iterator.hasNext()){
        Integer next = iterator.next();
        if(next%2==0) {
           iterator.remove();
           list2.add(next);
        }
    }

//动态向map中添加元素
 List<Map<String, String>> sbmxs = (List<Map<String, String>>)maps.get("sbmxs");
    for(Map<String, String> sbmx: sbmxs) {
        String  sfmxsb = sbmx.get("sfmxsb");
        if("1".equals(sfmxsb)) {
            sbmx.put("sfmxsbMc","是");
        } else {
            sbmx.put("sfmxsbMc","否");
        }
    }


