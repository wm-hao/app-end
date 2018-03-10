package zhh.ap.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import zhh.ap.bean.AppointmentRecord;
import zhh.ap.service.IAppRecordSV;
import zhh.ap.util.TimeUtil;
import zhh.ap.valuebean.AppConstants;
import zhh.ap.valuebean.RespRecord;
import zhh.ap.valuebean.UserLoginInfo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Resource(name = "appRecordSV")
    private IAppRecordSV recordSV;

    @RequestMapping(value = "selectByUserCode", method = {RequestMethod.OPTIONS, RequestMethod.POST})
    public List<RespRecord> selectByUserCode(@RequestBody UserLoginInfo userLoginInfo) {
        List<AppointmentRecord> records = recordSV.selectByUsercode(userLoginInfo.getUserCode());
        List<RespRecord> results = new ArrayList<>();
        for (AppointmentRecord record : records) {
            RespRecord result = new RespRecord();
            result.setAppointmentTime(TimeUtil.getYYYYMMDDFromStr(record.getAppointTime()));
            result.setDepartmentName(record.getDepartmentName());
            result.setDoctorName(record.getDoctorName());
            result.setFailReason(record.getFailReason());
            result.setHospitalName(record.getHospitalName());
            result.setUserName(record.getUserName());
            result.setState(StringUtils.isBlank(record.getFinishTime()) ? AppConstants.RECORD_STATE_WAITING : (StringUtils.isBlank(record.getFailReason()) ? AppConstants.RECORD_STATE_FINISHED : AppConstants.RECORD_STATE_DISCARD));
            results.add(result);
        }
        return results;
    }

}
