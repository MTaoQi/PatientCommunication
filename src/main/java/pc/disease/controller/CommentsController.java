package pc.disease.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pc.disease.entity.Comments;
import pc.disease.service.CommentsService;
import pc.utils.PcResultutil;


/**
 * <p>
 *  前端控制器
 * </p>
 *  评论
 * @author lazymxh
 * @since 2022-03-27 12:58:12
 */
@RestController
@RequestMapping("/disease/comments")
public class CommentsController {
@Autowired
CommentsService commentsService;
@RequestMapping("/istcomment")
public PcResultutil istcomment(@RequestBody Comments comments){
    return commentsService.istcomment(comments);
}
@GetMapping("/selcomment")
public PcResultutil selcomment(@RequestParam("communicationid") String communicationid){
    return commentsService.selcomment(communicationid);
}
@GetMapping("/delcomment")
    public PcResultutil delcomment(@RequestParam("replyid") String replyid){
    return commentsService.delcomment(replyid);
}
@GetMapping("/numcomment")
    public PcResultutil numcomment(@RequestParam("communicationid") String communicationid){
    return commentsService.numcomment(communicationid);
}


}
