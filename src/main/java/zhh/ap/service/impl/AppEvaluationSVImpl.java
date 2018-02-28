package zhh.ap.service.impl;

import org.springframework.stereotype.Service;
import zhh.ap.bean.Evaluation;
import zhh.ap.dao.EvaluationMapper;
import zhh.ap.service.IAppEvaluationSV;

import javax.annotation.Resource;
import java.util.List;

@Service("appEvaluationSV")
public class AppEvaluationSVImpl implements IAppEvaluationSV {
    @Resource
    private EvaluationMapper dao;

    @Override
    public List<Evaluation> selectAll() throws Exception {
        return dao.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Evaluation record) {
        return dao.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Evaluation record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Evaluation selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }
}
