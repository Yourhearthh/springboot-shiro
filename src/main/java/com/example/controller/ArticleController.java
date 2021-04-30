package com.example.controller;

import com.example.entity.Article;
import com.example.repository.ArticleRepository;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:32
 * @version: 1.0
 */
@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Description: 文章列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("article:view")//访问的权限
    public ModelAndView articlelist(@RequestParam(value = "start", defaultValue = "0") Integer start,
                                    @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Article> page = articleRepository.findAll(pageable);
        ModelAndView mav = new ModelAndView("article/list");
        mav.addObject("page", page);
        return mav;
    }

    /**
     * Description: 根据id获取文章对象
     */
    @GetMapping("/{id}")
    public ModelAndView getArticle(@PathVariable("id") Integer id)  throws Exception {
        Article articles = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/show");
        mav.addObject("article", articles);
        return mav;
    }


    /**
     * Description: 新增操作视图
     */
    @GetMapping("/add")
    @RequiresPermissions("article:add")//新增的权限
    public String addArticle()   throws Exception{
        return "article/add";
    }

    /**
     * Description: 新增保存方法
     */
    @PostMapping("")
    public String saveArticle(Article model)  throws Exception{
        articleRepository.save(model);
        return "redirect:/article/list";
    }

    /**
     * Description: 删除
     */
    @DeleteMapping("del/{id}")
    @RequiresPermissions("article:del")//新增的权限
    public String del(@PathVariable("id") long id)  throws Exception{
        articleRepository.deleteById(id);
        return "redirect:";
    }


    /**
     * Description: 编辑视图
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("article:edit")//新增的权限
    public ModelAndView editArticle(@PathVariable("id") long id)  throws Exception {
        Article model = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/edit");
        mav.addObject("article", model);
        return mav;
    }

    /**
     * Description: 修改方法
     */
    @PostMapping("/{id}")
    public String editArticleSave(Article model, long id)  throws Exception{
        model.setId(id);
        articleRepository.save(model);
        return "redirect:/article/list";
    }
}
