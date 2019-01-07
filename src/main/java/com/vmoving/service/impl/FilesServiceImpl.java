package com.vmoving.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.vmoving.domain.Files;
import com.vmoving.dto.ResultVO;
import com.vmoving.repository.FilesRepository;
import com.vmoving.service.FilesService;
//import com.vmoving.utils.ImageUtil;
import com.vmoving.utils.ImgHolderUtil;
import com.vmoving.utils.KeyUtil;
import com.vmoving.utils.PathUtil;
import com.vmoving.utils.ResultVOUtil;

@Service
public class FilesServiceImpl implements FilesService {
 
	@Autowired(required = true)
    private FilesRepository repository;

    @Override
    public ResultVO save(String msg, CommonsMultipartFile faultImage) {
        Files files = new Files();
        files.setId(KeyUtil.genUniqueKey());
        files.setMsg(msg);
        try {
            if (faultImage != null){
                ImgHolderUtil imgHolder = new ImgHolderUtil(faultImage.getOriginalFilename(),faultImage.getInputStream());
                if (imgHolder.getImage() != null){
                    //存储图片
                    files.setImg(addFaultImg(files,imgHolder));
                }
            }
            Files result = repository.save(files);
            return ResultVOUtil.success();
        }catch (Exception e) {
            return ResultVOUtil.error(777,"图片上传异常");
        }
    }

    private String addFaultImg(Files files, ImgHolderUtil imgHolder) {
        //获取图片目录的相对值路径
        String dest = PathUtil.getImagePath(files.getId());
        String ImgAddr = ""; //ImageUtil.generateThumbnail(imgHolder,dest);
        return ImgAddr;
    }

}
