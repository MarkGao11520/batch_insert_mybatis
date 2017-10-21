package com.gwf.batch.mybatis;

import com.gwf.batch.model.DataModel;
import com.gwf.batch.mybatis.mapper.UserMapper;
import com.gwf.batch.util.IOUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by gaowenfeng on 2017/5/17.
 */
public class TestMybatis {
    private static final int batchCount = 1000;

    @Test
   public void test() throws Exception {
        System.out.println(insertData(IOUtil.readFiles("/Users/gaowenfeng/Documents/IDE/batch_insert_mybatis/src/main/resources/data")));
   }


    public long insertData(List<DataModel> dataList) throws IOException {
        String filePath = "../../../../mybatisAnnotationConfig.xml";
        InputStream is = this.getClass().getResourceAsStream(filePath);
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(is);
        try(
                SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        ) {


            int batchLastIndex = batchCount;  //每批最后一个下标

            //开始时间；
            Long begin = new Date().getTime();

            //执行sql
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            for(int index=0;index<dataList.size();){
                if(batchLastIndex >= dataList.size()){
                    batchLastIndex = dataList.size();
                    userMapper.insertUserBatch(dataList.subList(index,batchLastIndex));
                    sqlSession.commit();
                    System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
                    break;  //数据插入完毕，退出循环
                }else {
                    userMapper.insertUserBatch(dataList.subList(index,batchLastIndex));
                    sqlSession.commit();
                    System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
                    index = batchLastIndex;  //设置下一个下标
                    batchLastIndex = index+(batchCount);
                }
            }


            sqlSession.commit();

            //关闭
            sqlSession.close();
            // 结束时间
            Long end = new Date().getTime();

            // 耗时
            System.out.println("插入" + dataList.size() + "条数据的总时间为 : " + (end - begin) + " ms");

            return (end-begin);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            is.close();
        }
        return 0;
    }

}
