package com.abdts.search.score;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.exam.Exam;
import com.abdts.service.exam.ExamService;
import com.abdts.service.score.ScoreService;
import com.abdts.service.sign.SignService;
import com.abdts.vo.exam.ExamVO;
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
@RequestMapping("/score")
public class ScoreSearch extends BaseController {

    @Resource
    private ScoreService scoreService;
    @Resource
    private ExamService examService;

    private Logger logger = Logger.getLogger(SignService.class);

    @RequestMapping(value = "/getScores", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public Object getScores() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        List<ExamVO> exams = examService.getExams(dataKeyPair);
        String tableName = "exam_1001_" + exams.get(exams.size() - 1).getPublic_exam_id();
        dataKeyPair.put("tableName", tableName);
        return scoreService.getScores(dataKeyPair);
    }

    @RequestMapping(value = "/getScoresAvg", method = RequestMethod.GET,
            produces = {"application/json;charset=utf-8"})
    public Object getScoresAvg() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        List<ExamVO> exams = examService.getExams(dataKeyPair);
        String tableName = "exam_1001_" + exams.get(exams.size() - 1).getPublic_exam_id();
        dataKeyPair.put("tableName", tableName);
        Integer scoreAvg = scoreService.getScoreSum(dataKeyPair) / scoreService.getScoreCount(dataKeyPair);
        return scoreAvg;
    }

}
