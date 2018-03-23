/**
* java代码操作数据库的常用备忘
*
**/

//使用UUID作为数据库表中的唯一主键
UUID.randomUUID().toString().replaceAll("-", "");

/***MyBatis调用存储过程(其中返回结果是一个list集合)***/

//oracle中的存储过程
CREATE OR REPLACE PROCEDURE P_NF_NSPM_ZRR_JSQX(
       V_DJXH IN VARCHAR2,
       V_SBRQQ IN DATE,
       V_SBRQZ IN DATE,
       RES OUT sys_refcursor
) is
  V_SQL        VARCHAR2(4000);
--首页缴款明细
begin
  OPEN RES for
  SELECT /*+INDEX(T I_NF_GRSBNSMX_JG_DJXH) */
 TO_CHAR(T.SBRQ, 'yyyy-mm') MONTH, SUM(YBTSE) ZSE
  FROM NF_NFZC.NF_GRSBNSMX_JG T
 WHERE T.DJXH = V_DJXH
   AND T.SBRQ >= TRUNC(V_SBRQQ)
   AND T.SBRQ <  TRUNC(V_SBRQZ)+1
 GROUP BY TO_CHAR(T.SBRQ, 'yyyy-mm')
 ;


end;

//出参对应的VO对象
public class NsqxVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String MONTH;

	private String ZSE;
}

//1.在mybatis的映射文件中定义调用存储过程的sql(注意入参IN和出参OUT)
//mybatis映射文件的namespace：<mapper namespace="com.foresee.mobile.cloud.gxdscenter.dao.NfEcmTZbZbzxcljgDao" >
//这个resultMap对应下面调用存储过程中的出参OUT中的resultMap
<resultMap id="NsqxResultMap" type="com.foresee.mobile.api.pojo.biz.gxds.NsqxVo" >
	  <result column="MONTH" property="MONTH" jdbcType="VARCHAR" />
	  <result column="ZSE" property="ZSE" jdbcType="VARCHAR" />
</resultMap>

 <!-- 调用P_NF_NSPM_ZRR_JSQX储存过程 -->
   <select id="executeQueryJsOfMonth" statementType="CALLABLE" parameterType="map">
		<![CDATA[
			{call P_NF_NSPM_ZRR_JSQX (#{V_DJXH, mode=IN, jdbcType=VARCHAR},#{V_SBRQQ, mode=IN, jdbcType=VARCHAR},#{V_SBRQZ, mode=IN, jdbcType=VARCHAR},#{RES, mode=OUT, jdbcType=CURSOR, javaType=java.sql.ResultSet, resultMap=com.foresee.mobile.cloud.gxdscenter.dao.NfEcmTZbZbzxcljgDao.NsqxResultMap})}
		 ]]>
	</select>

//映射文件对应的dao
@NfzcMyBatisRepository
public interface NfEcmTZbZbzxcljgDao {
    void executeQueryJsOfMonth(Map map);
}

//java代码调用存储P_NF_NSPM_ZRR_JSQX过程
    Map paramMap = new HashMap();
    paramMap.put("V_DJXH", djxh);
    paramMap.put("V_SBRQQ", start);
    paramMap.put("V_SBRQZ", end);
    //	paramMap.put("RES","");
    NfEcmTZbZbzxcljgDao.executeQueryJsOfMonth(paramMap); //储存过程调用成功后 会将结果存到参数map：paramMap中,键为：'RES'
    List<NsqxVo> resMap = (List)paramMap.get("RES"); //获取存储过程执行结果



