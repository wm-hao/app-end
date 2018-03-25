package zhh.ap.service;

import org.springframework.stereotype.Service;
import zhh.ap.bean.Evaluation;

import java.util.List;
@Service("appEvaluationSV")
public interface IAppEvaluationSV {
    List<Evaluation> selectAll() throws Exception;

    int deleteByPrimaryKey(Integer id);

    int insert(Evaluation record);

    int updateByPrimaryKey(Evaluation record);

    Evaluation selectByPrimaryKey(Integer id);

}
