package com.abdts.search.identity;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.identity.StudentIdentity;
import com.abdts.search.student.StudentListSearch;
import com.abdts.service.identity.StudentIdentityService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author pzy
 */
@RestController
@RequestMapping("/stuIdentity")
public class StuIdentitySearch extends BaseController {

    private Logger logger = Logger.getLogger(StudentListSearch.class);

    @Resource
    private StudentIdentityService studentIdentityService;

    @RequestMapping(value = "/getStuIdentitys", produces = {"application/json;charset=utf-8"}, method = RequestMethod.GET)
    public List<StudentIdentity> getStuIdentitys() {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        return studentIdentityService.getStuIdentity(dataKeyPair);
    }

}
