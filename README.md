# batch_insert_mybatis

## 解压gzip压缩文件并读取数据，使用mybatis事务批处理插入60000+数据

- #### 数据库结构文件：```src/main/resources/schema.sql```

- #### IO静态方法封装: ```src/main/com/gwf/batch/util/IOUtil ```

- #### 批量插入方法: ```src/main/com/gwf/batch/mybatis/TestMybatis ```

- #### 数据文件: ```src/main/resources/data```

- #### 使用:
```
修改src/main/com/gwf/batch/mybatis/TestMybatis 的
System.out.println(insertData(IOUtil.readFiles("/Users/gaowenfeng/Documents/IDE/batch_insert_mybatis/src/main/resources/data")));
里的路径为自己的数据文件路径
```
