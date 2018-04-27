package com.abdts.controller.mysql;

import com.abdts.common.util.BaseController;
import com.abdts.common.util.DataKeyPair;
import com.abdts.entity.score.Score;
import com.abdts.service.exam.ExamService;
import com.abdts.service.mysql.TableService;
import com.abdts.vo.exam.ExamVO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 * @author pzy
 */
@RestController
@RequestMapping("/table")
public class TableController extends BaseController {

    @Resource
    private TableService tableService;
    @Resource
    private ExamService examService;

    @RequestMapping(value = "/createExamTable", method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    public Object createExam() throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        if (!dataKeyPair.containsKey("public_exam_name")) {
            return dataKeyPair;
        } else {
            if (dataKeyPair.get("public_exam_name") == "" || dataKeyPair.get("public_exam_name") == null) {
            } else {
                dataKeyPair.put("public_exam_subject", 1);
                dataKeyPair.put("public_exam_gradeid", 4);
                dataKeyPair.put("public_exam_schoolid", 1001);
                dataKeyPair.put("public_exam_datetime", new Date());
                if (examService.addExam(dataKeyPair) > 0) {
                    List<ExamVO> exams = examService.getExams(dataKeyPair);
                    String tableName = "exam_1001_" + exams.get(exams.size() - 1).getPublic_exam_id();
                    dataKeyPair.put("tableName", tableName);
                    tableService.createTable(dataKeyPair);
                }
            }
        }

        return dataKeyPair;
    }

    @RequestMapping(value = "/createTable", method = RequestMethod.POST,
            produces = {"application/json;charset=utf-8"})
    public Object createTable(@RequestParam(value = "filename") MultipartFile file,
                              HttpServletRequest request) throws Exception {
        DataKeyPair dataKeyPair = this.getDataKeyPair();
        //判断文件是否为空
        if (file == null) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("smg", "文件不能为空~");
            return dataKeyPair;
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if (!fileName.endsWith("xls") && !fileName.endsWith("xlsx")) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", false);
            dataKeyPair.put("smg", "不是excel文件~");
            return dataKeyPair;
        }
        List<Score> scores = new ArrayList<>();
        List<ExamVO> exams = examService.getExams(dataKeyPair);
        String tableName = "exam_1001_" + exams.get(exams.size() - 1).getPublic_exam_id();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = workbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }

            // 循环行Row
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
                if (rowNum == 0) {
                    continue;
                }
                Score score = new Score();
                // 循环列Cell
                for (int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++) {
                    XSSFCell xssfCell = xssfRow.getCell(cellNum);
                    if (xssfCell == null) {
                        continue;
                    }
                    score.setTableName(tableName);
                    if (cellNum == 0) {
                        score.setStudent_chinese_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 1) {
                        score.setStudent_math_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 2) {
                        score.setStudent_english_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 3) {
                        score.setStudent_physics_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 4) {
                        score.setStudent_chemistry_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 5) {
                        score.setStudent_biology_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 6) {
                        score.setStudent_politics_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 7) {
                        score.setStudent_history_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 8) {
                        score.setStudent_geography_scores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 9) {
                        score.setStudent_totalscores(Double.valueOf(String.valueOf(getValue(xssfCell))));
                    } else if (cellNum == 10) {
                        String id = String.valueOf(getValue(xssfCell));
                        Long stuId = Long.parseLong(id);
                        score.setStudent_id(BigInteger.valueOf(stuId));
                    } else if (cellNum == 11) {
                        score.setStudent_classranking(Integer.valueOf(String.valueOf(getValue(xssfCell)).substring(0, 1)));
                    }
                }
                scores.add(score);
                System.out.println();
            }
        }
        if (tableService.addTableInfo(scores) > 0) {
            dataKeyPair.clear();
            dataKeyPair.put("rel", true);
            dataKeyPair.put("smg", "添加考试成功~");
        } else {
            dataKeyPair.clear();
            dataKeyPair.put("rel", true);
            dataKeyPair.put("smg", "添加考试失败~");
        }

        return dataKeyPair;
    }


}
