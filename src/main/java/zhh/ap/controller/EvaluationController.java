package zhh.ap.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhh.ap.bean.Evaluation;
import zhh.ap.service.IAppEvaluationSV;
import zhh.ap.util.TimeUtil;
import zhh.ap.valuebean.HttpReqResult;

import javax.annotation.Resource;
import java.util.Date;

@RequestMapping("/evaluation")
@RestController
public class EvaluationController {
    private static transient Log _log = LogFactory.getLog(EvaluationController.class);
    @Resource(name = "appEvaluationSV")
    private IAppEvaluationSV evaluationSV;

    @RequestMapping(value = "/add", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public HttpReqResult add(@RequestBody Evaluation evaluation) {
        _log.error("保存evaluation记录");
        HttpReqResult reqResult = new HttpReqResult(HttpReqResult.SUCCESS);
        evaluation.setOptTime(TimeUtil.getYYYYMMDDHHMMSS(new Date()));
        evaluationSV.insert(evaluation);
        return reqResult;
    }

}
