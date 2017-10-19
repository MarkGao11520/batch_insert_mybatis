package com.gwf.batch.mybatis.mapper;

import com.gwf.batch.model.DataModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by gaowenfeng on 2017/5/24.
 */
public interface UserMapper {
    @Insert("<script>INSERT into ncdc VALUES\n" +
            "        <foreach collection=\"list\" item=\"item\" separator=\",\">\n" +
            "        (#{item.STN},#{item.WBAN},\n" +
            "        #{item.YEARMODA},#{item.TEMP},\n" +
            "        #{item.DEWP},#{item.SLP},\n" +
            "        #{item.STP},#{item.VISIB},\n" +
            "        #{item.WDSP},#{item.MXSPD},\n" +
            "        #{item.GUST},#{item.MAX},\n" +
            "        #{item.MIN},#{item.PRCP},\n" +
            "        #{item.SNDP},#{item.FRSHTT})\n" +
            "        </foreach></script>")
    int insertUserBatch(List<DataModel> users);
}

