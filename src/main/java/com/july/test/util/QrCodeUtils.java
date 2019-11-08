package com.july.test.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

/**
 * 二维码工具类
 * @author zqk
 * @since 2019/9/2
 */
public class QrCodeUtils {

    private static final String CHARSET = "utf-8";
    public static final String FORMAT = "JPG";
    /**
     * 二维码大小尺寸
     */
    private static final int QRCODE_SIZE = 300;
    /**
     * 二维码LOGO宽度
     */
    private static final int LOGO_WIDTH = 100;
    /**
     * 二维码LOGO高度
     */
    private static final int LOGO_HEIGHT = 100;

    /**
     * 生成二维码
     * @param content 二维码内容
     * @param logoUrl 二维码LOGO文件地址
     * @param inputStream 二维码LOGO文件流
     * @param boolCompress
     * @return
     * @throws Exception
     * @author zqk
     */
    public static BufferedImage createImage(String content, String logoUrl,InputStream inputStream, boolean boolCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE,
                hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        //如果需要用到logo图片时，传入路径时使用
        if (StringUtils.isEmpty(logoUrl) && inputStream == null) {
            return image;
        }else if(inputStream != null){
            //插入LOGO
            insertImage(image,inputStream, boolCompress);
        }else{
            //插入LOGO
            insertImageUrl(image,logoUrl, boolCompress);
        }
        return image;
    }

    /**
     * 图片url的插入方法
     * @param source
     * @param logoUrl
     * @param boolCompress
     * @throws IOException
     * @author zqk
     */
    public static void insertImageUrl(BufferedImage source, String logoUrl, boolean boolCompress) throws IOException {
        InputStream inputStream = getResourceAsStream(logoUrl);
        insertImage(source,inputStream,boolCompress);
    }

    /**
     * 插入二维码LOGO
     * @param source
     * @param inputStream
     * @param boolCompress
     * @throws IOException
     * @author zqk
     */
    public static void insertImage(BufferedImage source,InputStream inputStream, boolean boolCompress) throws IOException {
        try {
            Image src = ImageIO.read(inputStream);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            if (boolCompress) {
                if (width > LOGO_WIDTH) {
                    width = LOGO_WIDTH;
                }
                if (height > LOGO_HEIGHT) {
                    height = LOGO_HEIGHT;
                }
                Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                //绘制缩小后的图
                g.drawImage(image, 0, 0, null);
                g.dispose();
                src = image;
            }
            //插入LOGO
            Graphics2D graph = source.createGraphics();
            int x = (QRCODE_SIZE - width) / 2;
            int y = (QRCODE_SIZE - height) / 2;
            graph.drawImage(src, x, y, width, height, null);
            Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
            graph.setStroke(new BasicStroke(3f));
            graph.draw(shape);
            graph.dispose();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /**
     * 生成带有LOGO的二维码
     * @param content
     * @param logoUrl
     * @param boolCompress
     * @return
     * @throws Exception
     */
    public static BufferedImage makeQrCodeUrl(String content, String logoUrl, boolean boolCompress)
            throws Exception {
        BufferedImage image = QrCodeUtils.createImage(content, logoUrl, null,boolCompress);
        return image;
    }

    /**
     * 生成带有LOGO的二维码
     * @param content
     * @param inputStream
     * @param boolCompress
     * @return
     * @throws Exception
     */
    public static BufferedImage makeQrCodeIns(String content,InputStream inputStream, boolean boolCompress)
            throws Exception {
        BufferedImage image = QrCodeUtils.createImage(content,null,inputStream, boolCompress);
        return image;
    }

    /**
     * 获取指定文件的输入流
     * @param logoUr 文件的路径
     * @return
     * @author zqk
     */
    public static InputStream getResourceAsStream(String logoUr) {
        return FileUtils.class.getResourceAsStream(logoUr);
    }

    /**
     * 生成文件
     * @param image
     * @param outPutPath
     * @return
     * @throws IOException
     * @author zqk
     */
    public static File writeFile(BufferedImage image, String outPutPath) throws IOException {
        File outPutImage = new File(outPutPath);
        //如果图片不存在创建图片
        if (!outPutImage.exists()) {
            outPutImage.createNewFile();
        }
        //将二维码写入图片
        ImageIO.write(image, FORMAT, outPutImage);
        return outPutImage;
    }

}
