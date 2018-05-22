/**
     * Map转xml字符串工具方法
     * @param map
     * @return
     */
    public static String map2Xml(Map<String, Object> map) {
        String resultXml = "";
        for(String key:map.keySet()){
            if(map.get(key) instanceof String){
                resultXml += "<"+key+">"+map.get(key)+"</"+key+">";
            } else if(map.get(key) instanceof Map) {
                resultXml += "<"+key+">";
                resultXml += map2Xml((Map<String, Object>)map.get(key));
                resultXml += "</"+key+">";
            } else if(map.get(key) instanceof List) {
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
            }
        }
        return resultXml;
    }