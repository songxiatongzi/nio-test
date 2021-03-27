//package com.example.nio.niotest.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import io.netty.util.internal.StringUtil;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.tomcat.util.http.fileupload.FileUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.util.Map;
//
///**
// * 图片上传
// * @author songxiatongzi
// * @date 2020/12/16 9:37
// */
//@RestController
//@RequestMapping("/upload")
//public class UploadImageController {
//
//    /**
//     * 上传菜品测试
//     * @param uploadfile
//     * @return
//     */
//    @RequestMapping(value = "/uploadMenuPic", method = RequestMethod.POST)
//    public ResponseBean uploadMenuPic(@RequestBody MultipartFile uploadfile) {
//        JSONObject result = new JSONObject();
//        try {
//            if (StringUtil.isEmpty(uploadfile)) {
//                //logger.error("未检测到文件");
//                return new ResponseBean(AnmavResponseConstant.STATUS_PARAM_ERROR, "未检测到文件");
//            }
//            String originalName = uploadfile.getOriginalFilename();
//            if (StringUtils.isEmpty(originalName)) {
//                //logger.error("文件名为空");
//                return new ResponseBean(AnmavResponseConstant.STATUS_PARAM_ERROR, "文件名不能为空");
//            }
//            //logger.info("文件名:" + originalName);
//            String suffix = originalName.substring(originalName
//                    .lastIndexOf("."));
//            String suffixs = ".bmp.jpg.png.BMP.JPG.PNG";
//            BufferedImage image = ImageIO.read(uploadfile.getInputStream());
//            if (!suffixs.contains(suffix)) {
//                result.put("respCode", "11");
//                result.put("message", "图片格式有误，必须为bmp, jpg, png图片格式中的一种");
//                //logger.error("图片格式有误，必须为bmp, jpg, png图片格式中的一种");
//                return new ResponseBean(AnmavResponseConstant.STATUS_PARAM_ERROR,
//                        "图片格式有误，必须为bmp, jpg, png图片格式中的一种", result);
//            } else if (!(!StringUtil.isEmpty(image) && image.getWidth() > 400 && image
//                    .getHeight() > 400)) {
//                result.put("respCode", "11");
//                result.put("message", "图片的宽度或者图片的高度不满足尺寸要求");
//               // logger.error("图片的宽度或者图片的高度不满足尺寸要求");
//                return new ResponseBean(AnmavResponseConstant.STATUS_PARAM_ERROR,
//                        "图片的宽度或者图片的高度不满足尺寸要求", result);
//
//            } else if (uploadfile.getSize() > 2 * 1024 * 1024) {
//                result.put("respCode", "11");
//                result.put("message", "图片的大小不能超过2M");
//               // logger.error("图片的大小不能超过2M");
//                return new ResponseBean(AnmavResponseConstant.STATUS_PARAM_ERROR,
//                        "图片的大小不能超过2M", result);
//            } else {
//                String fileName = FileUtils.getNewName(originalName);
//                Map<String, String> map = OSSUtils.upload(fileName, uploadfile.getInputStream());
//                if (StringUtil.isEmpty(map)) {
//                  //  logger.error("图片上传失败");
//                    return new ResponseBean(AnmavResponseConstant.STATUS_PARAM_ERROR,
//                            "图片上传失败");
//                }
//                result.put("fileUrl", map.get(OSSUtils.IMAGE_URL));
//                result.put("fileUrl1", map.get(OSSUtils.SMALL_IMAGE_URL));
//                result.put("respCode", "00");
//                result.put("message", "操作成功");
//               // logger.error("图片上传成功");
//                return new ResponseBean(AnmavResponseConstant.STATUS_SUCCESS,
//                        "图片上传成功！", result);
//            }
//        } catch (Exception e) {
//            result.put("respCode", "01");
//            result.put("message", e.getMessage());
//           // logger.info("修改出错:" + e.getMessage());
//            return new ResponseBean(AnmavResponseConstant.STATUS_PARAM_ERROR,
//                    "修改出错", result);
//        }
//    }
//}
