package com.xuecheng.manage_cms.web.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.CmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yinkang
 * @Date 2020/3/11 12:48
 * cms页面管理控制层
 */
@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {
    @Autowired
    private CmsPageService cmsPageService;
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable(value = "page",required = true) int page, @PathVariable(value = "size",required = true)int size, QueryPageRequest queryPageRequest) {
        return cmsPageService.findList(page,size,queryPageRequest);
    }



    @Override
    @GetMapping("/get/{pageId}")
    public CmsPageResult get(@PathVariable(value = "pageId",required = true) String pageId) {
        return cmsPageService.get(pageId);
    }

    @Override
    @PostMapping("/add")
    public CmsPageResult add(CmsPage cmsPage) {
        return cmsPageService.add(cmsPage);
    }

    @Override
    @GetMapping("/delete/{pageId}")
    public ResponseResult deleteByPageId(@PathVariable(value = "pageId",required = true) String pageId) {
        return cmsPageService.deleteByPageId(pageId);
    }


    @Override
    @PutMapping("/edit")
    public CmsPageResult edit(CmsPage cmsPage) {
        return cmsPageService.edit(cmsPage);
    }
}
