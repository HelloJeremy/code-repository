/**
     * Map转xml字符串工具方法
     * @param map
     * @return
     */
    public static String map2Xml(Map<String, Object> map) {
           String resultXml = "";
           for(String key:map.keySet()){
               if(map.get(key) instanceof String || map.get(key) instanceof Number){
                   resultXml += "<"+key+">"+map.get(key)+"</"+key+">";
               } else if(map.get(key) instanceof Map) {
                   resultXml += "<"+key+">";
                   resultXml += map2Xml((Map<String, Object>)map.get(key));
                   resultXml += "</"+key+">";
               } else if(map.get(key) instanceof List) {
                   if(((List) map.get(key)).size()>0) {
                       if(((List) map.get(key)).get(0) instanceof Map) {
                           for(Map<String,Object> arrObj: (List<Map<String, Object>>)map.get(key)) {
                               resultXml += "<"+key+">";
                               resultXml += map2Xml(arrObj);
                               resultXml += "</"+key+">";
                           }
                       } else {
                           for(Object arrObj: (List<Object>)map.get(key)) {
                               resultXml += "<"+key+">"+arrObj+"</"+key+">";
                           }
                       }
                   } else {
                       resultXml += "<"+key+"/>";
                   }
               }
           }
           return resultXml;
       }


 /**
     * xml字符串转Java map
     * @param xmlStr
     * @return
     */
     //用到的jar包
     <dependency>
        <groupId>xom</groupId>
        <artifactId>xom</artifactId>
        <version>1.2.5</version>
     </dependency>
    import net.sf.json.xml.XMLSerializer;

    public static Map<String,Object> xmlStr2Map(String xmlStr) {
        //创建 XMLSerializer对象
        XMLSerializer xmlSerializer = new XMLSerializer();
        //将xml转为json
        String result = xmlSerializer.read(xmlStr).toString();
        Map<String,Object> maps = (Map<String,Object>) JSON.parse(result);
        return maps;
    }