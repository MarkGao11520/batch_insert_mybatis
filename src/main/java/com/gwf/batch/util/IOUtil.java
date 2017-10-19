package com.gwf.batch.util;

import com.gwf.batch.model.DataModel;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Created by gaowenfeng on 2017/10/19.
 */
public class IOUtil {

    /**
     * 读取gzip文件夹，并读取所有的gzip内容
     * @param dirPath 文件夹路径
     * @return
     */
    public static List<DataModel> readFiles(String dirPath) {

        List<DataModel> dataList = new ArrayList<>();
        List<String> fileList = new ArrayList<>();
        scanFile(dirPath, fileList);

        for (int j = 0; j < fileList.size(); j++) {
            System.out.println("正在读取第" + (j + 1) + "个文件...");
                String result = unZipAndRead(fileList.get(j));
                String[] lines = result.split("\n");
                //将每个文件包里的所有数据存进数据模型
                for (int i = 1; i < lines.length; i++) {
                    String[] items = lines[i].split("\\s+");
                    try {
                        DataModel dataModel = new DataModel(items);
                        dataList.add(dataModel);
                    } catch (Exception e) {
                    }
                }
        }
        return dataList;

    }

    /**
     * 解压gzip文件并读取其中内容
     * @param fileName
     * @return
     */
    private static String unZipAndRead(String fileName){
        try (
                GZIPInputStream gzipIS = new GZIPInputStream(new FileInputStream(fileName));
                BufferedInputStream zin = new BufferedInputStream(gzipIS);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ) {
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = zin.read(buf, 0, 1024)) != -1) {
                baos.write(buf, 0, len);
            }
            baos.toByteArray();
            String result = baos.toString("UTF-8");
            return result;
        }catch (Exception e){
            System.out.println("文件："+fileName+"读取中出错！请检查问题。");
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 扫描文件路径，递归获取文件夹下的所有文件名
     * @param dirPath
     * @param fileArray
     */
    private static void scanFile(String dirPath, List<String> fileArray) {
        File file = new File(dirPath);
        if (!file.isDirectory()) {
            fileArray.add(dirPath);
        } else if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                String subFilePath = dirPath + File.separator + filelist[i];
                scanFile(subFilePath, fileArray);
            }
        }
    }
}
