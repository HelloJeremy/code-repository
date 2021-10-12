# code-repository
Personal business code and back-up




idea/webstorm ctrl+shift+m快捷键：光标定位到相关类、方法...定义的结尾或开端

mvn clean package -Dskiptest=true

### 从Maven本地仓库删除jar
#### 清除某个jar
mvn dependency:purge-local-repository -DmanualInclude="groupId:artifactId"
#### 清除多个属于不同groupId的jar
mvn dependency:purge-local-repository -DmanualInclude="groupId1:artifactId1,groupId2:artifactId2,..."

