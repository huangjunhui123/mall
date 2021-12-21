package com.macro.mall.common.utils;

import com.macro.mall.common.exception.FrchainException;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * 图片操作工具类
 *
 * @author panhong.
 * @time 2020/4/17 0017.
 */
public class FileUtils {

    public static String image2Base64(String imgFile) {

        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(data));

    }

    public static String image2Base64FromURL(String imgURL) {

        byte[] data = null;
        BufferedImage image = null;
        String result = null;
        // 读取图片字节数组
        try {
            URL url = new URL(imgURL);
            image = ImageIO.read(url);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            BASE64Encoder encoder = new BASE64Encoder();
            result = encoder.encode(outputStream.toByteArray());
            result = result.replaceAll("\r|\n", "");

        } catch (IOException e) {
            e.printStackTrace();
            throw new FrchainException("文件不存在!");
        }
        return result;

    }


    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }

    public static void main(String[] args) {
        String imgFile = "E:\\face\\yyzz01.jpg";
        String base64 = image2Base64(imgFile);

        System.out.println(base64);
    }
}
