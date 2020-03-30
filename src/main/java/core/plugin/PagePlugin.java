package core.plugin;

import core.results.PageInfo;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
    自定义分页
 */
@Intercepts(@Signature(type = StatementHandler.class,
method = "prepare",args = {Connection.class,Integer.class}))
public class PagePlugin implements Interceptor {

    //数据库类型
    private static String dialect = "";
    //匹配标识
    private static String pageSqlId = "";

    /*
        拦截器要执行的方法
     */
    @Override
    public Object  intercept(Invocation invocation) throws Throwable {
        //invocation 中获取 StatementHandler
        StatementHandler statementHandler=(StatementHandler)invocation.getTarget();

//引入mybatis 已经实现的对象： MetaObject，把StatementHander的实例变为MetaObject实例
        MetaObject metaObject= MetaObject.forObject(statementHandler,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());
        //通过metaObject 获取 MapperStatement
        MappedStatement mappedStatement=(MappedStatement)metaObject.getValue("delegate.mappedStatement");

        //mapper文件中sql语句唯一 id
        String id=mappedStatement.getId();

        //根据自定义标识匹配分页方法[以byPage结尾的方法]
        if(id.matches(pageSqlId)){
            BoundSql boundSql=statementHandler.getBoundSql();
            //获取分页参数 map.put("page",new PageInfo());
            Map<String ,Object> params=new HashMap<>();
            if(boundSql.getParameterObject() instanceof PageInfo){
                PageInfo pageInfo= (PageInfo) boundSql.getParameterObject();
                params.put("pageInfo",pageInfo);
            }else{
               params= (Map<String, Object>) boundSql.getParameterObject();
            }
            if(params == null){
                throw new NullPointerException("分页参数不能为空");
            }else{
                //获取pageInfo
                PageInfo pageInfo =(PageInfo)params.get("pageInfo");
                //获取原始的 SQL
                String sql=boundSql.getSql();
                System.out.println("原始SQL："+sql);

                //拼接selectCount
                String countSql="select count(0) from ("+sql+") a";
                System.out.println("总数SQL语句："+countSql);

                //mybatis执行查询总数
                Connection connection = (Connection)invocation.getArgs()[0];
                PreparedStatement pre=connection.prepareStatement(countSql);

                //获取参数对象
                ParameterHandler parameterHandler=(ParameterHandler)metaObject.getValue("delegate.parameterHandler");
                parameterHandler.setParameters(pre);

                ResultSet rs= pre.executeQuery();
                if(rs.next()){
                    int totalNumber=rs.getInt(1);
                    pageInfo.setTotalNumber(totalNumber);
                    int totalPage=totalNumber/ pageInfo.getPageSize();
                    if(totalNumber% pageInfo.getPageSize()!=0){
                        totalPage=totalPage+1;
                    }
                    pageInfo.setTotalPage(totalPage);
                }
                rs.close();
                pre.close();
                //拼接selectPage()
                int start=(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize();
                String pageSql=sql+" limit "+ start+" ,"+ pageInfo.getPageSize();
                System.out.println("分页SQL语句:"+pageSql);
                //替换原来的SQL语句
                metaObject.setValue("delegate.boundSql.sql",pageSql);
            }
        }
        //将程序的控制权交给mybatis
        return invocation.proceed();
    }

    /*
        拦截器需要拦截的对象
     */
    @Override
    public Object plugin(Object o) {
        //拦截器需要拦截的对象o ;this当前类的实例
        return Plugin.wrap(o,this);
    }

    /*
        赋值
     */
    @Override
    public void setProperties(Properties properties) {
        dialect = properties.getProperty("dialect");
        pageSqlId = properties.getProperty("pageSqlId");

    }
}
