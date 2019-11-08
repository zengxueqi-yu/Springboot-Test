package com.july.test.controller;

import com.july.test.util.FontImage;
import com.july.test.util.QrCodeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 生成二维码测试
 * @author zqk
 * @since 2019/10/27
 */
@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    /**
     * 生成二维码
     * @author zqk
     */
    @GetMapping(value = "/makeQrCode")
    public void makeQrCode() throws Exception {
        //二维码中的文字样式
        InputStream inputStream = FontImage.createImageForFont(
                "LOGO",100, 100);
        //本地LOGO文件（下面这是苹果电脑录入，改为自己的电脑路径即可）
        InputStream inputStream1 = new FileInputStream("/usr/local/photos/test.jpg");


        BufferedImage bufferedImage = QrCodeUtils.makeQrCodeIns("测试二维码",inputStream,false);
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        OutputStream toClient=response.getOutputStream();
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

}