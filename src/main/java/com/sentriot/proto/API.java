package com.sentriot.proto;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

@Controller
public class API {

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity qr()
    {
        return new ResponseEntity(QRCode.from("http://www.sunnyleone.com/en//?utm_source=1000&utm_campaign=")
                    .to(ImageType.PNG).withSize(250, 250)
                    .withColor(0xFFFF0000, 0xFFFFFFAA).stream().toByteArray(),
                    HttpStatus.OK);
    }
}