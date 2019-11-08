package com.july.test.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 文字生成图片
 * @author zqk
 * @since 2019/9/2
 */
public class FontImage {

    /**
     * 生成文字图片（得到输入流）
     * @param str
     * @param width
     * @param height
     * @return
     * @author zqk
     */
    public static InputStream createImageForFont(String str, Integer width, Integer height) {
        String[] evalNameArr = stringSpilt(str,4);
        //创建图片模版
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();

        //初始化白色背景
        g2.setColor(Color.white);
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.setClip(0, 0, width, height);

        //抗锯齿添加文字
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        Font font = new Font("宋体", Font.PLAIN, 16);
        g2.setFont(font);
        g2.setPaint(new Color(103, 101, 120));

        //用于获得垂直居中
        Rectangle clip = g2.getClipBounds();
        FontMetrics fm = g2.getFontMetrics(font);
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int y = (clip.height - (ascent + descent) * evalNameArr.length) / 2 + ascent;
        FontRenderContext context = g2.getFontRenderContext();

        //画出字符串
        for (int i = 0; i < evalNameArr.length; i++) {
            Rectangle2D bounds = font.getStringBounds(evalNameArr[i], context);
            double x = (width - bounds.getWidth()) / 2;
            g2.drawString(evalNameArr[i], (int)x, y + (ascent + descent) * i);
        }
        g2.dispose();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try{
            //输出png图片
            ImageIO.write(img, "png", os);
            InputStream input = new ByteArrayInputStream(os.toByteArray());
            return input;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据徐需求把字符串分隔自己想要的数组
     * @param s
     * @param len
     * @return
     * @author zqk
     */
    public static String[] stringSpilt(String s,int len){
        //想要分割获得的子字符串的长度
        int spiltNum;
        int i;
        //存放需要切割的数组长度
        int cache = len;
        spiltNum = (s.length())/len;
        //创建可分割数量的数组
        String[] subs;
        if((s.length()%len)>0){
            subs = new String[spiltNum+1];
        }else{
            subs = new String[spiltNum];
        }

        //可用一个全局变量保存分割的数组的长度
        //System.out.println(subs.length);
        int start = 0;
        if(spiltNum>0){
            for(i=0;i<subs.length;i++){
                if(i==0){
                    subs[0] = s.substring(start, len);
                    start = len;
                }else if(i>0 && i<subs.length-1){
                    len = len + cache ;
                    subs[i] = s.substring(start,len);
                    start = len ;
                }else{
                    subs[i] = s.substring(len,s.length());
                }
            }
        }
        return subs;
    }

}
