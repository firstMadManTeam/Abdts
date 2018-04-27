package com.abdts.search.subject;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.service.sign.SignService;
import com.abdts.service.subject.SubjectService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author pzy
 */
@RestController
@RequestMapping("/subject")
public class SubjectSearch extends BaseController {

    @Resource
    private SubjectService subjectService;

    private Logger logger = Logger.getLogger(SignService.class);

    @RequestMapping(value = "/getSubjectList", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public Object getSubjectList() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        return subjectService.getSubjectList(dataKeyPair);
    }

}
